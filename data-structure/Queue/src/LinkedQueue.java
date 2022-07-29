public class LinkedQueue<E> implements Queue<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<E>();
    public LinkedQueue() {}
    public int size() {
        return list.getSize();
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public void enqueue(E element) {
        list.addAtTail(element);
    }
    public E dequeue() {
        return list.deleteAtHead();
    }
    public E first() {
        return list.getHead();
    }
    public String toString() {
        return "first ->"+list.toString()+"<- tail";
    }

    public static void main(String[] arg) {
        Queue<Integer> queue = new LinkedQueue<>();
        System.out.println(queue.isEmpty()); // true
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.size()); // 3
        System.out.println(queue.toString()); // 1 2 3
        System.out.println(queue.first()); // 1
        System.out.println(queue.dequeue()); // 1
        System.out.println(queue.first()); // 2
        queue.enqueue(4);
        System.out.println(queue.toString()); // 2 3 4
    }
}
