public class SinglyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SinglyLinkedList() {
        head = new Node<>();
        tail = new Node<>();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node<E> getHead() {
        return head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = head;
        while (current != null) {
            sb.append(current.getData() + " ");
            current = current.getNext();
        }
        return sb.toString();
    }

    public Node<E> getAtIndex(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    public void addAtHead(E inData) {
        Node<E> newHead = new Node<>(inData);
        newHead.setNext(head);
        head = newHead;
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addAtTail(E inData) {
        Node<E> newTail = new Node<>(inData);
        newTail.setNext(null);
        if (size == 0) {
            head = newTail;
        }
        else {
            tail.setNext(newTail);
        }
        tail = newTail;
        size++;
    }

    public void addAtIndex(E inData, int index) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(inData);
        }
        else if (index == size) {
            addAtTail(inData);
        }
        else {
            Node<E> newNode = new Node<>(inData);
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            size++;
        }
    }

    public void deleteAtHead() {
        if (size == 0) {
            return;
        }
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = head;
        }
    }


    public void deleteAtIndex(int index) {
        if (size == 0) {
            return;
        }
        if (index == 0) {
            deleteAtHead();
        }
        else if (index >0 && index < size) {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
        }
        size--;
    }

    public void reverse() {
        Node<E> oldHead = this.head;
        while (oldHead != null && oldHead.next != null) {
            Node<E> newHead = oldHead.next;
            oldHead.next = newHead.next;
            newHead.next = this.head;
            this.head = newHead;
        }
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
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(4);
        System.out.println(list.toString());
        list.reverse();
        System.out.println(list.toString());
    }
}
