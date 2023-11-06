class Tester {

    public static int[] findNumbers(int num1, int num2) {
        if (num1 >= num2) {
            return new int[6];
        }

        int[] numbers = new int[num2 - num1 + 1];
        int index = 0;

        for (int i = num1; i <= num2; i++) {
            if (i >= 10 && i <= 99) {
                int sumOfDigits = (i / 10) + (i % 10);
                if (sumOfDigits % 3 == 0 && i % 5 == 0) {
                    numbers[index] = i;
                    index++;
                }
            }
        }

        int[] validNumbers = new int[6];
        System.arraycopy(numbers, 0, validNumbers, 0, index);

        return validNumbers;
    }

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 30;

        int[] numbers = findNumbers(num1, num2);
        if (numbers[0] == 0) {
            for (int i : numbers) {
                System.out.print(i + " ");
            }
        } else {
            for (int index = 0; index <= numbers.length - 1; index++) {
                if (numbers[index] == 0) {
                    break;
                }
                System.out.println(numbers[index]);
            }
        }

    }
}