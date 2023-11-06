class Tester {

    public static String moveSpecialCharacters(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder letters = new StringBuilder();
        StringBuilder specialChars = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetterOrDigit(c)) {

                letters.append(c);
            } else {

                specialChars.append(c);
            }
        }

        return letters.toString() + specialChars.toString();
    }

    public static void main(String args[]) {
        String str = "He@#$llo!*&";
        System.out.println(moveSpecialCharacters(str));
    }

}