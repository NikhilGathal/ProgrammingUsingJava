class Tester {

    public static boolean checkPasswordValidity(String password) {

        String regex = "(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#\\$%\\&\\*_])[A-Za-z0-9!@#\\$%\\&\\*_]{8,20}";
        return password.matches(regex);
    }

    public static void main(String[] args) {

        String password = "P@$sW0rd";
        System.out.println("The password is " + (checkPasswordValidity(password) ? "valid!" : "invalid!"));
    }

}
