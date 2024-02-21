import java.util.Arrays;
public class mergesort {
    public static void main(String[] args) {
        int[] data = { 12, 19, 3, 5, 16, 1,9,0 };
        System.out.println("Original data:");
        printArray(data);

        mergeSort(data, 0, data.length - 1);

        System.out.print("\nSorted data : ");

        System.out.println(Arrays.toString(data));

    }

    static void mergeSort(int[] data, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(data, start, mid);
            mergeSort(data, mid + 1, end);
            merge(data, start, mid, end);

        }
    }

    static void merge(int[] data, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            if (data[i] <= data[j]) {
                temp[k++] = data[i++];
            } else {
                temp[k++] = data[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = data[i++];
        }
        while (j <= end) {
            temp[k++] = data[j++];
        }

        System.out.println("Temp arr : " + Arrays.toString(temp));

        for (i = start; i <= end; i++) {
            data[i] = temp[i - start];
        }


    }

    static void printArray(int[] data) {
        for (int value : data) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

// static void merge(int[] data, int start, int mid, int end) {
// int n1 = mid - start + 1;
// int n2 = end - mid;
// int[] leftArray = new int[n1];
// int[] rightArray = new int[n2];
// for (int i = 0; i < n1; ++i) {
// leftArray[i] = data[start + i]; }
// for (int j = 0; j < n2; ++j) {
// rightArray[j] = data[mid + 1 + j];
// }
// int i = 0, j = 0;
// int k = start;
// while (i < n1 && j < n2) {
// if (leftArray[i] <= rightArray[j]) {
// data[k] = leftArray[i];
// i++;
// } else {
// data[k] = rightArray[j];
// j++;
// }
// k++;
// }

// while (i < n1) {
// data[k] = leftArray[i];
// i++;
// k++;
// }

// while (j < n2) {
// data[k] = rightArray[j];
// j++;
// k++;
// }
// }