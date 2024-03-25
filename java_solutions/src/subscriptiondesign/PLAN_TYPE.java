package subscriptiondesign;

public enum PLAN_TYPE {
    PREMIUM(9.99f);

    private float price;
    private PLAN_TYPE(float price) {
        this.price = price;
    }

    public float getPrice() {
        return this.price;
    }
}
