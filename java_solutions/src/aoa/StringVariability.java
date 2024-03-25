package aoa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringVariability {
    private Set<String> res = new HashSet<>();
    private Map<String, String> map = new HashMap<>();

    private void generateVariableStrings(String s) {
        if (s == null || s.length() < 2) {
            return;
        }

        for (int i =0; i < s.length(); i++) {
            String x = revSubStringfront(0, i, s);
            System.out.println(x);
            res.add(x);
        }

        for (int i =s.length() - 1; i > 0; i--) {
            String x = revSubStringBack(i, s.length(), s);
            System.out.println(x);
            res.add(x);
        }
        System.out.println(res.size());
    }

    private String revSubStringBack(int start, int end, String s) {
//        if (map.containsKey(s)) {
//            return s;
//        }
        String sub = s.substring(start, end);
        if (sub.length() <= 1) {
//            map.put(s, s);
            return s;
        }
        String front = s.substring(0, start);

        StringBuilder sb = new StringBuilder();
        sb.append(sub).reverse();
        sb.insert(0, front);
//        map.put(s, sb.toString());
        return sb.toString();

    }

    private String revSubStringfront(int start, int end, String s) {
//        if (map.containsKey(s)) {
//            return s;
//        }
        String sub = s.substring(start, end + 1);
        if (sub.length() <= 1) {
//            map.put(s, s);
            return s;
        }

        String rem =  s.substring(end + 1);
        StringBuilder sb = new StringBuilder(sub).reverse();
//        map.put(s, sb.append(rem).toString());
        return sb.append(rem).toString();
    }

    public static void main(String[] args) {
        StringVariability sv = new StringVariability();
//        sv.generateVariableStrings("abc");
//        sv.generateVariableStrings("abcba");
        System.out.println(findVariability("abc"));
//        System.out.println("abc".substring(2));
//        String s = "abcba";
//        System.out.println(s.substring(0, s.length()/2));
    }


    // Helper function to check if a string contains distinct characters
    private static boolean isDistinct(String s) {
        return s.chars().distinct().count() == s.length();
    }

    // Function to find the variability of the password
    public static int findVariability(String password) {
        int n = password.length();
        int count = 0;

        // Iterate over all possible substrings
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String substring = password.substring(i, j + 1);
                String reversedSubstring = new StringBuilder(substring).reverse().toString();

                // Check if reversed substring is distinct
                if (isDistinct(reversedSubstring)) {
                    count++;
                }
            }
        }

        return count;
    }
}
