package aoa;

import java.util.ArrayList;
import java.util.List;
/*
Count Maximum Profitable Groups
A team of analysts at Amazon needs to analyze the stock prices of Amazon over a period of several months.

A group of consecutively chosen months is said to be maximum profitable if the price in its first or last month is the maximum for the group. More formally, a group of consecutive months [l, r] (1 ≤ l ≤ r ≤ n) is said to be maximum profitable if either:

stockPrice[l] = max(stockPrice[l], stockPrice[l + 1], ..., stockPrice[r])
or, stockPrice[r] = max(stockPrice[l], stockPrice[l + 1], ..., stockPrice[r])
Given prices over n consecutive months, find the number of maximum profitable groups which can be formed. Note that the months chosen must be consecutive, i.e., you must choose a subarray of the given array.

Function Description

Complete the function countMaximumProfitableGroups function in the editor below.

countMaximumProfitableGroups has the following parameter:

int stockPrice[n]: the stock prices
Returns

long integer: the number of maximum profitable groups

Example 1:

Input: stockPrice = [3, 1, 3, 5]
Output: 10
Explanation:

The 10 possible groups are [3], [3, 1], [1, 3], [1], [3, 1, 3], [1, 3, 5], [1], [3, 1, 3, 5], [3, 5], [5].
In each group, the maximum price is in either the first or last position.

Example 2:

Input: stockPrice = [1, 5, 2]
Output: 5
Explanation:

There are 6 possible groups: [1], [1, 5], [5], [5, 2], [2].
Only [1, 5, 2], is not maximum profitable because its maximum value 5 is not at either end of the group.

 5 6 7 1 2 8
 3 3 2 1 1 1

 */
public class CountMaximumProfitableGroups {
    int count = 0;
    public void countMaximumProfitableGroups(int[] stockPrice, int start, int size, List<Integer> currList) {
        if (size < 1) {
            return;
        }

        if (currList.size() == size) {
//            int[] arr = currList.stream().mapToInt(i -> i).toArray();
            //currList.stream().forEach(k -> System.out.print(k + " "));
//            for (int i = 0; i < currList.size(); i++) {
//                System.out.print(currList.get(i) + " ");
//            }
            int max = currList.stream().max(Integer::compare).get();
//            System.out.println();
            if (currList.get(0) == max || currList.get(size - 1) == max) {
                count++;
            }
            return;
        }

        currList.add(stockPrice[start]);
        countMaximumProfitableGroups(stockPrice, start + 1, size, currList);
        currList.remove(currList.size() - 1);
    }

    public static void main(String[] args) {
        CountMaximumProfitableGroups obj = new CountMaximumProfitableGroups();
        int[] arr = new int[]{3, 1, 3, 5};
//        int[] arr = new int[]{2, 3, 2};
        List<Integer> currList = new ArrayList<>();
//        System.out.println(obj.CountMaximumProfitableGroups(arr));

        for (int i = 0; i< arr.length; i++) {
            for (int k = 0; (i+k) < arr.length + 1; k++) {
                obj.countMaximumProfitableGroups(arr, i, k, currList);
            }
        }

        System.out.println(obj.count);

    }
}
