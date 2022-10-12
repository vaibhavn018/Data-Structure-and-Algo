import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int [] arr, int low, int high) {
        if(low>=high)  {
            return;
        }

        int s = low, e = high;

        int mid = s + (e-s)/2; // s   m   e
        int pivot = arr[mid]; // [5,4,3,2,1]
        
        while(s<=e) {
            while(arr[s] > pivot) {
                s++;
            } 
            while(arr[e] < pivot) {
                e--;
            }
            
            if(s<=e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }

        quickSort(arr, low, mid);
        quickSort(arr, mid+1, high);
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
