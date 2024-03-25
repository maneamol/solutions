import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {

    private void wb(String s, List<String> wordDict, int index, List<String> res) {
        if (s.length() == 0 ) {
            //res
            for(String st: res) {
                System.out.print(st + " ");
            }
            System.out.println();
            return;
        }

        if (index >= wordDict.size()) {
            return;
        }

        for (int i = index; i < wordDict.size(); i++) {
            if (wordDict.get(i).length() <= s.length() && s.substring(0, wordDict.get(i).length()).equals(wordDict.get(i))) {
                res.add(s.substring(0, wordDict.get(i).length()));
                wb(s.substring(wordDict.get(i).length()), wordDict, i + 1, res );
                res.remove(res.size() - 1);
            }
//            else if (s.length() > 0){
//                wb(s, wordDict, i + 1, res );
//            }
        }

    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        /*
         s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
        */

        wb(s, wordDict, 0, new ArrayList<>());
        return null;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        String[] arr = {"cat","cats","and","sand","dog"};
        WordBreak wb = new WordBreak();
        wb.wordBreak(s, Arrays.asList(arr));
        System.out.println("======");
        wb.wordBreak("catsandog", Arrays.asList(arr));

/*
        String temp = s.substring(0, 3);
        System.out.println(temp);
        System.out.println(s.substring(3));
*/

    }
}
