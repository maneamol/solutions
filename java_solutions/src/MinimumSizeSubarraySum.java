// https://leetcode.com/problems/minimum-size-subarray-sum/description/

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int minSize = Integer.MAX_VALUE;
        int currentSum = 0;

        while (end < nums.length) {
            currentSum += nums[end];
            while (currentSum >= target && start <= end) {
                minSize = Math.min(minSize, (end - start) + 1);
                currentSum -= nums[start++];
            }
            end++;
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }


    public static void main(String[] args) {
        MinimumSizeSubarraySum obj = new MinimumSizeSubarraySum();
        System.out.println(obj.minSubArrayLen(15, new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8}));
//        System.out.println(obj.minSubArrayLen(7, new int[]{5}));
    }
}

