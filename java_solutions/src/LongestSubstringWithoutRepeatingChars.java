import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> chars = new HashMap<>();
        int currentLength = 0;
        int start = 0;
        int end = 0;

        while (end < s.length()) {
            if (!chars.containsKey(s.charAt(end))) {
                chars.put(s.charAt(end), 1);
            } else {
                while (start < end) {
                    if (s.charAt(start) != s.charAt(end)) {
                        chars.remove(s.charAt(start));
                    } else {
                        chars.put(s.charAt(end), end);
                        start++;
                        break;
                    }
                    start++;
                }
            }
            end++;
            currentLength = Math.max(currentLength, (end - start));
        }

        return currentLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingChars obj = new LongestSubstringWithoutRepeatingChars();
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
//        System.out.println(obj.lengthOfLongestSubstring("bbbbb"));
    }
}
