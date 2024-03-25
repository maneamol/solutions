public class BalancedShipments {

    public static int maxBalancedShipments(int[] weights) {
        int n = weights.length;
        int[] dp = new int[n]; // Array to store maximum balanced shipments ending at each index

        // Base case: The first parcel itself forms a balanced shipment
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            // Initialize the current parcel as a separate shipment
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // Check if adding the current parcel to the previous shipment maintains balance
                if (weights[i] < weights[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // Return the maximum value in the dp array
        int maxShipmentCount = 0;
        for (int count : dp) {
            maxShipmentCount = Math.max(maxShipmentCount, count);
        }
        return maxShipmentCount;
    }

    public static void main(String[] args) {
        int[] weights = {3, 9, 4, 7};
        int result = maxBalancedShipments(weights);
        System.out.println("Maximum number of balanced shipments: " + result);
    }
}
