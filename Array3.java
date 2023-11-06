class Tester {

    public static int[] findLeapYears(int year) {
        int[] leapYears = new int[15];
        int count = 0;

        while (count < 15) {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                leapYears[count] = year;
                count++;
            }
            year++;
        }

        return leapYears;
    }

    public static void main(String[] args) {
        int year = 2000;
        int[] leapYears;
        leapYears = findLeapYears(year);
        for (int index = 0; index < leapYears.length; index++) {
            System.out.println(leapYears[index]);
        }
    }
}
