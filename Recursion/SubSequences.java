import java.util.*;

public class SubSequences {
    public static void subString(String str, int i, String sub) {
        if (i == str.length()) {
            System.out.println(sub);
            return;
        }
        subString(str, i + 1, sub);
        subString(str, i + 1, sub + str.charAt(i));
    }

    public static void subArray(int[] arr, int i, List<Integer> list) {
        if (i >= arr.length) {
            System.out.println(list);
            return;
        }

        list.add(arr[i]);
        subArray(arr, i + 1, list);
        list.remove(list.indexOf(arr[i]));
        subArray(arr, i + 1, list);
    }

    public static List<List<Integer>> subArray2(int[] arr, int i, List<Integer> list) {
        List<List<Integer>> res = new ArrayList<>();
        if (i >= arr.length) {
            res.add(list);
            return res;
        }

        list.add(arr[i]);
        res.addAll(subArray2(arr, i + 1, list));
        list.remove(list.indexOf(arr[i]));
        res.addAll(subArray2(arr, i + 1, list));

        return res;
    }

    public static void sumArray(int[] arr, int i, int sum, int curSum, List<Integer> list, int k) {
        if (i >= arr.length) {
            if (curSum == sum && list.size() == k) {
                System.out.println(list);
            }
            return;
        }
        list.add(arr[i]);

        curSum += arr[i];
        sumArray(arr, i + 1, sum, curSum, list, k);
        list.remove(list.indexOf(arr[i]));
        curSum -= arr[i];
        sumArray(arr, i + 1, sum, curSum, list, k);
    }

    public static int countSeq(int[] arr, int i, int s, int sum) {
        if (i == arr.length) {
            if (s == sum) {
                return 1;
            } else {
                return 0;

            }
        }
        s += arr[i];
        int take = countSeq(arr, i + 1, s, sum);
        s -= arr[i];
        int noTake = countSeq(arr, i + 1, s, sum);
        // System.out.println(take);
        // System.out.println(noTake);

        return take + noTake;
    }

    public static void main(String[] args) {
        // subString("abc", 0, "");
        int[] arr = { 1, 1, 3, 2};
        // subArray(arr, 0, new ArrayList<>());
        // System.out.println(subArray2(arr, 0, new ArrayList<>()));
        sumArray(arr, 0, 3, 0, new ArrayList<>(), 3);
        int count = countSeq(arr, 0, 0, 3);
        System.out.println(count);

    }
}
