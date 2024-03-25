package aoa;

import java.util.Stack;
/*
https://leetcode.com/discuss/general-discussion/579606/count-contiguous-subarrays

You are given an array a of N integers. For each index i, you are required to determine the number of contiguous subarrays that fulfills the following conditions:
The value at index i must be the maximum element in the contiguous subarrays, and
These contiguous subarrays must either start from or end with i.

Output
An array where each index i contains an integer denoting the maximum number of contiguous subarrays of a[i]
Example:
a = [3, 4, 1, 6, 2]
output = [1, 3, 1, 5, 1]

Explanation:
For index 0 - [3] is the only contiguous subarray that starts (or ends) with 3, and the maximum value in this subarray is 3.
For index 1 - [4], [3, 4], [4, 1]
For index 2 -[1]
For index 3 - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]
For index 4 - [2]
So, the answer for the above input is [1, 3, 1, 5, 1]
 */
public class ContiguousSubarray {
    private void countSubarray(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                ans[i] = ans[i] + ans[stack.pop()];
             }
            ans[i] = ans[i] + 1;
            stack.push(i);
        }

        stack.clear();
        int[] temp = new int[arr.length];
        for (int i  = arr.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int idx = stack.pop();
                ans[i] = ans[i] + ans[idx];
                temp[i] = temp[i] + temp[idx];
            }
            stack.push(i);
            temp[i] = temp[i] + 1;
        }
        for (int i: ans) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        ContiguousSubarray contiguousSubarray = new ContiguousSubarray();
        contiguousSubarray.countSubarray(new int[]{3, 4, 1, 6, 2});
    }
}
