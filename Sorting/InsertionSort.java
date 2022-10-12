import java.util.Arrays;

public class InsertionSort {

    public static void insertion(int []arr) {
        /* 
         * Basically it sort the array without consuming any space.
         * It will ensure that left side if the array is always sorted while traversing.
         * 
         */
        int n = arr.length;

        for(int i=1;i<n;i++) {
            int key = arr[i];
            int j =i-1;
            while(j>=0 && arr[j] >key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int [] arr = {5,4,3,2,1};
        insertion(arr);
        System.out.println(Arrays.toString(arr));
        
    }
}
