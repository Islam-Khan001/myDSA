import java.util.Arrays;

public class mergesortsolve {
    public static void main (String[] args){
        mergesortsolve t = new mergesortsolve();
        int[] data = {17,9,8,3,5,1,4,6};
        t.mergesort(data,0,data.length -1);  
        
        System.out.println(Arrays.toString(data));
    }

    void mergesort(int[] data,int start, int end){
        if (start < end){
            int mid = (start + end)/2;
            mergesort(data, start, mid);
            mergesort(data, mid+1, end);
            merge(data, start, mid,end);
        }        
    }

    void merge(int[] data, int start,int mid, int end){

        int[] temp = new int[end-start+1];
        
        int i = start, j = mid+1, k = 0;

        while (i <= mid && j <= end){
            if (data[i] <= data[j]){
                temp[k++] = data[i++];            
            }else {
                temp[k++] = data[j++];
            }           
        }

        while (i <= mid){
            temp[k++] = data[i++];
        }

        while (j <= end){
            temp[k++] = data[j++];
        }

        for(i = start; i <= end; i++) {
            data[i] = temp[i-start];            
        }
    }
}