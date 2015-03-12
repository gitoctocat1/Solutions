import java.util.HashMap;

public class LRUCache {
	
	private HashMap<Integer, DoubleLinkedListNode> cache = new HashMap<Integer, DoubleLinkedListNode>();
	
	private DoubleLinkedListNode head;
	private DoubleLinkedListNode end;
	
	private int capacity;
	private int len;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		len = 0;
	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			DoubleLinkedListNode latest = cache.get(key);
			removeNode(latest);
			setHead(latest);
			return latest.val;
		} else {
			return -1;
		}
	}

	public void removeNode(DoubleLinkedListNode node) {
		
		DoubleLinkedListNode cur = node;
		DoubleLinkedListNode pre = cur.pre;
		DoubleLinkedListNode post = cur.next;

		if (pre != null) {
			pre.next = cur.next;
		} else {
			head = post;
		}

		if (post != null) {
			post.pre = cur.pre;
		} else {
			end = cur.pre;
		}
	}

	public void setHead(DoubleLinkedListNode node) {
		//reset pointers for node
		node.next = head;
		node.pre = null;
		
		if (head != null) {
			head.pre = node;
		}
        //reset to new head
		head = node;
		
		//if only one element
		if (end == null) {
			end = node;
		}
	}

	public void set(int key, int value) {
		
		//overwrite cache
		if (cache.containsKey(key)) {
			DoubleLinkedListNode oldNode = cache.get(key);
			oldNode.val = value;
			removeNode(oldNode);
			setHead(oldNode);
			
		} else {
			
			//insert into cache if it is not full
			DoubleLinkedListNode newNode = new DoubleLinkedListNode(key, value);
			if (len < capacity) {
				setHead(newNode);
				cache.put(key, newNode);
				len++;
			} else {
				//cache is full
				cache.remove(end.key);
				end = end.pre;
				if (end != null) {
					end.next = null;
				}

				setHead(newNode);
				cache.put(key, newNode);
				//removed one element and added one element. so no need to adjust length
			}
		}
	}
}

class DoubleLinkedListNode {
	public int val;
	public int key;
	public DoubleLinkedListNode pre;
	public DoubleLinkedListNode next;

	public DoubleLinkedListNode(int key, int value) {
		val = value;
		this.key = key;
	}
}