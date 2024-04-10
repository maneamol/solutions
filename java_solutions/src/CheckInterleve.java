public class CheckInterleve {
//    https://leetcode.com/problems/interleaving-string/

    private boolean checkInterleave(String s1, int s1Index, String s2, int s2Index, String s3, int s3Index, String res) {
//        System.out.println(res);
        if (res.equals(s3)) {
            return true;
        }
        if (res.length() == s3.length()) {
            return false;
        }
        if (s3Index < s3.length() && s1Index < s1.length() && s2Index < s2.length()
                && s3.charAt(s3Index) != s1.charAt(s1Index) && s3.charAt(s3Index) != s2.charAt(s2Index) ) {
//            System.out.println("Returning false ");
            return false;
        }

        if (s3Index < s3.length() && s1Index < s1.length() && s2Index < s2.length()
                && s3.charAt(s3Index) == s1.charAt(s1Index) && s3.charAt(s3Index) == s2.charAt(s2Index)) {
            return checkInterleave(s1, s1Index + 1 , s2, s2Index, s3, s3Index + 1, res + s1.charAt(s1Index)) ||
                    checkInterleave(s1, s1Index, s2, s2Index + 1, s3, s3Index + 1, res + s2.charAt(s2Index));
        } else if (s3Index < s3.length() && s1Index < s1.length()
                && s3.charAt(s3Index) == s1.charAt(s1Index)) {
            return checkInterleave(s1, s1Index + 1 , s2, s2Index, s3, s3Index + 1, res + s1.charAt(s1Index));
        }
        return checkInterleave(s1, s1Index, s2, s2Index + 1, s3, s3Index + 1, res + s2.charAt(s2Index));
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        return checkInterleave(s1, 0, s2, 0, s3, 0, "");
    }

    public static void main(String[] args) {
        CheckInterleve cl = new CheckInterleve();

        System.out.println(cl.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
//                                                             "aadbbcbcca"
        System.out.println(cl.isInterleave("aabcc", "dbbca", "aadbbbaccc"));

    }
}
