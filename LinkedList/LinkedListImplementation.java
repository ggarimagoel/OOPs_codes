package LinkedList;


public class LinkedListImplementation<E>  {

    private Node<E> head;
    private int size;

    public LinkedListImplementation(){
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
}
