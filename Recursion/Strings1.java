import java.util.*;

public class Strings1 {

    public static String removeChar(String str, char ch) {
        if (str == "") {
            return "";
        }
        if (str.charAt(0) == ch) {
            return "" + removeChar(str.substring(1), ch);
        }
        return str.charAt(0) + removeChar(str.substring(1), ch);
    }

    public static String skipApple(String str) {
        if (str.isEmpty()) {
            return "";
        }

        if (str.startsWith("app") && !str.startsWith("apple")) {
            return skipApple(str.substring(3));
        }

        return str.charAt(0) + skipApple(str.substring(1));

    }

    public static List<String> subSet(String str, String p) {
        List<String> l = new ArrayList<>();
        if (str.isEmpty()) {
            l.add(p);
            return l;
        }

        l = subSet(str.substring(1), p + str.charAt(0));
        List<String> r = subSet(str.substring(1), p);
        l.addAll(r);
        return l;
    }

    public static List<String> subSequence(String up, String p) {
        List<String> res = new ArrayList<>();
        if(up.isEmpty()) {
            res.add(p);
            return res;
        }
        
        char ch = up.charAt(0);
        
        for(int i=0;i<=p.length();i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            res.addAll(subSequence(up.substring(1), f + ch + s));
        }
        return res;

    }

    public static List<List<Integer>> dice(List<Integer> list, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return res;
        }

        for(int i=1;i<=6 && i<=target;i++) {
            list.add(i);
            res.addAll(dice(list, target -i));
            list.remove(list.indexOf(i));
        }

        return res;
    }

    public static void main(String[] args) {
        // System.out.println(removeChar("bbaacc", 'b'));
        // System.out.println(skipApple("bbappl"));

        // System.out.println(subSet("abc", ""));
        // System.out.println(subSequence("abcdefghijklmop", "").size());
        System.out.println(dice(new ArrayList<>(), 4));
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        list.add(0);
        res.add(list);

        System.out.println(res);

        
    }
}
