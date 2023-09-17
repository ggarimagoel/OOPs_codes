package HashSet;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class HashSet<T> {

    private int size;
    private static final int capacity = 16;
    private LinkedList<T>[] buckets;

    public HashSet(){
        int size = 0;
        buckets =new LinkedList[capacity];
        for(int  i = 0; i < capacity; i++){
            buckets[i] = new LinkedList<>();
        }
    }
    private int getBucketIdx(T t){
        return Math.abs(t.hashCode() % buckets.length);
    }

    public void add(T t){
        int idx = getBucketIdx(t);
        LinkedList<T> list = buckets[idx];

        for(T val : list){
            if(val.equals(t)){
                return;
            }
        }
        list.add(t);
        size++;
    }
    public boolean contains(T t){
        int idx = getBucketIdx(t);
        LinkedList<T> list = buckets[idx];

        for(T val : list){
            if(val.equals(t)){
                return true;
            }
        }
        return false;
    }
    public void remove(T t){
        int idx = getBucketIdx(t);
        LinkedList<T> list = buckets[idx];

        for(T val : list){
            if(val.equals(t)){
                list.remove(t);
                size--;
            }
        }
    }
    public int size(){
        return size;
    }
}
