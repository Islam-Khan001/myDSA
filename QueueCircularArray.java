// add remove peek
public class QueueCircularArray {

    static class Queue {
        int[] arr;
        int size;
        int front = -1;
        int rear = -1;

        Queue(int size) {
            arr = new int[size];
            this.size = size;
        }

        boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        boolean isFull() {
            return (rear + 1) % size == front;
        }

        int peek() {
            if (isEmpty()) {
                return -1;
            }
            return arr[front];
        }

        void add(int data) {
            if (isFull()) {
                performFIFO();
                System.out.println("Cannot add More ELements, The Array Is Full");
                return;
            }
            if (isEmpty()) {
                front = 0;
                rear++;
                arr[rear] = data;
                return;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        void addFirst(int data) {
            if (isFull()) {
                performFIFO();
                System.out.println("Cannot add More ELements, The Array Is Full");
                return;
            }
            if (isEmpty()) {
                arr[0] = data;
                front = 0;
                rear = (rear + 1) % size;
            }

            arr[0] = data;
            // rear++;
        }

        int remove() {
            if (isEmpty()) {
                return -1;
            }
            int currElement = arr[front];
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return currElement;
        }

        void performFIFO() {
            while (!isEmpty()) {
                System.out.println(peek());
                remove();
            }
        }

        void reverseQueue() {
            if (isEmpty()) {
                return;
            }
            int currData = remove();
            reverseQueue();
            add(currData);
        }
    }

    public static void main(String[] args) {
        // QueueCircularArray t = new QueueCircularArray();
        Queue myQueue = new Queue(5);

        myQueue.add(150);
        System.out.println(myQueue.remove());
        myQueue.add(151);
        System.out.println(myQueue.remove());
        myQueue.add(152);
        System.out.println(myQueue.remove());
        myQueue.add(153);
        myQueue.add(154);
        myQueue.add(155);
        myQueue.add(156);
        myQueue.add(157);
        // myQueue.addFirst(158);

        // myQueue.addFirst(155);

        // System.out.println("Front : " + myQueue.arr[myQueue.front]);
        // System.out.println("Rear : " + myQueue.arr[myQueue.rear]);

        // myQueue.reverseQueue();
        myQueue.performFIFO();
    }
}

// implement Queue by using two stacks