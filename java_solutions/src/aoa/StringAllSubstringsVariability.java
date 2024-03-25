package aoa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringAllSubstringsVariability {
    private void genrateVar(char[] chars, int start, int size, Set<String> res, List<Character> currList, String front, String back) {
        if (size < 1) {
            res.add(String.valueOf(chars));
            return;
        }
        if (currList.size() == size) {
//            System.out.println(String.valueOf(currList.toArray()));
//            res.add(currList.stream().collect(Collectors.toA));
            StringBuilder sb = new StringBuilder();
            currList.stream().forEach(c -> sb.append(c));
            sb.reverse();
            sb.insert(0, front);
            sb.append(back);
            res.add(sb.toString());
            return;
        }

        currList.add(chars[start]);
        genrateVar(chars, start + 1, size, res, currList, front, back);
        currList.remove(currList.size() - 1);
    }

    public static void main(String[] args) {
//        String s = "abcd";
        String s = "abc";
        StringAllSubstringsVariability stringAllSubsets = new StringAllSubstringsVariability();
        Set<String> res = new HashSet<>();
        List<Character> currList = new ArrayList<>();
        for (int i = 0; i< s.length(); i++) {
            for (int k = 1; k < s.length() - i + 1; k++) {
                String front = s.substring(0, i);
                String back = s.substring( Math.min( i + k, s.length())  );
                System.out.println("start = " + front + " end = " + back);
                stringAllSubsets.genrateVar(s.toCharArray(), i, k, res, currList, front, back);
            }
        }

        System.out.println(res.size());
    }
}
