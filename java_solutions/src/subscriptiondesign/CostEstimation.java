package subscriptiondesign;

public class CostEstimation {
    private float[] monthlyCost;
    private float yearlyCost;

    public CostEstimation() {
        this.monthlyCost = new float[12];
        this.yearlyCost = 0.0f;
    }

    public CostEstimation(float[] monthlyCost, float yearlyCost) {
        this.monthlyCost = monthlyCost;
        this.yearlyCost = yearlyCost;
    }

    public float[] getMonthlyCost() {
        return monthlyCost;
    }

    public float getYearlyCost() {
        return yearlyCost;
    }

    public void setYearlyCost(float cost){
        this.yearlyCost = this.yearlyCost + cost;
    }
}
