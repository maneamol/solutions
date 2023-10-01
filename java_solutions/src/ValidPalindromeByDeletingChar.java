public class ValidPalindromeByDeletingChar {
    public boolean validPalindrome(String s) {

        int back = 0;
        int front = s.length() - 1;
        boolean hasDeletion = false;

        while (back <= front) {

            if (s.charAt(front) != s.charAt(back)) {
                System.out.println(" not matching at " + back + " = " + s.charAt(back)+ " " + front + " = " + s.charAt(front));
                if (!hasDeletion) {
                    hasDeletion = true;

                    if (s.charAt(front) == s.charAt(back + 1)) {
                        back++;
                    } else if (s.charAt(front - 1) == s.charAt(back)) {
                        front--;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }

            back++;
            front--;

        }
        return true;
    }

    public boolean validPalindrome2(String s) {
        int i = 0;
        int j = s.length() - 1;

        while(i <= j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
        }
        return true;
    }
    public boolean isPalindrome(String s, int i, int j){
        while(i <= j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else return false;
        }
        return true;
    }
    public static void main(String[] args) {
        ValidPalindromeByDeletingChar obj = new ValidPalindromeByDeletingChar();
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        String[][] mat = new String[2][s.length()];
        for (int i = 0 ; i <s.length(); i++) {
            mat[0][i] = i+"";
            mat[1][i] = String.valueOf(s.charAt(i));
        }

//        for (int i = 0 ; i <s.length(); i++) {
//            System.out.print(mat[0][i] + " ");
//        }
//        System.out.println();
//        for (int i = 0 ; i <s.length(); i++) {
//            System.out.print(mat[1][i] + " ");
//        }
//        System.out.println();

        for (int i = 0 ; i <s.length(); i++) {
            System.out.println(mat[0][i] + " " + mat[1][i]);
        }
        System.out.println(obj.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}
