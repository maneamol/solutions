//https://leetcode.com/problems/repeated-dna-sequences/description/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepeatedDNASequence {
    public List<String> findRepeatedDnaSequences(String s) {

        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        int start = 0;
        int end = 9;
        String temp = "";

        while (end < s.length()) {
            temp = s.substring(start, end+1);
            map.compute(temp,(k,v) -> (v == null) ? 1: v+1);
            end++;
            start++;
        }

        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if(entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }
//         result = map.entrySet().stream().filter(x -> x.getValue() > 1).map(x -> x.getKey()).collect(Collectors.toList());

        return result;
    }

    public static void main(String[] args) {
        RepeatedDNASequence obj = new RepeatedDNASequence();
        obj.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");

    }
}
