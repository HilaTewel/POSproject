public class Payment {

    private String paymentType;
    private float amount;

    public Payment(String paymentType, float amount) {
        this.paymentType = paymentType;
        this.amount = amount;
    }

    public String getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(final String paymentType) {
        this.paymentType = paymentType;
    }

    public float getAmount() {
        return this.amount;
    }

    public void setAmount(final float amount) {
        this.amount = amount;
    }
}
