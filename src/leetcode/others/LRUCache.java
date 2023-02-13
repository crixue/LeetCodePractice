package leetcode.others;


import java.util.HashMap;
import java.util.Map;

class MyNode {
    int key;
    int val;
    MyNode pre;
    MyNode next;

    public MyNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class DoublyLinkedList {

    MyNode head, tail;
    int size;

    public DoublyLinkedList() {
        head = new MyNode(Integer.MIN_VALUE, Integer.MIN_VALUE);
        tail = new MyNode(Integer.MAX_VALUE, Integer.MAX_VALUE);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    public MyNode addLast(MyNode item) {
        item.pre = tail.pre;
        item.next = tail;
        tail.pre.next = item;
        tail.pre = item;

        size ++;
        return item;
    }

    public void remove(MyNode item) {
        if(item == null) return;
        item.pre.next = item.next;
        item.next.pre = item.pre;
        size--;
    }

    public MyNode removeFirst() {
        MyNode fst = head.next;
        if(fst == null) return null;
        head.next = fst.next;
        fst.next.pre = head;
        size--;
        return fst;
    }

}


public class LRUCache {

    int cap;
    DoublyLinkedList ordeList;
    Map<Integer, MyNode> map;

    public LRUCache(int capacity) {
        cap = capacity;
        ordeList = new DoublyLinkedList();
        map = new HashMap<>();
    }

    private void addNew(MyNode x) {
        x = ordeList.addLast(x);
        map.put(x.key, x);
    }

    private void remove(int key) {
        MyNode x = map.get(key);
        map.remove(key);
        ordeList.remove(x);
    }

    private void removeLeastRecently() {
        MyNode x = ordeList.removeFirst();
        map.remove(x.key);
    }

    private void makeRecently(int key, int val) {
        remove(key);
        addNew(new MyNode(key, val));
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        MyNode x = map.get(key);
        makeRecently(key, x.val);
        return x.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            makeRecently(key, value);
            return;
        }

        MyNode x = new MyNode(key, value);
        if(ordeList.size < cap) {
            addNew(x);
        } else {
            removeLeastRecently();
            addNew(x);
        }

    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        int i1 = cache.get(1);
        cache.put(3,3);
        int i = cache.get(2);
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
