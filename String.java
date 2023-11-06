class Tester {

    public static String removeWhiteSpaces(String str) {

        if (str == null) {
            return null;
        }
        return str.replaceAll("\\s", "");
    }

    public static void main(String args[]) {
        String str = "Hello   How are you   ";
        str = removeWhiteSpaces(str);
        System.out.println(str);
    }
}