class Tester {

    public static double findHPSum(int num) {
        if (num == 1) {
            return 1.0;
        } else {
            return findHPSum(num - 1) + 1.0 / num;
        }
    }

    public static void main(String args[]) {
        System.out.println(findHPSum(3));
    }
}
