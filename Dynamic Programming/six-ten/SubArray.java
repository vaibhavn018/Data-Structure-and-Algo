import java.util.*;

public class SubArray {


    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> sub = subArray(arr, 0, new ArrayList<>());
    }

    private static List<List<Integer>> subArray(int[] arr, int i, List<Integer> list) {
        List<List<Integer>> res = new ArrayList<>();
        if(i==arr.length) {
            List<Integer> newList = new ArrayList<>(list);
            res.add(newList);
            return res;
        }

        List<Integer> 

        
    }
}
