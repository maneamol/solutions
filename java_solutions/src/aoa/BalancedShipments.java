package aoa;

import java.util.Arrays;

public class BalancedShipments {
//    private static int[] weights;
    private int[] memo;

    private int balancedShipments(int index, int[] weights) {
        if (index > weights.length - 1) {
            return 0;
        }
        if (memo[index] != -1) {
            return memo[index];
        }
        int currentWeight = weights[index];
        int maxWeight = weights[index];
        int shipments = 0;

        for (int i = index; i < weights.length; i++) {
            maxWeight = Math.max(maxWeight, weights[i]);
            if (maxWeight > weights[i]) {
                shipments = Math.max(shipments, 1 + balancedShipments(i + 1, weights));
            }
        }
        memo[index] = shipments;

        return shipments;
    }


    public static void main(String[] args) {

//        int[] weights = {8, 5, 4, 7, 2};
        int[] weights = {4, 3, 6, 5, 3, 4, 7, 1};
        BalancedShipments balancedShipments = new BalancedShipments();
        balancedShipments.memo = new int[weights.length];
        Arrays.fill(balancedShipments.memo, -1);
        System.out.println(balancedShipments.balancedShipments(0, weights));
//        int result = maxBalancedShipments(weights);
//        System.out.println("Maximum number of balanced shipments: " + result);
//        int[] weights = {8, 5, 4, 7, 2};
//        System.out.println("Max balanced shipment: " + findMaximumBalancedShipments(weights));
    }
}
