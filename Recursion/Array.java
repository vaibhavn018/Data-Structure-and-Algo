import java.util.*;

public class Array {

    static boolean isSorted(int [] arr, int i) {
        if(i==arr.length) {
            return true;
        }

        if(arr[i] < arr[i-1]) {
            return false;
        }

        return isSorted(arr, i+1);
    } 

    static boolean search(int [] arr, int num, int s, int e) {
        if(s>e) {
            return false;
        }

        int mid = s + (e-s)/2;
        if(arr[mid]== num) {
            return true;
        }

        if(arr[mid]>num) {
            return search(arr, num, s, mid-1);
        }
        return search(arr, num, mid+1, e);
    }

    static List<Integer> findIndex(int [] arr, int target, int index) {
        List<Integer> res = new ArrayList<>();
        if(index == arr.length) {
            return res;
        }
        if(arr[index] == target) {
            res.add(index);
        }

        res.addAll(findIndex(arr, target, index+1));

        return res;
    }
    public static List<List<Integer>> subSetNumIteration(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int num : arr) {
            int n = res.size();
            for (int i = 0; i < n; i++) {
                List<Integer> innerList = new ArrayList<>(res.get(i));
                innerList.add(num);
                res.add(innerList);
            }
        }

        return res;
    }
    public static List<List<Integer>> permutation(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int num = 0;num<arr.length;num++) {
            int n = res.size();
            List<Integer> innerList = new ArrayList<>(res.get(num));
            for (int i = 0; i <= n; i++) {
                innerList.add(i,arr[num]);
                res.add(innerList);
            }
        }

        return res;
    }



    public static List<List<Integer>> subSetNumIterationDuplicate(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        int s = 0;
        int e = 0;
        for (int num = 0; num < arr.length; num++) {
            s = 0;
            if (num > 0 && arr[num] == arr[num - 1]) {
                s = e + 1;
            }
            int n = res.size();
            e = n - 1;
            for (int j = s; j < n; j++) {
                List<Integer> innerList = new ArrayList<>(res.get(j));
                innerList.add(arr[num]);
                res.add(innerList);
            }
        }

        return res;
    }

    public static List<List<Integer>> permute(int[] nums) throws InterruptedException {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, res, new ArrayList<>());
        return res;
    }
    
    static void helper(int [] nums, int i, List<List<Integer>> res, List<Integer> list) throws InterruptedException {
        // System.out.println(i);
        // Thread.sleep(1000);
        if(i == nums.length) {

            List<Integer> newList = new ArrayList<>(list);
            res.add(newList);
            return;
        }
        
        
        for(int j=i; j<=res.size();j++) {
            // System.out.println(i);
            list.add(j, nums[i]);
            helper(nums, i+1, res, list);

        }
        // System.out.println("he");
    }

   
    public static void main(String[] args) throws InterruptedException {
        // int [] arr = {1,2,3,4,6,6,7};
        // System.out.println(isSorted(arr, 1));
        // System.out.println(search(arr, 1, 0, arr.length-1));
        // System.out.println(findIndex(arr, 6, 0));

        int[] nums = { 1,2};
        System.out.println(subSetNumIteration(nums));

        // System.out.println(permute(nums));


    }

    
}
