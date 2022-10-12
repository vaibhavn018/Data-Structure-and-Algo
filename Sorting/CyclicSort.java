import java.util.Arrays;

public class CyclicSort {

    public static void cyclicSort(int [] arr) {
        // for(int i=0;i<arr.length;i++) {
        //     arr[i] = i + 1;
        // }

        int i=0;
        while(i<arr.length) {
            int correct = arr[i] -1;
            if(arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
    }
    private static void swap(int[] arr, int i, int correct) {
        int temp = arr[i];
        arr[i] = arr[correct];
        arr[correct] = temp;
    }

    public static void randomSort(int [] num) {
        int i=0;
        int loop = 0;
        while(i<num.length-1) {
            loop++;
            int iNum = num[i];
            int count = i;
            for(int j=i+1;j<num.length;j++) {
                if(iNum < num[j]) {
                    count++;
                }
            }
            swap(num, count, i);
            if(count == i) {
                i++;
            }
        }
        System.out.println(loop - num.length);
    }



    public static void main(String[] args) {
        int [] arr ={10,9,8,7,6,5,4,3,2,1};
        // cyclicSort(arr);
        // System.out.println(Arrays.toString(arr));
        randomSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
