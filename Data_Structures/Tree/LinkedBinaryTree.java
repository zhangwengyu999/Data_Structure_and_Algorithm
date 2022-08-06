import java.util.Iterator;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    // --- Inner Node class implements Position<E> ---
    protected static class Node<E> implements Position<E> {
        private E element;
        private Node<E> left;
        private Node<E> right;
        private Node<E> parent;

        public Node(E inElement, Node<E> inLeft, Node<E> inRight, Node<E> inParent) {
            element = inElement;
            left = inLeft;
            right = inRight;
            parent = inParent;
        }

        public E getElement() {
            return element;
        }

        // Getters
        public Node<E> getParent() {
            return parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        // Setters
        public void setElement(E inElement) {
            element = inElement;
        }

        public void setParent(Node<E> inParent) {
            parent = inParent;
        }

        public void setLeft(Node<E> inLeft) {
            left = inLeft;
        }

        public void setRight(Node<E> inRight) {
            right = inRight;
        }
    }
    // --- End of inner Node class ---

    // --- Only two fields inside the Tree class ---
        // 1. reference to the root node
    protected Node<E> root;

        // 2. Variable of tree size
    private int size;

    // --- Constructor for empty tree ---
    public LinkedBinaryTree() {
        root = null;
        size = 0;
    }

    // --- accessor methods ---
    public Position<E> root() {
        return root;
    }

    public int size() {
        return size;
    }

    // Used to check Node's validity before returning it
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Not valid position type");
        }
        Node<E> node = (Node<E>) p; // safe cast !!!
        if (node.getParent() == null) {
            throw new IllegalArgumentException("Position no longer in the tree");
        }
        return node;
    }

    // Return the Position of the parent of Position p, cast Position to Node first using validate()
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    // Return the Position of the left child of Position p, cast Position to Node first using validate()
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    // Return the Position of the right child of Position p, cast Position to Node first using validate()
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }

    // --- update methods ---
    protected Node<E> createNode(E inElement, Node<E> inParent, Node<E> inLeft, Node<E> inRight) {
        return new Node<E>(inElement, inLeft, inRight, inParent);
    }

    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) {
            throw new IllegalStateException("Tree is not empty");
        }
        root = new Node<E>(e, null, null, null);
        size = 1;
        return root;
    }

    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getLeft() != null) {
            throw new IllegalArgumentException("Left child already exists");
        }
        Node<E> leftChild = createNode(e, parent, null, null);
        parent.setLeft(leftChild);
        size++;
        return leftChild;
    }

    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getRight() != null) {
            throw new IllegalArgumentException("Right child already exists");
        }
        Node<E> rightChild = createNode(e, parent, null, null);
        parent.setRight(rightChild);
        size++;
        return rightChild;
    }

    // Replace the element at Position p with e and return the replaced element
    public E set (Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    public void attach(Position<E> p, LinkedBinaryTree<E> ta, LinkedBinaryTree<E> tb) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (isInternal(p)) {
            throw new IllegalArgumentException("p is not a leaf!");
        }
        size += (ta.size() + tb.size());
        if (!ta.isEmpty()) {
            node.setLeft(ta.root);
            ta.root.setParent(node);
            ta.root = null;
            ta.size = 0;
        }
        if (!tb.isEmpty()) {
            node.setRight(tb.root);
            tb.root.setParent(node);
            tb.root = null;
            tb.size = 0;
        }
    }

    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (numChildren(p) == 2) {
            throw new IllegalArgumentException("p has two children");
        }
        Node<E> child = (node.getLeft() != null) ? node.getLeft() : node.getRight();
        // 1. p is a leaf
        if (child != null) {
            child.setParent(node.getParent());
        }
        // 2. p is the root
        if (isRoot(p)) {
            root = child;
        }
        // 3. p is internal with only one child
        else {
            Node<E> parent = node.getParent();
            if (node == parent.getLeft()) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }
        size--;
        E result = node.getElement();
        node.setElement(null); // GC
        node.setLeft(null); // GC
        node.setRight(null); // GC
        node.setParent(node);
        return result;
    }

    // --- traversal methods ---
    public Iterator<E> iterator() {
        // return new PreorderIterator();
        return null;
    }

    public Iterable<Position<E>> positions() {
        // return new Positions();
        return null;
    }
}
