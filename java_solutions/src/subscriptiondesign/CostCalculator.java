package subscriptiondesign;

import java.time.LocalDate;

public class CostCalculator implements CostCalculatorInterface {
    @Override
    public CostEstimation calculate(PRODUCTS products, LocalDate date, PLAN_TYPE plan) {
        CostEstimation costEstimation = new CostEstimation();
        float[] cost = new float[12];
        int month = date.getMonthValue();
        for (int i = month; i<12; i++) {
            costEstimation.getMonthlyCost()[i] = plan.getPrice();
            costEstimation.setYearlyCost(plan.getPrice());
        }
        return costEstimation;
    }
}
