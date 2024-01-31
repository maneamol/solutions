import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
https://leetcode.com/problems/interval-list-intersections/description/
 */
public class IntervalIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        Arrays.sort(firstList, Comparator.comparingInt(i -> i[0]));
        Arrays.sort(secondList, Comparator.comparingInt(i -> i[0]));
        int i = 0;
        int j = 0;
        List<int[]> result = new ArrayList<>();
        while (i < firstList.length && j < secondList.length) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);

            if (start <= end) {
                result.add(new int[]{start, end});
            }

            if (firstList[i][1] <= secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return result.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        IntervalIntersections obj = new IntervalIntersections();
        obj.intervalIntersection(new int[][]{{1, 4}, {5, 6}, {9, 15}}, new int[][]{{2, 4}, {5, 7}, {9, 15}});
    }
}
