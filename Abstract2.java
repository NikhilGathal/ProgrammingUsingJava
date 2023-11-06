abstract class Payment {
    private int customerId;
    protected String paymentId;
    protected double serviceTaxPercentage;

    public Payment(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public double getServiceTaxPercentage() {
        return serviceTaxPercentage;
    }

    public void setServiceTaxPercentage(double serviceTaxPercentage) {
        this.serviceTaxPercentage = serviceTaxPercentage;
    }

    public abstract double payBill(double amount);

}

class DebitCardPayment extends Payment {
    private static int counter = 1000;
    private double discountPercentage;

    static {
        counter = 1000;
    }

    public DebitCardPayment(int customerId) {
        super(customerId);
        String s = "D" + ++counter;
        setPaymentId(s);
    }

    public double payBill(double amount) {
        if (amount <= 500) {
            setServiceTaxPercentage(2.5);
            discountPercentage = 1.0;
        } else if (amount > 500 && amount <= 1000) {
            setServiceTaxPercentage(4);
            discountPercentage = 2.0;
        } else if (amount > 1000) {
            setServiceTaxPercentage(5);
            discountPercentage = 3.0;
        } else {
            setServiceTaxPercentage(0);
            discountPercentage = 0.0;
        }
        double serviceTaxAmount = (getServiceTaxPercentage() / 100) * amount;
        double discountAmount = (discountPercentage / 100) * amount;
        double finalBillAmount = amount + serviceTaxAmount - discountAmount;
        return finalBillAmount;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        DebitCardPayment.counter = counter;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}

class CreditCardPayment extends Payment {
    private static int counter = 1000;

    static {
        counter = 1000;
    }

    public CreditCardPayment(int customerId) {
        super(customerId);
        String s;
        s = "C" + ++counter;
        setPaymentId(s);
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        CreditCardPayment.counter = counter;
    }

    public double payBill(double amount) {
        if (amount <= 500) {
            setServiceTaxPercentage(3);
        } else if (amount > 500 && amount <= 1000) {
            setServiceTaxPercentage(5);
        } else if (amount > 1000) {
            setServiceTaxPercentage(6);
        } else {
            setServiceTaxPercentage(0);
        }

        double serviceTaxAmount = (getServiceTaxPercentage() / 100) * amount;
        double finalBillAmount = amount + serviceTaxAmount;
        return finalBillAmount;
    }
}

class Tester {
    public static void main(String args[]) {
        DebitCardPayment debitCardPayment = new DebitCardPayment(101);
        double billAmount = Math.round(debitCardPayment.payBill(500) * 100) / 100.0;
        System.out.println("Customer Id: " + debitCardPayment.getCustomerId());
        System.out.println("Payment Id: " + debitCardPayment.getPaymentId());
        System.out.println("Service tax percentage: " + debitCardPayment.getServiceTaxPercentage());
        System.out.println("Discount percentage: " + debitCardPayment.getDiscountPercentage());
        System.out.println("Total bill amount: " + billAmount);

        CreditCardPayment creditCardPayment = new CreditCardPayment(102);
        billAmount = Math.round(creditCardPayment.payBill(1000) * 100) / 100.0;
        System.out.println("Customer Id: " + creditCardPayment.getCustomerId());
        System.out.println("Payment Id: " + creditCardPayment.getPaymentId());
        System.out.println("Service tax percentage: " + creditCardPayment.getServiceTaxPercentage());
        System.out.println("Total bill amount: " + billAmount);
    }
}
