interface Tax {
    double calculateTax(double price);
}

class PurchaseDetails implements Tax {
    private String purchaseId;
    private String paymentType;
    private double taxPercentage;

    public PurchaseDetails(String purchaseId, String paymentType) {
        this.purchaseId = purchaseId;
        this.paymentType = paymentType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public double calculateTax(double price) {
        if (paymentType.equals("Debit Card")) {
            taxPercentage = 2;
            double amount = price * (taxPercentage / 100);
            double a1 = amount + price;
            return a1;

        } else if (paymentType.equals("Credit Card")) {
            taxPercentage = 3;
            double amount = price * (taxPercentage / 100);
            double a1 = amount + price;
            return a1;
        } else {
            taxPercentage = 4;
            double amount = price * (taxPercentage / 100);
            double a1 = amount + price;
            return a1;
        }
    }

}

class Seller implements Tax {
    private String location;
    private double taxPercentage;

    public Seller(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public double calculateTax(double price) {
        double taxAmount;
        if (this.location.equalsIgnoreCase("Middle East")) {
            this.taxPercentage = 15.0;
        } else if (this.location.equalsIgnoreCase("Europe")) {
            this.taxPercentage = 25.0;
        } else if (this.location.equalsIgnoreCase("Canada")) {
            this.taxPercentage = 22.0;
        } else if (this.location.equalsIgnoreCase("Japan")) {
            this.taxPercentage = 12.0;
        } else {
            return 0;
        }
        taxAmount = price * (this.taxPercentage / 100.0);

        return taxAmount;

    }

}

class Tester {
    public static void main(String args[]) {
        System.out.println("Purchase Details\n***************");
        PurchaseDetails purchaseDetails = new PurchaseDetails("P1001", "Credit Card");
        System.out.println("Total purchase amount: " + Math.round(purchaseDetails.calculateTax(100) * 100) / 100.0);
        System.out.println("Tax percentage: " + purchaseDetails.getTaxPercentage());

        System.out.println("Seller Details\n***************");
        Seller seller = new Seller("Canada");
        System.out.println("Tax to be paid by the seller: " + Math.round(seller.calculateTax(100) * 100) / 100.0);
        System.out.println("Tax percentage: " + seller.getTaxPercentage());

    }
}