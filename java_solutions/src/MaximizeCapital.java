import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaximizeCapital {

    private int maximumCapital(int c, int k, int[] capitals, int[] profits) {

        PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < capitals.length; i++) {
            minCapitalHeap.offer(new int[]{capitals[i], i});
        }

        int currentCapital = c;

        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;

        while ( i < k && !minCapitalHeap.isEmpty()) {
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= currentCapital) {
                 maxProfitHeap.offer(profits[ minCapitalHeap.poll()[1] ]);
            }
            if (maxProfitHeap.isEmpty()) {
                break;
            }
            i++;
            currentCapital = currentCapital + maxProfitHeap.poll();
        }
        return currentCapital;
    }

    public static void main(String[] args) {
        MaximizeCapital obj = new MaximizeCapital();
        StringBuilder sb = new StringBuilder();
        sb.append("-".repeat(100));

/*        int[] c = { 0, 1, 2, 1, 7, 2 };
        int[] k = { 1, 2, 3, 3, 2, 4 };
        int[][] capitals = {
                {1, 1, 2},
                {1, 2, 2, 3},
                {1, 3, 4, 5, 6},
                {1, 2, 3, 4},
                {6, 7, 8, 10},
                {2, 3, 5, 6, 8, 12}
        };
        int[][] profits = {
                {1, 2, 3},
                {2, 4, 6, 8},
                {1, 2, 3, 4, 5},
                {1, 3, 5, 7},
                {4, 8, 12, 14},
                {1, 2, 5, 6, 8, 9}
        };

        for (int i = 0; i<k.length; i++) {
            System.out.println((i + 1) + ".\tProject capital requirements: " + Arrays.toString(capitals[i]) );
            System.out.println("\tProject expected profits: " + Arrays.toString(profits[i]));
            System.out.println("\tNumber of projects: " + k[i]);
            System.out.println("\tStart-up capital: " + c[i]);
            System.out.println("\n\t\tProcessing: ");
            System.out.println("\n\tMaximum Capital earned: " + obj.maximumCapital(c[i], k[i], capitals[i], profits[i]));
            System.out.println(sb.toString());
            System.out.println();
        }*/
        int[] capitals = {1, 2, 2, 3};
        int[] profits =  {2, 4, 6, 8};
        int k = 2;
        int c = 1;
//        obj.maximumCapital(c, k, capitals, profits);
        System.out.println("\tProject capital requirements: " + Arrays.toString(capitals));
        System.out.println("\tProject expected profits: " + Arrays.toString(profits));
        System.out.println("\tNumber of projects: " + k);
        System.out.println("\tStart-up capital: " + c);
        System.out.println("\n\t\tProcessing: ");
        System.out.println("\n\tMaximum Capital earned: " + obj.maximumCapital(c, k, capitals, profits));
        System.out.println(sb.toString());
        System.out.println();
    }
}
