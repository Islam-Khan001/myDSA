//Sorts - bubble, selection, insertion
public class sorts {

    static void print_arr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        int option = 3;

        if (option == 1) {
            // bubble sort
            System.out.print("Bubble Sort : ");
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        } else if (option == 2) {
            // selection sort
            System.out.print("Selection Sort : ");
            for (int i = 0; i < arr.length - 1; i++) {
                int smallest = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[smallest] > arr[j]) {
                        smallest = j;
                    }
                }
                int temp = arr[smallest];
                arr[smallest] = arr[i];
                arr[i] = temp;
            }
        } else if (option == 3) {
            // insertion sort
            System.out.print("Insertion Sort : ");
            for (int i = 1; i < arr.length; i++) {
                int current = arr[i];
                int j = i - 1;

                while (j >= 0 && arr[j] > current) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = current;
            }
        } else {
            System.out.println("Set opion to valid number ");
        }

        print_arr(arr);
    }
}

