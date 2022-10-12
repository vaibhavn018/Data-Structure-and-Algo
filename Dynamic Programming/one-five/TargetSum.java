import java.util.*;

public class TargetSum {

    static boolean canSum(int target, int[] nums, HashMap<Integer, Boolean> map) {
        if (target == 0) {
            return true;
        }

        if (target < 0) {
            return false;
        }

        if (map.containsKey(target)) {
            return map.get(target);
        }

        for (int num : nums) {
            if (canSum(target - num, nums, map)) {
                return true;
            }
        }
        map.put(target, false);
        return false;
    }

    static boolean canSum(int target, int[] nums) {
        if (target == 0) {
            return true;
        }

        if (target < 0) {
            return false;
        }

        for (int num : nums) {
            if (canSum(target - num, nums)) {
                return true;
            }
        }
        return false;
    }

    static boolean canSumTab(int target, int[] nums) {
        boolean[] table = new boolean[target + 1];

        table[0] = true;

        for (int i = 0; i <= target; i++) {
            if (!table[i]) {
                continue;
            }
            for (int num : nums) {
                if (i + num <= target) {
                    table[i + num] = true;
                }
            }
        }

        return table[target];
    }

    static List<Integer> howSum(int target, int[] nums) {
        @SuppressWarnings("unchecked")
        List<Integer>[] list = new List[target + 1];
        list[0] = new ArrayList<>();

        for (int i = 0; i <= target; i++) {
            if (list[i] != null) {
                for (int num : nums) {
                    if (i + num <= target) {
                        List<Integer> newList = new ArrayList<>(list[i]);
                        newList.add(num);
                        list[i + num] = newList;
                    }
                }
            }
        }

        return list[target];
    }

    static List<Integer> bestSum(int target, int[] nums) {
        @SuppressWarnings("unchecked")
        List<Integer>[] dp = new List[target + 1];
        dp[0] = new ArrayList<>();

        for (int i = 0; i <= target; i++) {
            if (dp[i] != null) {
                for (int num : nums) {
                    if (i + num <= target) {
                        List<Integer> newList = new ArrayList<>(dp[i]);
                        newList.add(num);
                        if (dp[i+num] == null || newList.size() < dp[i+num].size()) {
                            dp[i + num] = newList;
                        }
                    }
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] arr = { 2,3,5,8};


        // System.out.println(canSum(70, arr, new HashMap<>()));
        // System.out.println(canSum(3, arr, new HashMap<>()));
        // System.out.println(canSum(300, arr));
        // System.out.println(canSumTab(1400, arr));

        System.out.println(howSum(8, arr));
        System.out.println(bestSum(8, arr));

        

    }
}
