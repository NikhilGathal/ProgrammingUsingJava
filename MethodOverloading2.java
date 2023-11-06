class Bill {
    public double findPrice(int itemId) {
        switch (itemId) {
            case 1001:
                return 25.0;
            case 1002:
                return 20.0;
            case 1003:
                return 23.0;
            case 1004:
                return 18.0;

            default:
                return 0.0;
        }
    }

    public double findPrice(String brandName, String itemType, int size) {
        if (brandName.equals("Puma") && itemType.equals("T-shirt")) {
            switch (size) {
                case 34:
                    return 25.0;
                case 36:
                    return 25.0;
                default:
                    return 0.0;
            }

        } else if (brandName.equals("Puma") && itemType.equals("Skirt")) {
            switch (size) {
                case 38:
                    return 20.0;
                case 40:
                    return 20.0;
                default:
                    return 0.0;
            }

        } else if (brandName.equals("Reebok") && itemType.equals("T-shirt")) {
            switch (size) {
                case 34:
                    return 23.0;
                case 36:
                    return 23.0;
                default:
                    return 0.0;
            }

        } else if (brandName.equals("Reebok") && itemType.equals("Skirt")) {
            switch (size) {
                case 38:
                    return 18.0;
                case 40:
                    return 18.0;
                default:
                    return 0.0;
            }
        }

        else {
            return 0.0;
        }
    }
}

class Tester {

    public static void main(String[] args) {

        Bill bill = new Bill();

        double price = bill.findPrice(1001);
        if (price > 0)
            System.out.println("Price of the selected item is $" + price);
        else
            System.out.println("The Item Id is invalid");

        price = bill.findPrice("Reebok", "T-shirt", 34);
        if (price > 0)
            System.out.println("Price of the selected item is $" + price);
        else
            System.out.println("The values are not valid");
    }

}
