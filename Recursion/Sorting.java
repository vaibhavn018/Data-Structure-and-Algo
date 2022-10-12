import java.util.*;

public class Sorting {

    static void bubbleSort(int[] arr, int i, int j) {
        if (i < 0) {
            return;
        }

        if (i > j) {
            if (arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1);
            }
            bubbleSort(arr, i, j + 1);
            return;
        }
        bubbleSort(arr, i - 1, 0);
    }

    static void selectionSort(int[] arr, int i, int j, int max) {
        if (i <= 0) {
            return;
        }

        if (j < i) {
            if (arr[j] > arr[max]) {
                selectionSort(arr, i, j + 1, j);
                return;
            }
            selectionSort(arr, i, j + 1, max);
            return;
        }
        swap(arr, i - 1, max);
        selectionSort(arr, i - 1, 0, 0);

    }

    public static void insertionSort(int[] arr, int i, int j) {
        if (i < 0) {
            return;
        }

        if (j >= 0) {
            if (arr[i] < arr[j]) {
                swap(arr, i, j);
            }
            insertionSort(arr, i, j - 1);
            return;
        }
        insertionSort(arr, i - 1, i - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 6, 7, 8, 9, 1, 2, 3, 4 };
        // bubbleSort(arr, arr.length-1, 0);
        // selectionSort(arr, arr.length, 0, 0);
        // insertionSort(arr, arr.length-1, arr.length-1);
        System.out.println(Arrays.toString(arr));

        // System.out.println(search(arr, 9, 0, arr.length-1));
        // String n = new String("hello");
        // String a = "hello";
        // String b = "hello";
        // System.out.println(a==b);
        // System.out.println(n.getClass());
        // System.out.println(n==b);
        System.out.println("a" + "a");
    }

    public static int search(int[] arr, int target, int s, int e) {
        if (s > e) {
            return -1;
        }

        int mid = s + (e - s) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[s] <= arr[mid]) {
            if (target >= arr[s] && arr[mid] >= target) {
                return search(arr, target, s, mid - 1);
            }
            return search(arr, target, mid + 1, e);
        }

        if (arr[mid] >= target && arr[e] >= target) {
            return search(arr, target, mid + 1, e);
        }
        return search(arr, target, s, mid - 1);
    }
}
