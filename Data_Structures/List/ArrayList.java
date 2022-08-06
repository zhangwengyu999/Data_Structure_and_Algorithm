import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E>, Iterable<E> {
    private E[] data;
    private int size = 0;
    private static final int CAPACITY = 16;

    public ArrayList() {
        this(CAPACITY);
    }
    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }

    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    public void add(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size + 1);
        if (size == data.length) {
            throw new IllegalStateException("Array is full");
            // resize(2 * data.length); // Dynamic Array Resizing
        }
        for (int j=size-1; j>=i; j--) {
            data[j + 1] = data[j];
        }
        data[i] = e;
        size++;
    }

    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        for (int j = i; j < size - 1; j++) {
            data[j] = data[j + 1];
        }
        data[size] = null;
        size--;
        return temp;
    }

    private void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Illegal index: " + i);
        }
    }

    // Dynamic Array Resizing
    private void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    // Nested ArrayIterator Class
    // Lazy implementation of Iterator of List<E>
    private class ArrayIterator implements Iterator<E> {
        private int current = 0;
        private boolean isMoved = false;

        public boolean hasNext() {
            return current < size;
        }
        public E next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return data[current++];
        }
        public void remove() throws IllegalStateException {
            if (isMoved) {
                throw new IllegalStateException();
            }
            ArrayList.this.remove(--current);
            isMoved = true;
        }
    }

    public Iterator<E> iterator() {
        return new ArrayIterator();
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<> ();
        arr.add(0, 1);
        arr.add(1, 2);
        arr.add(2, 3);

        System.out.println("Method 1:");
        for (int i : arr) {
            System.out.println(i);
        }

        System.out.println("Method 2:");
        Iterator<Integer> iter = arr.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
