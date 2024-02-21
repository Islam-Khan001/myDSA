package llist;

public class llist {
    private Node head;

    public class Node {
        private String data;
        private Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    void addstart(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    void addend(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

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

    // void noderev(Node firstnode){
    // if (firstnode.next != null){
    // Node current = firstnode.next;
    // Node nextnode = current.next;
    // current.next = firstnode;
    // firstnode.next = null;
    // noderev(nextnode);

    // }
    // }

    void insertNode(String data, int idx) {
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

    void printList() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        llist list = new llist();
        list.addstart("d");
        list.addstart("c");
        list.addstart("b");
        list.addstart("a");

        list.addend("f");
        list.addend("g");
        list.addend("h");
        list.addend("i");

        System.out.print("Original : ");
        list.printList();

        list.insertNode("e", 5);
        System.out.print("Insert e : ");
        list.printList();

        list.noderev(list.head, null);
        System.out.print("Reversed : ");
        list.printList();

    }
}

// java llist

// not optimized

// void noderev(Node node, Node previous) {
// // Node previous = node;
// head = node;
// if (node.next != null) {
// previous = node;
// node = node.next;
// noderev(node, previous);
// }

// node.next = previous;
// previous.next = null;
// }

// Node revrec(Node node){

// }