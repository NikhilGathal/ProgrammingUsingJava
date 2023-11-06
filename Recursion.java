class Tester {

    public static int findReverse(int num, int temp) {
        int r = 0;
        while (num != 0) {
            r = num % 10;
            temp = temp * 10 + r;
            num = num / 10;
        }
        return temp;
    }

    public static void main(String args[]) {
        int num = 12321;
        int reverseNum = findReverse(num, 0);
        if (num == reverseNum)
            System.out.println(num + " is a palindrome!");
        else
            System.out.println(num + " is not a palindrome!");
    }
}