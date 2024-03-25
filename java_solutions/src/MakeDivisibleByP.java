import java.util.HashMap;
import java.util.Map;

public class MakeDivisibleByP {
    public int minSubarray(int[] nums, int p) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefixSum = 0;
        int ans = nums.length;
        int totalSum = 0;

        for (int i=0; i<nums.length; i++) {
            totalSum = (totalSum + nums[i]) % p;
        }

        System.out.println("Total Sum = " + totalSum);

        if (totalSum == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            prefixSum = (prefixSum + nums[i]) % p;
            int check = (prefixSum  - totalSum + p) % p;
            System.out.println("PrefixSum = " + prefixSum + " check = " + check);
            if (map.containsKey( check )) {
                ans = Math.min(ans, (i - map.get(check)));
            }
            map.put(prefixSum, i);
        }

        if (ans == nums.length) {
            return -1;
        }

        return ans;
    }

    public static void main(String[] args) {
        MakeDivisibleByP makeDivisibleByP = new MakeDivisibleByP();
        System.out.println(makeDivisibleByP.minSubarray(new int[]{3,1,4,2}, 6));
    }
}
