import java.util.Arrays;

class BubbleSort {
    public static void bubbleSort(int [] arr) {
        /*
         * While traversing it will ensure that largest element will be in the correct position.
         */
        int n = arr.length;

        for(int i=0;i<n-1;i++) {
            for(int j=0;j<n-i-1;j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void recursive(int[] arr, int n) {
        if(n==0 || n==1) {
            return;
        }

        for(int i=0;i<n-1;i++) {
            if(arr[i]>arr[i+1]) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        recursive(arr, n-1);
    } 

    public static void main(String[] args) {
        int [] arr = {50,4,30,2,1};
        // bubbleSort(arr);
        recursive(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}