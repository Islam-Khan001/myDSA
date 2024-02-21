class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

public class llrev {
    Node head;

    public static void main(String[] args) {
        llrev list = new llrev();

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        list.printLinkedList(head);
        list.reverseLinkedList(head);
        list.printLinkedList(head);
    }

    Node reverseLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node node = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        printLinkedList(head);
        return node;
    }

    void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

// class Node {
// Node head;
// int value;
// Node next;

// public Node(int value) {
// this.value = value;
// }
// }

// public class llrev {
// private Node head;

// public Node reverseLinkedList(Node head) {
// // Base case: empty list or a single node
// if (head == null || head.next == null) {
// return head;
// }

// // Recursively reverse the rest of the linked list
// Node reversedList = reverseLinkedList(head.next);

// // Adjust pointers to reverse the current node
// head.next.next = head;
// head.next = null;

// return reversedList;
// }

// void printLinkedList(){
// Node current = head;
// while (current != null){
// System.out.print(current.value + " -> ");
// }
// System.out.println("null");
// }

// // Example usage:
// public static void main(String[] args) {
// // Assuming you have a linked list like: 1 -> 2 -> 3 -> 4 -> 5
// // Create the linked list:
// Node head = new Node(1);
// head.next = new Node(2);
// head.next.next = new Node(3);
// head.next.next.next = new Node(4);
// head.next.next.next.next = new Node(5);

// // Reverse the linked list:
// llrev reversal = new llrev();
// reversal.printLinkedList();
// Node newHead = reversal.reverseLinkedList(head);
// }
// }
