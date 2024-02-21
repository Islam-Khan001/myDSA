
public class btpreorder {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int iterator = -1;

    static Node addnode(int[] arr) {
        iterator++;
        if (arr[iterator] == -1)
            return null;

        Node newnode = new Node(arr[iterator]);
        newnode.left = addnode(arr);
        newnode.right = addnode(arr);
        return newnode;
    }

    static boolean visited = false;

    static void printLeftSubTree(Node top) {
        if (top.left == null && top.right == null) {
            System.out.println(top.data);
            return;
        }        
        if (top.data == 1 && visited == true) {
            return;
        }else {
            visited = true;
            System.out.println(top.data);
            printLeftSubTree(top.left);
            printLeftSubTree(top.right);
        }        

    }

    public static void main(String[] args) {
        // btpreorder tree = new btpreorder();
        int[] nodesPreorder = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        // int[] nodesPreorder = { 1, 2, -1,-1,3,-1,-1};
        Node top = addnode(nodesPreorder);
        // System.out.println(top.data);
        printLeftSubTree(top);

    }
}

// do the printLeftSubTree

// learned from this program
// defining classes inside classes
// what does it have to do with static
