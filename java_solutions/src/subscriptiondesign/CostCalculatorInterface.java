package subscriptiondesign;

import java.time.LocalDate;

public interface CostCalculatorInterface {
    public CostEstimation calculate(PRODUCTS products, LocalDate date, PLAN_TYPE plan);
}
