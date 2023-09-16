public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }

        int front = 0;
        int back = s.length() - 1;

        while (front < back) {
            if (s.charAt(front) == s.charAt(back)) {
                front++;
                back--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] testCase = {
//                "RACEACAR",
                ""
//                "ABCDEFGFEDCBA",
//                "ABC",
//                "ABCBA",
//                "ABBA",
//                "RACEACAR"
        };
        for (int k = 0; k < testCase.length; k++) {
//            System.out.println("Test Case # " + (k + 1));
            System.out.println(isPalindrome(testCase[k]));
//            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}

