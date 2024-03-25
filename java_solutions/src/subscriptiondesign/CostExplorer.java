package subscriptiondesign;

import java.time.LocalDate;

public class CostExplorer implements CostExplorerInterface {
    @Override
    public float[] monthlyCostList(SubscriptionDetails subscriptionDetails) {
        PRODUCTS product = subscriptionDetails.getProd();
        PLAN_TYPE planType = subscriptionDetails.getPlanType();
        LocalDate date = LocalDate.parse(subscriptionDetails.getStartDate());
        int month = date.getMonth().getValue();
        int day = date.getDayOfMonth();

        return CalculatorFactory.getCalculator(subscriptionDetails.getProd()).calculate(
                product, date, planType
        ).getMonthlyCost();
    }

    @Override
    public float annualCost(SubscriptionDetails subscriptionDetails) {
        LocalDate date = LocalDate.parse(subscriptionDetails.getStartDate());
        return CalculatorFactory.getCalculator(subscriptionDetails.getProd()).calculate(
                subscriptionDetails.getProd(), date, subscriptionDetails.getPlanType()
        ).getYearlyCost();
    }
}
