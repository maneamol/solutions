public class MinimumWindowSubsequence {

    private int currentMinLength = Integer.MAX_VALUE;
    private int currentStartIndex = -1;
    private int currentEndIndex = -1;

    private int endIndexForSubsequence(String s, String t, int startIndex) {
        int subsequenceIndex = 0;

        for (int i = startIndex; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(subsequenceIndex)) {
                subsequenceIndex++;
                if (subsequenceIndex == t.length()) {
                    return i;
                }
            }
        }

        return -1;
    }

    private void updateSubsequence(String s, String t, int startIndex, int endIndex) {
        if ((endIndex - startIndex + 1) < currentMinLength) {
            this.currentStartIndex = startIndex;
            this.currentEndIndex = endIndex + 1;
            this.currentMinLength = (endIndex - startIndex + 1);
//      System.out.println("StartIndex : " + startIndex + " EndIndex : " +
//          endIndex + " with length : " + (endIndex - startIndex) +
//          " result is " + s.substring(currentStartIndex, currentEndIndex + 1) +
//          " Current min length is " + (endIndex - startIndex));
        }
    }

    public String minWindow(String s, String t) {

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(0)) {
                int endIndex = endIndexForSubsequence(s, t, i);
                if (endIndex != -1) {
                    // Calculate subsequence length
                    updateSubsequence(s, t, i, endIndex);
                }
            }
        }

        String result = "";
        if (currentEndIndex != -1) {
            result = s.substring(currentStartIndex, currentEndIndex);
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumWindowSubsequence obj = new MinimumWindowSubsequence();
//    String res = obj.minWindow("abcdebdde", "bde");
        String res = obj.minWindow("b", "bb");
        System.out.println(res);
    }
}
