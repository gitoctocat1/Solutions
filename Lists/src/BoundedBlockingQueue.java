import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue {

	int capacity = 10;

	public BoundedBlockingQueue(int capacity) {
		this.capacity = capacity;
	}

	LinkedList<Object> queue = new LinkedList<Object>();

	public synchronized void enqueue(Object item) throws InterruptedException {

		while (queue.size() == capacity) {
			wait();
		}

		if (queue.isEmpty() || queue.size() < capacity) {
			notifyAll();
		}

		queue.add(item);
	}

	public synchronized Object dequeue() throws InterruptedException {

		// if queue is empty, wait
		while (queue.size() == 0) {
			wait();
		}

		// if queue is full, notify all
		if (queue.size() == capacity) {
			notifyAll();
		}
		// remove first element from the queue
		return this.queue.remove(0);
	}

}


class BoundedBlockingBuffer<E>{
	
	 private final Queue<Object> queue = new LinkedList<Object>();  
	   private final int capacity;  
	   private final AtomicInteger count = new AtomicInteger(0);  
	   
	   private final ReentrantLock putLock = new ReentrantLock();  
	   private final ReentrantLock takeLock = new ReentrantLock();  

	   private final Condition notFull = putLock.newCondition();
	   private final Condition notEmpty = takeLock.newCondition();

	   public BoundedBlockingBuffer(int capacity) throws Exception {  
	     if (capacity <= 0)  throw new Exception("The capacity of the queue must be > 0.");
	     this.capacity = capacity;  
	   }  
	   
	   public int size() {  
	     return count.get();  
	   }  
	   
	   public void add(Object e) throws RuntimeException, InterruptedException {  
	     if (e == null) throw new NullPointerException("Null element is not allowed.");  
	   
	     int oldCount = -1;
	     putLock.lock();  
	     try {  
	       // we use count as a wait condition although count isn't protected by a lock
	       // since at this point all other put threads are blocked, count can only
	       // decrease (via some take thread).
	       while (count.get() == capacity) notFull.await();  
	   
	       queue.add(e);  
	       oldCount = count.getAndIncrement();  
	       if (oldCount + 1 < capacity) {
	         notFull.signal(); // notify other producers for count change 
	       }
	     } finally {  
	       putLock.unlock();  
	     }  

	     // notify other waiting consumers
	     if (oldCount == 0) {
	       takeLock.lock();
	       try {
	         notEmpty.signal();
	       } finally {
	         takeLock.unlock();
	       }
	     }
	   }  
	   
	   public E remove() throws NoSuchElementException, InterruptedException {  
	     E e;  
	   
	     int oldCount = -1;
	     takeLock.lock();  
	     try {  
	       while (count.get() == 0) notEmpty.await();  
	   
	       e = (E) queue.remove();  
	       oldCount = count.getAndDecrement();  
	       if (oldCount > 1) {
	         notEmpty.signal(); // notify other consumers for count change 
	       }
	     } finally {  
	       takeLock.unlock();  
	     }  

	     // notify other waiting producers
	     if (oldCount == capacity) {
	       putLock.lock();
	       try {
	         notFull.signal();
	       } finally {
	         putLock.unlock();
	       }
	     }

	     return e;
	   } 
	 
	   /* Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty. */
	   public E peek() {  
	     if (count.get() == 0) return null;  
	   
	     takeLock.lock();  
	     try {  
	       return (E) queue.peek();  
	     } finally {  
	       takeLock.unlock();  
	     }  
	   }  
	 }  
	

