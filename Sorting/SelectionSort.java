import java.util.Arrays;

public class SelectionSort {

    public static void selection(int [] arr) {
        /*
         * Selecting smaller element in the sub array and place it in correct index.
         */
        int n = arr.length;

        for(int i=0;i<n-1;i++) {
            int max_index = i;
            for(int j = i+1;j<n;j++) {
                if(arr[max_index] > arr[j]) {
                    max_index = j;
                }
            }

            int temp = arr[max_index];
            arr[max_index] = arr[i];
            arr[i] = temp;
        }
    }


    public static void main(String[] args) {
        int [] arr = {50,4,30,2,1};
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }
}
