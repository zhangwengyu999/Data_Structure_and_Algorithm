public class ArrayQueue<E> implements Queue<E> {

    private E[] data; // Using array to store elements in the Queue
    private static final int CAPACITY = 100; // Default capacity 100
    private int f = 0; // indicate the index of the first element of Queue in the array
    private int size = 0; // indicate the number of elements in the Queue

    public ArrayQueue() {
        this(CAPACITY);
    }
    public ArrayQueue(int inSize) {
        data = (E[]) new Object[inSize];
    }

    public int size() { // return the size of the Queue
        return size;
    }

    public boolean isEmpty() { // check whether the Queue si empty or not
        return (size == 0);
    }

    public void enqueue(E e) throws IllegalStateException{ // Add an element to the back of the queue
        if (size == data.length) { // check whether the queue is full
            throw new IllegalStateException("The queue is full!");
        }
        else {
            int pos = (f + size) % data.length; // get the position of the tail
            data[pos] = e;
            size ++;
        }
    }

    public E dequeue(){ // Remove and return the first element of the queue
        if (isEmpty()) { // Check whether the queue is empty or not
            return null;
        }
        else {
            E out = data[f];
            data[f] = null;
            f = (f + 1) % data.length; // let the front point to the next position
            size --;
            return out;
        }
    }

    public E first() { // return the front element of the queue
        if (isEmpty()) {
            return null;
        }
        else {
            return data[f];
        }
    }

    public String toString() {
        String outString = "front -> ";
        for (int i = 0; i < size; i++) {
            int ind = (i+f)% data.length;
            outString = outString + data[ind] + " ";
        }
        outString = outString + "<- tail";
        return outString;
    }

    public static void main(String[] arg) {
        Queue<Integer> queue = new ArrayQueue<Integer>();
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
