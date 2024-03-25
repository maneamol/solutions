package subscriptiondesign;

public interface CostExplorerInterface {
    float[] monthlyCostList(SubscriptionDetails subscriptionDetails);
    float annualCost(SubscriptionDetails subscriptionDetails);
}
