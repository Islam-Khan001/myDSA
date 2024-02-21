// add remove peek

public class QueueLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        Node head;
        Node tail;

        boolean isEmpty() {
            return head == null;
        }

        void add(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        void addFirst(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
            }
            newNode.next = head;
            head = newNode;
        }

        int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }

        int remove() {
            if (isEmpty()) {
                return -1;
            }
            Node headNode = head;
            head = head.next;
            return headNode.data;
        }

        void performFIFO() {
            while (!isEmpty()) {
                System.out.println(peek());
                remove();
            }
        }

        void reverseQueue() {
            if (isEmpty() || head.next == null) {
                return;
            }
            int currentData = remove();
            reverseQueue();
            add(currentData);
        }
    }

    public static void main(String[] args) {
        // QueueLinkedList t = new QueueLinkedList();
        Queue myQueue = new Queue();

        myQueue.add(100);
        myQueue.add(200);
        myQueue.add(300);
        myQueue.add(400);
        myQueue.addFirst(500);

        // myQueue.reverseQueue();
        myQueue.performFIFO();

    }
}

// Learned from this
// make inner classes static so that you dont have to use the name of outer class when making a object of it
// nothing much just used tail as a tracker variable to save the effort to traverse the whole linked list to add new element