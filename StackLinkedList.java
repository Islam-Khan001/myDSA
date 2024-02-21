// add new element at the bottom of the stack . still not done

public class StackLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        Node head;

        boolean isEmpty() {
            return head == null;
        }

        void push(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        int pop() {
            if (isEmpty()) {
                return -1;
            }
            Node currentNode = head;
            head = head.next;
            return currentNode.data;
        }

        int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }

        void pushBottomLoop(int data){
            Node current = head;
            while (current.next != null){
                current = current.next;                
            }
            Node newNode = new Node(data);
            current.next = newNode;
        }

        void pushBottomRec(int data){
            if (isEmpty()){
                push(data);  
                return;                           
            }
            int top = pop();
            pushBottomRec(data);
            push(top);            
        }

        // void helperFunc(int data){   // you will not need this because you will push at the bottom
        //     Node current = head;
        //     Node newNode = new Node(data);
        //     if (head == null){
        //         head = newNode; 
        //         return;               
        //     }
        //     while(current.next != null){
        //         current = current.next;
        //     }
        //     current.next = newNode;
        // }

        void StackReverse(Stack s){
            if (s.isEmpty()){
                return;                
            }
            int data = s.pop();
            StackReverse(s);
            pushBottomRec(data);
        }
    }    

    public static void main(String[] args) {
        // StackLinkedList t = new StackLinkedList();
        Stack mystack = new Stack();
        // Stack mystack1 = new Stack();

        mystack.push(1);
        mystack.push(2);
        mystack.push(3);
        mystack.push(4);
        mystack.push(5);
        // mystack.pushBottomLoop(10);
        // mystack.pushBottomRec(20);

        // mystack1.push(11);
        // mystack1.push(21);
        // mystack1.push(31);
        // mystack1.push(41);
        // mystack1.push(51);
        // // mystack.pushBottomLoop(10);
        // mystack1.pushBottomRec(201);

        System.out.println("After : ");
        mystack.StackReverse(mystack);

        while (!mystack.isEmpty()){
            System.out.println(mystack.peek());
            mystack.pop();            
        }
    }
}

// bkl ye to pehli baar me hi chal gaya

// Learn from this 
// what will happen to other changing variables in recursive function - RecVarTest.java
// Only the local variables go to their previous state
// 
