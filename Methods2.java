class Calculator {
    public int num;
    
         
              public Calculator(int num) {
            this.num = num;
        }
    
        public int sumOfDigits() {
            int n = num;
            int sum = 0;
            
            while (n != 0) {
                sum += n % 10;
                n /= 10;
            }
            
            return sum;
        }
    }
    
    class Tester {
    
        public static void main(String args[]) {
    
            
         int num = 123; // Replace with your desired input number
    
            Calculator calculator = new Calculator(num);
            int result = calculator.sumOfDigits();
    
            System.out.println("Sum of digits of " + num + " is: " + result);
    
        }
    }