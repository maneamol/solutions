import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacherSubsequence {

    public int characterReplacement(String s, int k) {
        // declare map of char and its count
        // declare start and end pointers
        // declare maxCount
        // iterate over the string
        // if map contains char at end pointer, increment its count
        // else add char to map with count 1
        // update maxCount
        // if end - start + 1 - maxCount > k
        // decrement count of char at start pointer
        // increment start pointer
        // update max length
        // return maxlenght

        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int maxCount = 0;
        int maxLength = 0;
        for (end = 0; end < s.length(); end++) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            maxCount = Math.max(maxCount, map.get(s.charAt(end)));
            if (end - start + 1 - maxCount > k) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacherSubsequence obj = new LongestRepeatingCharacherSubsequence();
        System.out.println(obj.characterReplacement("ABAB", 2));

    }
}
