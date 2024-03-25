import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/description/
public class MinimumNumberOfOpsToEmptyArray {
    public int minOperations(int[] nums) {
        int opCount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            Integer key = entry.getKey();
            Integer count = entry.getValue();
            // Perform operations using key and value
            if (count == 1) {
                return -1;
            }

            while (count > 4) {
                count = count - 3;
                opCount++;
            }
            if (count == 4) {
                count = 0;
                opCount = opCount + 2;
            }

            if (count == 3) {
                count = 0;
                opCount = opCount + 1;
            }

            if (count == 2) {
                count = 0;
                opCount = opCount + 1;
            }

            if (count != 0) {
                System.out.println("Should not be here");
            }
        }

        return opCount;
    }

    public static void main(String[] args) {
        MinimumNumberOfOpsToEmptyArray op = new MinimumNumberOfOpsToEmptyArray();
        System.out.println(op.minOperations(new int[]{2,3,3,2,2,4,2,3,4}));
        System.out.println(op.minOperations(new int[]{2,1,2,2,3,3}));
    }
}
