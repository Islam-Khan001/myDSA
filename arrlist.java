// ArrayList - add, remove, get, set

// import java.util.Scanner;
import java.util.ArrayList;

public class arrlist {

    public static void main(String[] args) {
        // arrlist t = new arrlist();
        // Scanner input = new Scanner(System.in);

        ArrayList<Integer> arr = new ArrayList<Integer>(); 

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        System.out.println(arr);
        arr.add(1, 5);
        System.out.println(arr);
        arr.remove(5);
        System.out.println(arr);
        System.out.println(arr.get(0));

        arr.addFirst(10);
        System.out.println(arr);

        arr.addLast(20);
        System.out.println(arr);

        arr.set(3,40);
        System.out.println(arr);

        // input.close();
    }
}