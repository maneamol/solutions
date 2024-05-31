import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/single-number-iii/description/
/*
Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.



Example 1:

Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.

Example 2:

Input: nums = [-1,0]
Output: [-1,0]

Example 3:

Input: nums = [0,1]
Output: [1,0]

 */
public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i: nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        int[] output = new int[2];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry: freq.entrySet()) {
            if (entry.getValue() == 1) {
                output[idx++] = entry.getKey();
            }
        }
        return output;
    }

    public static void main(String[] args) {
        SingleNumber3 singleNumber3 = new SingleNumber3();
        int[] nums = {1,2,1,3,2,5};
        int[] output = singleNumber3.singleNumber(nums);
        for (int i: output) {
            System.out.println(i);
        }
    }
}
