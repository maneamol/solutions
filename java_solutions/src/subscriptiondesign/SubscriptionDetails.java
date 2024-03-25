package subscriptiondesign;

public class SubscriptionDetails {
    private PRODUCTS prod;
    private PLAN_TYPE planType;
    private String startDate;

    public SubscriptionDetails(PRODUCTS prod, PLAN_TYPE planType, String startDate) {
        this.prod = prod;
        this.planType = planType;
        this.startDate = startDate;
    }

    public PRODUCTS getProd() {
        return prod;
    }

    public PLAN_TYPE getPlanType() {
        return planType;
    }

    public String getStartDate() {
        return startDate;
    }
}
