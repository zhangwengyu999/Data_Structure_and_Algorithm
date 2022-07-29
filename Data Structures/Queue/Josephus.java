public class Josephus {
    public static <E> E Josephus(CircularQueue<E> queue, int m) {
        if (queue.isEmpty()) {
            return null;
        }
        while (queue.size() > 1) {
            for (int i=0; i < m-1; i++) {
                queue.rotate();
            }
            E out = queue.dequeue();
            System.out.println(out+" OUT");
        }
        return queue.dequeue();
    }

    public static <E> CircularQueue<E> buildCircularQueue(E inList[]) {
        CircularQueue<E> queue = new LinkedCircularQueue<>( );
        for (int j=0; j<inList.length;j++) {
            queue.enqueue(inList[j]);
        }
        return queue;
    }

    public static void main(String[] arg) {
        String[] players = {"Alice", "Bob", "Cindy", "Doug", "Ed", "Fred"};
        System.out.println(Josephus(buildCircularQueue(players),2)+" WIN");
    }
}
