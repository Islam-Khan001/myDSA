  
public class mergellisttry {
    private Node head;
    // private Node previous;

    mergellisttry() {
        this.head = null;
    }

    static class Node {
        private int data;
        private Node next;
        private Node previous;

        Node(int data) {
            this.previous = null;
            this.data = data;
            this.next = null;
        }
    }

    void addstart(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.previous = null;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    void addend(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            // head.previous = null; // this too, becaude we already did this in Node class
            head.previous.next = head;
            // head.next = null; // i dont think we wanna use this line
            head.next.previous = head;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        newNode.previous = current;
        newNode.next.previous = newNode;
    }

    void noderev(Node current, Node previous) {
        if (current != null) {
            Node nextNode = current.next;
            current.next = previous;

            if (nextNode == null) {
                head = current;
                return;
            }

            noderev(nextNode, current);
        }
    }

    void insertNode(int data, int idx) {
        if (idx <= 1) {
            addstart(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        int i = 1;
        while (current.next != null && i < idx - 1) {
            current = current.next;
            i++;
        }

        Node nextNode = current.next;
        current.next = newNode;
        newNode.next = nextNode;
    }

    void printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public Node mergelist(Node head1, Node head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        if (head1.data < head2.data) {
            head1.next = mergelist(head1.next, head2);
            return head1;
        } else {
            head2.next = mergelist(head1, head.next);
            return head2;
        }
    }

    public static void main(String[] args) {
        mergellisttry list = new mergellisttry();
        mergellisttry list1 = new mergellisttry();
        mergellisttry list2 = new mergellisttry();

        list1.addend(1);
        list2.addend(2);
        list1.addend(3);
        list2.addend(4);
        list1.addend(5);
        list2.addend(6);
        list2.addend(7);
        list1.addend(8);

        System.out.println(list.head);

        // System.out.print("First List : ");
        // list1.printList(list1.head);

        // System.out.print("Second List : ");
        // list1.printList(list2.head);
        // list.mergelist(list1.head, list2.head);

        // list1.printList(list1.head);

        // list1.insertNode("e", 5);
        // System.out.print("Insert e : ");
        // list1.printList();

        // list1.noderev(list1.head, null);
        // System.out.print("Reversed : ");
        // list1.printList();

    }
}

// Qurstion why head2.next is updating without any reason

// void mergelist(Node head1, Node head2) {
// Node current1 = head1;
// Node current2 = head2;
// if (head1 != null || head2 != null) {

// if (current1.next == null || current2.next == null) {
// return;
// }

// if (current1.data <= current2.data) {
// Node nextnode;
// nextnode = current1.next;
// current1.next = current2;
// current1.next.next = nextnode; // the problem is here, why head2.next is
// changing
// }
// mergelist(current1.next, head2.next);

// }
// }
