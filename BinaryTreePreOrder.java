import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreePreOrder {
    Node top;

    BinaryTreePreOrder() {
        this.top = null;
    }

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

    int iterator = -1;

    Node addNode(int[] arr) {
        iterator++;
        if (arr[iterator] == -1) {
            return null;
        }
        Node newNode = new Node(arr[iterator]);
        if (top == null) {
            top = newNode;
        }
        newNode.left = addNode(arr);
        newNode.right = addNode(arr);
        return newNode;
    }

    void printNodes(Node currentNode) {
        if (currentNode == null) {
            return;
        }
        System.out.println(currentNode.data);
        printNodes(currentNode.left);
        printNodes(currentNode.right);
    }

    void printLeafNodes(Node node) {
        if (node.left == null && node.right == null) {
            System.out.println(node.data);
            return;
        }
        if (node.left != null) {
            printLeafNodes(node.left);
        }
        if (node.right != null) {
            printLeafNodes(node.right);
        }
    }

    void printLeftNodes(Node node) {
        if (node.left == null && node.right == null)
            return;
        if (node.left != null) {
            System.out.println("Left of " + node.data + " : " + node.left.data);
            printLeftNodes(node.left);
        }
        if (node.right != null)
            printLeftNodes(node.right);
    }

    void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        preOrderTraversal(node.left);
        System.out.println(node.data);
        preOrderTraversal(node.right);
    }

    void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
        System.out.println(node.data);
    }

    void levelOrderTraversal(Node node) {
        Queue<Node> myQueue = new LinkedList<>();
        myQueue.add(node);
        myQueue.add(null);

        while (!myQueue.isEmpty()) {
            Node currentNode = myQueue.remove();
            if (currentNode == null) {
                System.out.println();
                if (!myQueue.isEmpty()) {
                    myQueue.add(null);
                }
            } else {
                System.out.print(currentNode.data + " ");
                if (currentNode.left != null)
                    myQueue.add(currentNode.left);
                if (currentNode.right != null)
                    myQueue.add(currentNode.right);
            }
        }
    }

    int countNodes(Node node) {
        if (node == null) {
            return 0;
        }
        int leftNode = countNodes(node.left);
        int rightNode = countNodes(node.right);
        return leftNode + rightNode + 1;
    }

    int sumOfNodes(Node node) {        
        if (node == null) {
            return 0;
        }       
        int sumLeft = sumOfNodes(node.left);
        int sumRight = sumOfNodes(node.right);
        return sumLeft + sumRight + node.data;
    }
    
    int HeightOfTree(Node node) {        
        if (node == null) {
            return 0;
        }       
        int leftHeight = HeightOfTree(node.left);
        int rightHeight = HeightOfTree(node.right);
        
        int max = (leftHeight <= rightHeight)? rightHeight : leftHeight;
        return max + 1;
    }

    public static void main(String[] args) {
        BinaryTreePreOrder BinaryTree = new BinaryTreePreOrder();

        int[] BinArr = { 1, 2, 3, -1, -1, 4, -1, -1, 5, 6, -1, -1, 7, 8, -1, -1, 9, 10,11, -1, -1, -1,-1 };
        // int[] BinArr = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };


        Node topNode = BinaryTree.addNode(BinArr);

        System.out.println("The Nodes are : ");
        BinaryTree.printNodes(topNode);

        System.out.println("Leaf Nodes are : ");
        BinaryTree.printLeafNodes(topNode);

        System.out.println("Left Nodes are : ");
        BinaryTree.printLeftNodes(topNode);

        System.out.println("PreOrder Traversal : ");
        BinaryTree.preOrderTraversal(topNode);

        System.out.println("inOrder Traversal : ");
        BinaryTree.inOrderTraversal(topNode);

        System.out.println("PostOrder Traversal : ");
        BinaryTree.postOrderTraversal(topNode);

        // myQueue.add(topNode);
        System.out.println("LevelOrder Traversal : ");
        BinaryTree.levelOrderTraversal(topNode);

        System.out.println("No of Nodes are : " + BinaryTree.countNodes(topNode));
        System.out.println("Sum of Nodes are : " + BinaryTree.sumOfNodes(topNode));
        System.out.println("Height of Tree is : " + BinaryTree.HeightOfTree(topNode));

    }
}

// [BinaryTreePreOrder](../../draw/BinaryTreePreOrder.drawio)

// Learned from this
// Never use else statement when the previous if statement contains return or
// recursive call. it can result in unexpected behaviour