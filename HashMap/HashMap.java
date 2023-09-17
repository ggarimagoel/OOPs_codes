package HashMap;

import java.util.LinkedList;

public class HashMap <K , V>{
    private int size;
    private static final int capacity = 16;
    private LinkedList<Node>[] buckets;

    public HashMap(){
        buckets = new LinkedList[capacity];
        for(int i = 0; i < capacity; i++){
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }

    // to find the idx of arr(of LL) , where <K,V> pair is to be added/lookedup  we use hashcode;
    private int getBucketIdx(K key){
        return Math.abs(key.hashCode() % buckets.length);
    }

    // rehashing is increasing the size of bucket array, when the number of bucked attached has reached its capacity i.e. 16 here

    private void rehash() {
        LinkedList<Node>[] oldList = buckets;
        buckets = new LinkedList[buckets.length * 2]; // increasing the arr size by 2 times
        for (int i = 0; i < buckets.length; i++) {  // adding empty LinkedList at each idx
            buckets[i] = new LinkedList<>();
        }
        size = 0;    // initially no buckets is attached to any idx in array , so size of HashMap = 0

        for (LinkedList<Node> list : oldList) {    // iterating over each LL at each idx
            for (Node node : list) {               // iterating over each node in the LL
                put((K) node.key, (V) node.value);// populating new HM with old nodes
            }
        }
    }

    public void put(K key, V value) {
        int idx = getBucketIdx(key);
        LinkedList<Node> list = buckets[idx]; // get the LL from idx


        // iterate over all nodes of that list and if key is already present change its value, if not add the  <K,V> pair
        for (Node node : list) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        list.add(new Node<>(key, value));
        size++;   // increase the size of HM after adding node
    }

    public V get(K key) {
        int idx = getBucketIdx(key);
        LinkedList<Node> list = buckets[idx];

        for (Node node : list) {
            if (node.key.equals(key)) {
                return (V) node.value;
            }
        }
        return null;
    }

    public void remove(K key){
        int idx = getBucketIdx(key);
        LinkedList<Node> list = buckets[idx];

        for(Node node : list){
            if (node.key.equals(key)) {
                list.remove(node);
            }
        }
        size--;
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
}
