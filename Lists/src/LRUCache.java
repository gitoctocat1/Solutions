import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCache {
    
    private int capacity;
    private Map<Integer, Integer> map = new HashMap<Integer,Integer>();
    private Queue<Integer> q = new LinkedList<Integer>();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            q.remove(key);
            q.offer(key);
            return map.get(key);
        }
        else
            return -1;
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key,value);
            q.remove(key);
            q.offer(key);
        } else {
            if (map.size() < capacity) {
                map.put(key,value);
                q.offer(key);
            } else {
                int k = q.poll();
                map.remove(k);
                q.offer(key);
                map.put(key,value);
            }
        }
    }
}
