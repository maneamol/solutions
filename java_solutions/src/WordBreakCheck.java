import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakCheck {
    private boolean canBreak = false;
    private void checkBreak(String s, int startIndex, Set<String> dict) {
//        System.out.println("s " + s);
        if (s.length() == 0) {
            canBreak = true;
            return;
        }

        for (int i = startIndex + 1; i<=s.length(); i++) {
//            System.out.println("Checking word " + s.substring(startIndex, i));
            if (!canBreak && dict.contains( s.substring(startIndex, i) )) {
//                System.out.println("Found match ");
                String temp = s.substring(i);
//                System.out.println("temp " + temp);
                checkBreak(temp, 0, dict);
            }
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        checkBreak(s, 0, dict);
        return canBreak;
    }

    public static void main(String[] args) {
        WordBreakCheck wbc = new WordBreakCheck();
//        System.out.println(wbc.wordBreak("leetcode", List.of("leet","code") ));
//        System.out.println(wbc.wordBreak("catsandog", List.of("cats","dog","sand","and","cat") ));
        System.out.println(wbc.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa") ));
    }

}
