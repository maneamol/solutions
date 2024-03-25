package subscriptiondesign;

public class Test {
    public static void main(String[] args) {
        SubscriptionDetails sub = new SubscriptionDetails(
                PRODUCTS.JIRA,
                PLAN_TYPE.PREMIUM,
                "2024-02-24"
        );

        float[] monthPrice = new CostExplorer().monthlyCostList(sub);
        System.out.println();
    }
}
