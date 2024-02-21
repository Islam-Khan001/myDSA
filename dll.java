// Double LinkedList

public class dll {
    private Node head;
    
    dll() {
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
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        newNode.previous = current;
        current.next = newNode;
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

        System.out.print("null <-- ");

        while (current != null) {
            if (current.next == null){
                System.out.print(current.data + " --> ");
                break;                
            }
            System.out.print(current.data + " <--> ");
            current = current.next;
        }
        System.out.println("null");
    }

    void printListboth(Node head) {
        Node current = head;

        System.out.print("Left to Right : null <-- ");

        while (current != null) {
            if (current.next == null){
                // System.out.print(current.data + " --> ");
                break;                
            }
            // System.out.print(current.data + " <--> ");
            current = current.next;
        }
        // System.out.println("null");

        System.out.print("Right to left : ");

        System.out.print("null <-- ");

        while (current != null){
            if (current.previous == null){  // this if block is just for formating the output
                System.out.print(current.data + " --> ");
                break;                  
            }
            System.out.print(current.data + " <--> ");
            current = current.previous;            
        }
        System.out.println("null");
    }

    public Node mergelist(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        if (head1.data < head2.data) {
            head1.next = mergelist(head1.next, head2);
            head2.previous = head1;
            return head1;
        } else {
            head2.next = mergelist(head1, head2.next);
            head1.previous = head2;
            return head2;
        }
    }

    public static void main(String[] args) {
        dll list = new dll();
        dll list1 = new dll();
        dll list2 = new dll();

        list1.addend(1);
        list2.addend(2);
        list1.addend(3);
        list2.addend(4);
        list1.addend(5);
        list1.addend(6);
        list1.addend(7);
        list2.addend(8);

        System.out.print("List1 : ");
        list1.printList(list1.head);

        System.out.print("List2 : ");
        list1.printList(list2.head);

        System.out.print("Both Merged : ");
        list.mergelist(list1.head , list2.head);
        list.printList(list1.head);

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

// merge two sorted double linkedlist

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
