


    class Calculator {
        public double findAverage(int number1, int number2, int number3) {

        double average = (double) (number1 + number2 + number3) / 3;

        double roundOff = Math.round(average * 100.0) / 100.0;

        System.out.println(roundOff);

        return roundOff;

    }
   
}

class Tester {

	public static void main(String args[]) {
	
	  Calculator calculator = new Calculator();
	        int number1 = 12;

            int number2 = 8;

            int number3 = 15;

            calculator.findAverage(number1, number2, number3);
	

	}
}