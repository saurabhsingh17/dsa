import java.util.*;

public class LRUCache {
        TreeMap<Integer,Integer> keyFreq = new TreeMap<>();
        HashMap<Integer,Integer> cache = new HashMap<>();
        int capacity;
        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if(keyFreq.containsKey(key)){
                keyFreq.put(cache.get(key) + 1,key);
                keyFreq.values().stream().findFirst().get();
                return keyFreq.get(key);
            }
            else return -1;
        }

        public void put(int key, int value) {

            if (cache.size() == capacity){
                //cache exceeds capacity
                cache.remove(1);
            }
            else{
                cache.put(key,value);
            }

        }
        public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
            List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
            list.sort(Map.Entry.comparingByValue());

            Map<K, V> result = new LinkedHashMap<>();
            for (Map.Entry<K, V> entry : list) {
                result.put(entry.getKey(), entry.getValue());
            }

            return result;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

