// add remove peek
public class QueueArray {

    static class Queue {
        int[] arr;
        int size;
        int front = -1;
        int rear = -1;

        Queue(int size){
            arr = new int[size];
            this.size = size;            
        }

        boolean isEmpty(){
            return rear == -1; 
        }

        boolean isFull(){
            return rear == (size-1);
        }

        int peek(){
            if (isEmpty()){
                return -1;
            }
            return arr[0];
        }

        void add(int data){
            if (isFull()){
                performFIFO();
                System.out.println("Cannot add More ELements, The Array Is Full");
                return;
            }
            if (isEmpty()){
                front++;
                rear++;
                arr[rear] = data;
                return;
            }
            rear++;
            arr[rear] = data;
        }

        void addFirst(int data){
            if (isFull()){
                performFIFO();
                System.out.println("Cannot add More ELements, The Array Is Full");
                return;
            }
            if (isEmpty()){
                arr[0] = data;
                front++;
                rear++;
            }
            for(int i = rear+1; i > 0; i--) {
                arr[i] = arr[i-1];                
            }
            arr[0] = data;
            rear++;
        }

        int remove(){
            if (isEmpty()){
                front--;
                return -1;
            }
            int currElement = arr[0];
            for(int i = 0; i < rear; i++){
                arr[i] = arr[i+1];
            }
            rear--;
            return currElement;
        }

        void performFIFO(){
            while (!isEmpty()){
                System.out.println(peek());
                remove();
            }
        }

        void reverseQueue(){
            if (isEmpty()){
                return;                                
            }   
            int currData = remove();
            reverseQueue();
            add(currData);
        }
    }

    public static void main (String[] args){
        // QueueArray t = new QueueArray();
        Queue myQueue = new Queue(5);

        myQueue.add(150);
        myQueue.add(151);
        myQueue.add(152);
        myQueue.add(153);
        myQueue.add(156);
        // myQueue.addFirst(155);

        // System.out.println("Front : " + myQueue.arr[myQueue.front]);
        // System.out.println("Rear : " + myQueue.arr[myQueue.rear]);

        myQueue.reverseQueue();
        myQueue.performFIFO();         
    }
}


// Learned from this
// never use i++ and i-- in the same loop
// never forget to do the whole work in the function