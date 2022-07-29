public class LinkedCircularQueue <E> implements CircularQueue<E> {
    private CircularlyLinkedList<E> list = new CircularlyLinkedList<>();
    public LinkedCircularQueue() {}
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
        return list.getHeadData();
    }

    public void rotate() {
        list.rotate();
    }

    public String toString() {
        return "first ->"+list.toString()+"<- tail";
    }

    public static void main(String[] arg) {
        CircularQueue<Integer> queue = new LinkedCircularQueue<>();
        System.out.println(queue.isEmpty()); // true
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.toString()); // 1 2 3
        queue.rotate();
        System.out.println(queue.toString()); // 2 3 1

        System.out.println(queue.dequeue()); // 2
        queue.enqueue(4);
        System.out.println(queue.toString()); // 3 1 4
    }
}
