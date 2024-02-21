// Binary Search Tree
class Node{  // this class can also be defined in bst class by making it static and also private private fields can be made 
    
    Node left;
    int data;
    Node right;

    Node (int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class bst {
    private Node top;  // this line is only needed when we use methods to set top

    bst(Node top){
        this.top = top;
        // top.left = null;
        // top.right = null;
    }    

    // void top(int data){
    //     Node top = new Node(data);        
    // }

    void attach(Node top, int nodedata){
        if (top.left == null || top.right == null){
            if (top.left == null){
                top.left = new Node(nodedata);
                return;                
            }
            top.right = new Node(nodedata);
            return;            
        }
        if (nodedata < top.data){
            attach(top.left, nodedata);            
        }else {
            attach(top.right, nodedata);
        }        
    }

    void printleafnodes(){
        printleafnodes(this.top);
    }

    void printleafnodes(Node top){
        if (top.left == null && top.right == null){
            System.out.println(top.data);
            return;           
        }
        if (top.left != null){
            printleafnodes(top.left); 
        }
        if (top.right != null){
            printleafnodes(top.right);   
        }
    }

    public static void main (String[] args){

        Node top = new Node(100); 
        top.left = new Node(80);
        top.left.left = new Node(50); 
        top.left.right = new Node(90);
        top.left.right.left = new Node(85);
        top.left.right.right = new Node(95);
        top.left.left.left = new Node(30);
        top.left.left.right = new Node(60);

        top.right = new Node(120);
        top.right.left = new Node(110);
        top.right.left.right = new Node(115);
        top.right.right = new Node(140);
        top.right.right.right = new Node(150);

        bst tree = new bst(top);

        tree.attach(top,108);
        System.out.println("The leaf Nodes are : ");
        tree.printleafnodes();
        
    }
}
