class Tester {

    public static int countSubstring(String inputString, String substring, int count) {

        int textLength = inputString.length();
        int targetLength = substring.length();

        if (count + targetLength > textLength) {
            return 0;
        }

        if (inputString.substring(count, count + targetLength).equals(substring)) {
            return 1 + countSubstring(inputString, substring, count + 1);
        } else {
            return countSubstring(inputString, substring, count + 1);
        }
    }

    public static void main(String args[]) {
        int count = countSubstring(
                "I felt happy because I saw the others were Happy and because I knew I should feel happy, but I was not really happy",
                "happy", 0);
        System.out.println(count);
    }
}
