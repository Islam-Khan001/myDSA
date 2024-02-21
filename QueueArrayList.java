
// add remove peek
import java.util.ArrayList;

public class QueueArrayList {

    static class Queue {
        ArrayList<Integer> list = new ArrayList<>();

        boolean isEmpty() {
            return list.isEmpty();
        }

        void add(int data) {
            list.add(data);
        }

        void addFirst(int data) {
            list.add(0, data);
        }

        int peek() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(0);
        }

        int remove() {
            if (isEmpty()) {
                return -1;
            }
            int currData = list.remove(0);
            return currData;
        }
    }

    public static void main(String[] args) {
        // QueueArrayList myQueue = new QueueArrayList();
        Queue myQueue = new Queue();
        Queue myQueue1 = new Queue();

        myQueue.add(11);
        myQueue.add(21);
        myQueue.add(31);
        myQueue.add(41);
        myQueue.addFirst(100);
        myQueue.add(51);
        myQueue.add(61);

        myQueue1.add(11);
        myQueue1.add(21);
        myQueue1.add(31);
        myQueue1.add(41);
        myQueue1.add(51);
        myQueue1.add(61);

        while (!myQueue.isEmpty()) {
            System.out.println(myQueue.peek());
            myQueue.remove();
        }

        System.out.println("\nQueue2 : ");

        while (!myQueue1.isEmpty()) {
            System.out.println(myQueue1.peek());
            myQueue1.remove();
        }
    }
}

// Learned from this
// how to implement with ArrayList
// What change can a static keyword make
// When should we make our class static