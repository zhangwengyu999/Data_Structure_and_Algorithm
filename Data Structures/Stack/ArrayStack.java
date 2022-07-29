import java.util.Arrays;

public class ArrayStack<E> implements Stack<E> {
    private static final int SIZE = 100; // Default array size
    private E[] elements; // Using array to store elements in the Stack
    private int t = -1; // Start index of the top
    public ArrayStack() { // Default constructor
        this(SIZE);
    }
    public ArrayStack(int inSize) { // Constructor with size
        elements = (E[]) new Object[inSize];
    }
    public int size() { // Return the size of the Stack
        return t+1;
    }
    public boolean isEmpty() { // Return true if the Stack is empty
        return t == -1;
    }
    public void push(E inElement) { // Push an element into the Stack
        if (size() == elements.length) { // Check whether the Stack is full
            throw new RuntimeException("Stack is full");
        }
        t = t + 1; // Increase the index of the top
        elements[t] = inElement; // Put the element into the Stack
    }
    public E pop() { // Pop an element from the Stack
        if (isEmpty()) {
            return null;
        }
        E outElement = elements[t]; // Get the element from the top
        elements[t] = null; // Set the element to null for garbage collection
        t = t - 1; // Decrease the index of the top
        return outElement;
    }

    public E top() { // Return the element from the top
        if (isEmpty()) {
            return null;
        }
        return elements[t]; // Get the element from the top
    }

    public String toString() {
        String outString = "bottom -> ";
        for (int i = 0; i <= t; i++) {
            outString = outString + elements[i] + " ";
        }
        outString = outString + "<- top";
        return outString;
    }

    public static <E> void reverse(E[] inArr) {
        Stack<E> stack = new ArrayStack<E>();
        for (int i = 0; i < inArr.length; i++) {
            stack.push(inArr[i]);
        }
        for (int i = 0; i < inArr.length; i++) {
            inArr[i] = stack.pop();
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<Integer>();
        System.out.println(stack.isEmpty()); // true
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.size()); // 3
        System.out.println(stack.toString()); // tail -> 1 2 3 <- top
        System.out.println(stack.pop()); // 3
        System.out.println(stack.toString()); // tail -> 1 2 <- top
        System.out.println(stack.top()); // 2

        Integer[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4, 5]
        reverse(arr);
        System.out.println(Arrays.toString(arr)); // [5, 4, 3, 2, 1]
    }
}
