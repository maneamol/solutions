import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {

//        public String reverseVowels(String s) {
//            int front = 0;
//            int back = s.length() - 1;
//            Character[] vowelsArr = {'a','e','i','o','u',
//                    'A','E','O','O','U'};
//
//            Set<Character> vowels = new HashSet<>(Arrays.asList(vowelsArr));
//
//            char[] chArr = s.toCharArray();
//
//            while (front < back) {
//
//                while(front < chArr.length ) {
//                    if (vowels.contains(chArr[front])) {
//                        break;
//                    }
//                    front++;
//                }
//
//                while (back > 0) {
//                    if (vowels.contains(chArr[back])) {
//                        break;
//                    }
//                    back--;
//                }
//
//                char temp = chArr[front];
//                chArr[front] = chArr[back];
//                chArr[back] = temp;
//
//                front++;
//                back--;
//            }
//
//            return String.valueOf(chArr);
//
//        }

//    reverse vowels in string
    /*public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u',
                'A','E','O','O','U'));
        int front = 0;
        int back = s.length() - 1;

        char[] chArr = s.toCharArray();
        String ans = s;
        while (front < back) {
            while (front < chArr.length && !vowels.contains(chArr[front])) {
                front++;
            }

            while (back > 0 && !vowels.contains(chArr[back])) {
                back--;
            }
            if (front < back) {


                char temp = chArr[front];
                chArr[front] = chArr[back];
                chArr[back] = temp;

                ans = String.valueOf(chArr);
            }
            front++;
            back--;

        }
        return ans;
    }*/

    public String reverseVowels(String s) {
        char[] word = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        String vowels = "aeiouAEIOU";

        while (start < end) {
            // Move start pointer until it points to a vowel
            while (start < end && vowels.indexOf(word[start]) == -1) {
                start++;
            }

            // Move end pointer until it points to a vowel
            while (start < end && vowels.indexOf(word[end]) == -1) {
                end--;
            }

            // Swap the vowels
            char temp = word[start];
            word[start] = word[end];
            word[end] = temp;

            // Move the pointers towards each other
            start++;
            end--;
        }

        String answer = new String(word);
        return answer;
    }

    public static void main(String[] args) {
        ReverseVowels obj = new ReverseVowels();
        System.out.println(obj.reverseVowels("hello"));


    }
}
