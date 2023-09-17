package Iterable_Iterator;

import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {
    private Node<E> head;
    private int size;
    private class Node<E>{
        private E data;
        private Node<E> next;

        public Node(E data){
            this.data = data;
            this.next = null;
        }
    }
    public LinkedList(){
        head = null;
        size = 0;
    }

    public void add(E data){
        Node<E> newNode = new Node<>(data);
        if(head == null){
            head = newNode;
        }else{
            Node<E> current = head;
            while(current.next != null ){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void remove(E data){
        Node<E> newNode = new Node<>(data);
        if(head == null){
            return;
        }
       if(head.data.equals(data)) {
           head = head.next;
           size--;
           return;
       }
       Node<E> curr = head;
       while(curr.next != null){
           if(curr.next.data.equals(data)){
               curr.next = curr.next.next;
               size--;
               return;
           }
           curr = curr.next;
       }
    }

    public int size(){
        return size;
    }
    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }
    // .iterator is method of LL , which returns LLIterator().


    private class LinkedListIterator implements Iterator<E>{
        private Node<E> current = head ;
        /* here current = head is important,
        because when we add value to LL value to head is assigned first,
        if we do not specify curr as head , values will not be added in LL.
        (check add method of LL, head is needed there)
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        public  E next(){
            E data = current.data;
            current= current.next;
            return data;
        }
    }
}
