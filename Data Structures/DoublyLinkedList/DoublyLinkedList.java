public class DoublyLinkedList<E> {

    private Node<E> header;
    private Node<E> trailer;
    private int size;

    public DoublyLinkedList() {
        header = new Node<>();
        trailer = new Node<>();
        header.setNext(trailer);
        trailer.setPrev(header);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node<E> getHead() {
        return header.getNext();
    }

    public Node<E> getTail() {
        return trailer.getPrev();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = this.getHead();
        while (current != trailer) {
            sb.append(current.getData() + " ");
            current = current.getNext();
        }
        return sb.toString();
    }

    public Node<E> getAtIndex(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<E> current = this.getHead();
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    public void addBetween(E data, Node<E> prev, Node<E> next) {
        Node<E> newNode = new Node<>(data);
        newNode.setPrev(prev);
        newNode.setNext(next);
        prev.setNext(newNode);
        next.setPrev(newNode);
        size++;
    }

    public void addAtHead(E data) {
        addBetween(data, header, header.getNext());
    }

    public void addAtTail(E data) {
        addBetween(data, trailer.getPrev(), trailer);
    }

    public void addAtIndex(E data, int index) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(data);
        }
        else if (index == size) {
            addAtTail(data);
        }
        else {
            Node<E> prev = getAtIndex(index - 1);
            addBetween(data, prev, prev.getNext());
        }
    }

    public Node<E> delete(Node<E> node) {
        if (node == null) {
            return null;
        }
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        size--;
        return node;
    }

    public Node<E> deleteAtHead() {
        if (isEmpty()) {
            return null;
        }
        return delete(header.getNext());
    }

    public Node<E> deleteAtTail() {
        if (isEmpty()) {
            return null;
        }
        return delete(trailer.getPrev());
    }

    public Node<E> deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        if (index == 0) {
            return deleteAtHead();
        }
        else if (index == size - 1) {
            return deleteAtTail();
        }
        else {
            Node<E> prev = getAtIndex(index - 1);
            return delete(prev.getNext());
        }
    }


    private static class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> prev;

        public Node() {
            data = null;
            next = null;
            prev = null;
        }

        public Node(E data) {
            this.data = data;
            next = null;
            prev = null;
        }

        public Node(E data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(4);
        System.out.println(list.toString());

    }
}
