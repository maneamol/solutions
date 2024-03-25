import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKfrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i: nums) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1 );
        }

        //int[] res = new int[nums.length];
        List<List<Integer>> list = new ArrayList<>(nums.length);

        countMap.entrySet().stream().forEach(e -> {
            int count = e.getValue();
            int value = e.getKey();

            if (list.get(count).size() == 0) {
                list.set(count, new ArrayList<>());
            }
            list.get(count).add(value);



        });
        return null;
    }
}
