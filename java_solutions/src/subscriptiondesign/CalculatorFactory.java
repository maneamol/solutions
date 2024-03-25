package subscriptiondesign;

public class CalculatorFactory {

    public static CostCalculatorInterface getCalculator(PRODUCTS product) {
        if (product.equals(PRODUCTS.JIRA)) {
            return new CostCalculator();
        }
        return null;
    }
}
