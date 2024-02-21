import java.util.ArrayList;

public class stackArraylist {

    static class Stack {
        private ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public void push(int item) {
            list.add(item);
        }

        int pop() {
            if (isEmpty()) {
                return -1;
            }
            return list.remove(list.size() - 1);
        }

        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        // stackArraylist stackArrayList = new stackArraylist();
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}

// import java.util.ArrayList;

// public class stackArraylist {

// static class Stack {
// static ArrayList<Integer> list = new ArrayList<>();

// static Boolean isEmpty() {
// return list.size() == 0;
// }

// static void push(int item) {
// list.add(item);
// }

// static int pop() {
// if (isEmpty()) {
// return -1;
// }
// int lastItem = list.get(list.size() - 1);
// list.remove(list.size() - 1);
// return lastItem;
// }

// static int peek() {
// if (isEmpty()) {
// return -1;
// }
// int lastItem = list.get(list.size() - 1);
// return lastItem;
// }
// }

// public static void main(String[] args) {
// stackArraylist myst = new stackArraylist();
// // stackArraylist.Stack mystack = myst.new Stack();
// Stack mystack = new Stack();

// mystack.push(1);
// mystack.push(2);
// mystack.push(3);
// mystack.push(4);

// while(mystack.isEmpty()){
// System.out.println(mystack.peek());
// mystack.pop();
// }
// }
// }