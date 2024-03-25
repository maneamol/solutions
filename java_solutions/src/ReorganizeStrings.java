import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class ReorganizeStrings {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
//        Set<Character> set = new HashSet<>();
        for (int i = 0;i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
//            set.add(s.charAt(i));
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        map.entrySet().forEach(e -> {
            pq.add(new int[]{e.getKey(), e.getValue()});
        });

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            int[] first = pq.poll();
            if (sb.isEmpty() || sb.charAt(sb.length() - 1) != first[0]) {
                sb.append((char) first[0]);
                first[1] = first[1] - 1;
                if (first[1] > 0) {
                    pq.add(first);
                }
            } else {
                if (pq.isEmpty()) {
                    return "";
                }

                int[] second = pq.poll();
                sb.append((char) second[0]);
                second[1] = second[1] - 1;
                if (second[1] > 0) {
                    pq.add(second);
                }
                pq.add(first);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReorganizeStrings rs = new ReorganizeStrings();
        System.out.println(rs.reorganizeString("aab"));
        System.out.println(rs.reorganizeString("aaab"));
    }
}
