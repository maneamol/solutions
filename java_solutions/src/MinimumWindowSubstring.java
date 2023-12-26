import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (t.equals("")) {
            return "";
        }

        Map<Character, Integer> reqCount = new HashMap<>();
        Map<Character, Integer> windowCharMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            reqCount.put(t.charAt(i), reqCount.getOrDefault(t.charAt(i), 0) + 1);
        }

        int current = 0;
        int required = reqCount.size();

        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;

        int left = 0;

        String minString = "";

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (reqCount.containsKey(c)) {
                windowCharMap.put(c, windowCharMap.getOrDefault(c, 0) + 1);

                if (reqCount.containsKey(c) && windowCharMap.get(c) == reqCount.get(c)) {
                    current++;
                }

                // while (current == required && left <= right) {
                while (current == required) {

                    if (right - left + 1 < resLen) {

                        res[0] = left;
                        res[1] = right;
                        resLen = (right - left + 1);

                        minString = s.substring(left, right + 1);

                    }

                    char leftChar = s.charAt(left);

                    if (reqCount.containsKey(leftChar)) {

                        windowCharMap.put(leftChar, windowCharMap.get(leftChar) - 1);
                        if (windowCharMap.get(leftChar) < reqCount.get(leftChar)) {
                            current--;
                        }
                    }
                    left++;
                }

            }
        }
        int leftIndex = res[0];
        int rightIndex = res[1];
        return resLen != Integer.MAX_VALUE ? s.substring(leftIndex, rightIndex + 1) : "";
    }

    public static void main(String[] args) {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        // System.out.println(obj.minWindow("cabwefgewcwaefgcf", "cae"));
        System.out.println(obj.minWindow("bb", "bb"));
    }
}
