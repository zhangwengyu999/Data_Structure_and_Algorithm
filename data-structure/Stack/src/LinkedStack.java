public class LinkedStack<E> implements Stack<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<E>();
    public LinkedStack() {}
    public int size() {
        return list.getSize();
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public void push(E element) {
        list.addAtHead(element);
    }
    public E pop() {
        return list.deleteAtHead();
    }
    public E top() {
        return list.getHead();
    }
    public String toString() {
        return "top ->"+list.toString()+"<- bottom";
    }

    public static boolean isMatched(String expression) {
        Stack<Character> stack = new LinkedStack<Character>();
        String opening = "([{";
        String closing = ")]}";
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (opening.indexOf(c) != -1) {
                stack.push(c);
            }
            else if (closing.indexOf(c) != -1) {
                if (stack.isEmpty()) {
                    return false;
                }
                else if (closing.indexOf(c) != opening.indexOf(stack.pop())) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new LinkedStack<Integer>();
        System.out.println(stack.isEmpty()); // true
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.size()); // 3
        System.out.println(stack.toString()); // top ->3 2 1 <- bottom
        System.out.println(stack.pop()); // 3
        System.out.println(stack.toString()); // top ->2 1 <- bottom
        System.out.println(stack.top()); // 2

        System.out.println(isMatched("()")); // true
        System.out.println(isMatched("[([]){()}]")); // true
        System.out.println(isMatched("[([{()}]")); // false
        System.out.println(isMatched("{[(}")); // false


    }
}
