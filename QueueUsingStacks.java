import java.util.Stack;

public class QueueUsingStacks {

    void performLIFO(Stack<Integer> mystack, Stack<Integer> mystack1) {
        while (!mystack.empty()) {
            mystack1.push(mystack.pop());
        }
    }

    public static void main(String[] args) {
        QueueUsingStacks Que = new QueueUsingStacks();
        Stack<Integer> mystack = new Stack<>();
        Stack<Integer> mystack1 = new Stack<>();

        mystack.push(1);
        mystack.push(2);
        mystack.push(3);
        mystack.push(4);
        mystack.push(5);

        Que.performLIFO(mystack, mystack1);

        while (!mystack1.empty()) {
            System.out.println(mystack1.peek());
            mystack1.pop();
        }
    }
}