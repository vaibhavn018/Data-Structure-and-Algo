import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] arr) throws StackOverflowError {
        if (arr.length <= 1) {
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] answer = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] > right[j]) {
                answer[k] = right[j];
                j++;
            } else {
                answer[k] = left[i];
                i++;
            }
            k++;
        }
        // System.out.println("hello");
        while (i < left.length) {
            answer[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            answer[k] = right[j];
            j++;
            k++;
        }

        return answer;
    }

    public static void inPlaceMergeSort(int[] arr, int s, int e) {
        if (e-s ==1) {
            return;
        }
        int mid = s + (e - s) / 2;

        inPlaceMergeSort(arr, s, mid);
        inPlaceMergeSort(arr, mid, e);
        inPlaceMerge(arr, s, mid, e);
    }

    private static void inPlaceMerge(int[] arr, int s, int mid, int e) {
        int[] merge = new int[e - s];
        int i = s, j = mid, k = 0;

        while (i < mid && j < e) {
            if (arr[i] < arr[j]) {
                merge[k] = arr[i];
                i++;
            } else {
                merge[k] = arr[j];
                j++;
            }

            k++;
        }

        while (i < mid) {
            merge[k] = arr[i];
            i++;
            k++;
        }

        while (j < e) {
            merge[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < merge.length; l++) {
            arr[l + s] = merge[l];
        }

    }

    public static void main(String[] args) {
        int[] arr = { 8, 7, 6, 5, 4, 3, 2, 1 };
        

        inPlaceMergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
