import java.util.*;



public class Main {
    public static void main(String[] args) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("12");
        map.put(10, list);

        if(map.containsKey(10)) {
            map.get(10).add("123");
        }
        int sum = 10;
        String str = "1234";

        map.get(sum).add(str);
        System.out.println(map.get(10));

    }
}
