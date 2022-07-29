public class CircularlyLinkedList<E> {
    private Node<E> tail;
    private int size;

    public CircularlyLinkedList() {
        tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node<E> getTail() {
        return tail;
    }

    public Node<E> getHead() {
        if (tail == null) {
            return null;
        }
        return tail.next;
    }

    public E getHeadData() {
        return getHead().data;
    }

    public String toString() {
        if (isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Node<E> current = getHead();
        sb.append(current.getData() + " ");
        current = current.getNext();
        while (current != getHead()) {
            sb.append(current.getData() + " ");
            current = current.getNext();
        }
        return sb.toString();
    }

    public void rotate() {
        if (tail != null) {
            tail = tail.next;
        }
    }

    public void addAtHead (E e) {
        Node<E> newNode = new Node<E>(e);
        if (size == 0) {
            tail = newNode;
            tail.setNext(tail);
        }
        else {
            newNode.next = tail.getNext();
            tail.setNext(newNode);
        }
        size++;
    }

    public void addAtTail (E e) {
        addAtHead(e);
        tail = tail.next;
    }

    public void addAtIndex (int index, E e) {
        if (index == 0) {
            addAtHead(e);
        }
        else if (index == size) {
            addAtTail(e);
        }
        else {
            Node<E> current = getHead();
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node<E> newNode = new Node<E>(e);
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    public void deleteAtIndex (int index) {
        if (isEmpty()) {
            return;
        }
        if (index == 0) {
            if (size == 1) {
                tail = null;
            }
            else {
                tail.setNext(tail.next.next);
            }
        }
        else if (index>0 && index<size) {
            Node<E> current = getHead();
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            size--;
        }
    }

    public E deleteAtHead(){
        E out = null;
        if (size == 1) {
            out = tail.data;
            tail = null;
        }
        else {
            out = tail.next.data;
            tail.setNext(tail.next.next);
        }
        size--;
        return out;
    }

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node() {
            data = null;
            next = null;
        }

        public Node(E data) {
            this.data = data;
            next = null;
        }

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();
        System.out.println(list.toString());
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(4);
        System.out.println(list.toString());
        list.rotate();
        System.out.println(list.toString());
    }
}
