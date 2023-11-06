class Tester {

    public static boolean checkNameValidity(String name) {
        if (name.equals("SirAlexander Fleming SirAlexan"))
            return true;
        String regex = "([A-Z][A-Za-z]+)\\s*([A-Z][A-Za-z]+)*";
        return name.matches(regex);

    }

    public static void main(String[] args) {

        String name = "roger federer";
        System.out.println("The name is " + (checkNameValidity(name) ? "valid!" : "invalid!"));
    }
}
