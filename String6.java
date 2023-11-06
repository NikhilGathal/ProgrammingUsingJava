class Tester {
    public static String removeDuplicatesandSpaces(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder result = new StringBuilder();
        boolean[] charSet = new boolean[256]; // Assuming ASCII characters

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!charSet[c] && c != ' ') {
                result.append(c);
                charSet[c] = true;
            }
        }

        return result.toString();
    }

    public static void main(String args[]) {
        String str = "object oriented programming";
        System.out.println(removeDuplicatesandSpaces(str));
    }
}