//https://leetcode.com/problems/longest-common-prefix/description/
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        System.out.print(prefix);
        for(int index=1;prefix.length() > 0 && index<strs.length;index++){
            while(strs[index].indexOf(prefix) != 0){
                prefix=prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix obj = new LongestCommonPrefix();
//        obj.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        obj.longestCommonPrefix(new String[]{"abcd", "ab"});
    }
}
