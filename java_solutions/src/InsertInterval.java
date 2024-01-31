import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
https://leetcode.com/problems/insert-interval/description/
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int i = 0;
        List<int[]> result = new ArrayList<>();

        while (i < intervals.length && intervals[i][0] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        if (i == 0 || result.get(result.size() - 1)[1] < newInterval[0]) {
            result.add(newInterval);
        } else {
            result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], newInterval[1]);
        }

        while (i < intervals.length) {
            if (result.get(result.size() - 1)[1] < intervals[i][0]) {
                result.add(intervals[i]);
            } else {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], intervals[i][1]);
            }
            i++;
        }

        return result.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        InsertInterval obj = new InsertInterval();
        obj.insert(new int[][]{{1, 2}, {3, 5}, {6, 8}}, new int[]{5, 7});
    }
}
