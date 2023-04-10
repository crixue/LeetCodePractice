package leetcode.others;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LFUCache {

    private int minFreq = 0;
    private int capacity;
    private Map<Integer /*freq*/, LinkedList<LFUCacheNode> /*which keys*/> m1 = new HashMap<>();
    private Map<Integer/*key*/, LFUCacheNode> m2 = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    private int getNodeVal(int key, Integer newVal) {
        LFUCacheNode node = m2.get(key);
        int freq = node.freq;
        if (m1.get(freq).size() == 1) {
            m1.remove(freq);
            if (minFreq == freq) {
                minFreq += 1;
            }
        } else {
            m1.get(freq).remove(node);
        }
        freq += 1;
        node.freq = freq;
        if (!m1.containsKey(freq)) {
            m1.put(freq, new LinkedList<>());
        }
        if (newVal != null) {
            node.value = newVal;
        }
        m2.put(key, node);
        m1.get(freq).addLast(node);

        return node.value;
    }

    public int get(int key) {
        if (!m2.containsKey(key)) {
            return -1;
        }
        return getNodeVal(key, null);
    }

    private void removeLFUNode() {
        LinkedList<LFUCacheNode> nodes = m1.get(minFreq);
        LFUCacheNode leastUsedNode = nodes.removeFirst();
        if (nodes.isEmpty()) {
            m1.remove(minFreq);
            minFreq = 1;  //because when add new K-V pairs,it must be the first time
        }
        m2.remove(leastUsedNode.key);
    }

    private void addNewNode(int key, int value) {
        int freq = 1;
        LFUCacheNode node = new LFUCacheNode(key, value, freq);
        minFreq = freq;
        if (!m1.containsKey(freq)) {
            m1.put(freq, new LinkedList<>());
        }

        m1.get(freq).addLast(node);
        m2.put(key, node);
    }

    public void put(int key, int value) {
        if (m2.containsKey(key)) {
            getNodeVal(key, value);
            return;
        }

        if(m2.size() >= capacity) {
            removeLFUNode();
        }
        addNewNode(key, value);
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }

}

class LFUCacheNode {
    int key;
    int value;
    int freq;

    public LFUCacheNode(int key, int value, int freq) {
        this.key = key;
        this.value = value;
        this.freq = freq;
    }
}
