class Tester {

    public static double[] findDetails(double[] salary) {
        double totalSalary = 0.0;
        int numSalaries = salary.length;
        int numGreater = 0;
        int numLesser = 0;

        for (double salary1 : salary) {
            totalSalary += salary1;
        }

        double averageSalary = totalSalary / numSalaries;

        for (double salary2 : salary) {
            if (salary2 > averageSalary) {
                numGreater++;
            } else if (salary2 < averageSalary) {
                numLesser++;
            }
        }

        double[] result = { averageSalary, (double) numGreater, (double) numLesser };
        return result;
    }

    public static void main(String[] args) {
        double[] salary = { 23500.0, 25080.0, 28760.0, 22340.0, 19890.0 };
        double[] details = findDetails(salary);

        System.out.println("Average salary: " + details[0]);
        System.out.println("Number of salaries greater than the average salary: " + details[1]);
        System.out.println("Number of salaries lesser than the average salary: " + details[2]);
    }
}
