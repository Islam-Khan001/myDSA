public class exbinary {

    int binsort(int[] arr, int left, int right, int x) {
        // System.out.println("it is (arr," + left + ","+ right + ","+ x + ")");
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        
        if (x == arr[mid]) {
            return mid;
        }

        if (x < arr[mid]) {
            return binsort(arr, left, mid - 1, x);
        }
        return binsort(arr, mid + 1, right, x);
    }

    public static void main(String[] args) {
        exbinary t = new exbinary();
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int idx = t.binsort(arr, 0, 9, 0);
        System.out.println("The Number is at index " + idx);

    }
}
