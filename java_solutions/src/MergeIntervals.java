import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 https://leetcode.com/problems/merge-intervals/

 Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 Example 1:

 Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 Output: [[1,6],[8,10],[15,18]]
 Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> result = new ArrayList<>();
        result.add(new int[]{intervals[0][0], intervals[0][1]});

        for (int i = 0; i< intervals.length; i++) {
            int[] lastInterval = result.get(result.size() - 1);
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if (currentStart <= lastInterval[1]) {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], currentEnd);
             } else {
                result.add(new int[]{currentStart, currentEnd});
            }
        }
        return result.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        MergeIntervals obj = new MergeIntervals();
        System.out.println(obj.merge(new int[][]{{1,4},{4,5}}));
    }
}
