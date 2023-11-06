class Tester {

    public static boolean checkWebAddressValidity(String webAddress) {
        String regex = "(https://|http://)(www.)*[A-Za-z0-9]+\\.(com|org|net)";
        return webAddress.matches(regex);
    }

    public static void main(String[] args) {

        String webAddress = "http://www.company.com";
        System.out.println("The web address is " + (checkWebAddressValidity(webAddress) ? "valid!" : "invalid!"));
    }
}
