import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalList<E> implements PositionList<E>, Iterable<E> {

    // Nested Node Class to implement position
    private static class Node<E> implements Position<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }
        public E getElement() throws IllegalStateException {
            if (next == null) {
                throw new IllegalStateException("Position no longer valid");
            }
            return element;
        }
        public Node<E> getPrev() {
            return prev;
        }
        public Node<E> getNext() {
            return next;
        }
        public void setPrev(Node<E> p) {
            prev = p;
        }
        public void setNext(Node<E> n) {
            next = n;
        }
        public void setElement(E e) {
            element = e;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public LinkedPositionalList() {
        header = new Node<E>(null, null, null);
        trailer = new Node<E>(null, header, null);
        header.setNext(trailer);
    }

    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Invalid position");
        }
        Node<E> node = (Node<E>) p; // safe cast !!!
        if (node.getNext() == null) {
            throw new IllegalArgumentException("Position no longer in the list");
        }
        return node;
    }

    private Position<E> position(Node<E> node) {
        if (node == header || node == trailer) {
            return null; // Keep sentinel node unseen by users
        }
        return node;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Position<E> first() {
        return position(header.getNext());
    }

    public Position<E> last() {
        return position(trailer.getPrev());
    }

    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }

    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getNext());
    }

    // Keep addBetween() method private to prevent client from calling it directly, it is a dangerous operation!!!
    private Position<E> addBetween(E e, Node<E> before, Node<E> after) {
        Node<E> node = new Node<E>(e, before, after);
        before.setNext(node);
        after.setPrev(node);
        size++;
        return node;
    }

    public Position<E> addFirst(E e) {
        return addBetween(e, header, header.getNext());
    }

    public Position<E> addLast(E e) {
        return addBetween(e, trailer.getPrev(), trailer);
    }

    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }

    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }

    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E ele = node.getElement();
        node.setElement(e);
        return ele;
    }

    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> before = node.getPrev();
        Node<E> after = node.getNext();
        before.setNext(after);
        after.setPrev(before);
        size--;
        E ele = node.getElement();
        node.setElement(null); // GC
        node.setPrev(null); // GC
        node.setNext(null); // GC
        return ele;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Header -> ");
        Position<E> p = first();
        while (p != null) {
            sb.append(p.getElement());
            p = after(p);
            if (p != null) {
                sb.append(", ");
            }
        }
        sb.append(" <- Trailer");
        return sb.toString();
    }

    // Lazy iterator implementation for positions
    private class PositionIterator implements Iterator<Position<E>> {
        private Position<E> current = first();
        private Position<E> oneMoved = null;
        public boolean hasNext() {
            return current != null;
        }
        public Position<E> next() throws NoSuchElementException {
            if (current == null) {
                throw new NoSuchElementException();
            }
            oneMoved = current;
            current = after(current);
            return oneMoved;
        }
        public void remove() throws IllegalStateException {
            if (oneMoved == null) {
                throw new IllegalStateException();
            }
            LinkedPositionalList.this.remove(oneMoved);
            oneMoved = null;
            throw new UnsupportedOperationException();
        }
    }

    // constructs and returns a new PositionIterator object
    // each time its iterator( ) method is called
    public class PositionIterable implements Iterable<Position<E>> {
        public Iterator<Position<E>> iterator() {
            return new PositionIterator();
        }
    }

    // returns an Iterable object that can be used to iterate over the positions of the list
    public Iterable<Position<E>> positions() {
        return new PositionIterable();
    }

    private class ElementIterator implements Iterator<E> {
        private Iterator<Position<E>> posIterator = new PositionIterator();
        public boolean hasNext() {
            return posIterator.hasNext();
        }
        public E next() throws NoSuchElementException {
            return posIterator.next().getElement();
        }
        public void remove() throws IllegalStateException {
            posIterator.remove();
        }
    }

    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    public static void main(String[] args) {
        LinkedPositionalList<Integer> list = new LinkedPositionalList<Integer>();
        Position<Integer> p1 = list.addFirst(1);
        Position<Integer> p2 = list.addAfter(p1, 2);
        Position<Integer> p3 = list.addAfter(p2, 3);

        System.out.println("Method 1:");
        for (Integer i : list) {
            System.out.println(i);
        }

        System.out.println("Method 2:");
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("Method 3:");
        for (Position<Integer> p : list.positions()) {
            System.out.println(p);
        }

        System.out.println("Method 4:");
        Iterator<Position<Integer>> pt = list.positions().iterator();
        while (pt.hasNext()) {
            System.out.println(pt.next());
        }

//        System.out.println(list.toString());
//        System.out.println(list.size());
//        System.out.println(list.isEmpty());
//        System.out.println(list.first().getElement());
//        System.out.println(list.last().getElement());
//        System.out.println(list.before(p3).getElement());
//        System.out.println(list.after(p1).getElement());
//        Position<Integer> p5 = list.addLast(5);
//        System.out.println(list.toString());
//        list.addBefore(p5, 4);
//        System.out.println(list.toString());
//        list.set(p5, 6);
//        System.out.println(list.toString());
//        list.remove(p3);
//        System.out.println(list.toString());
    }
}
