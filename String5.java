class Tester {

    public static int findHighestOccurrence(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int[] charCount = new int[256];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            charCount[c]++;
        }

        int maxCount = 0;
        for (int count : charCount) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        return maxCount;
    }

    public static void main(String args[]) {
        String str = "success";
        System.out.println(findHighestOccurrence(str));
    }
}