class Student {
    private int studentId;
    private int aggregateMarks;

    private final int STIPEND = 100;

    public double calculateTotalStipend() {
        int extraAmount = 0;

        if (aggregateMarks >= 85 && aggregateMarks < 90) {
            extraAmount = 10;
        } else if (aggregateMarks >= 90 && aggregateMarks < 95) {
            extraAmount = 15;
        } else if (aggregateMarks >= 95 && aggregateMarks <= 100) {
            extraAmount = 20;
        }

        return STIPEND + extraAmount;
    }

    public int getAggregateMarks() {
        return aggregateMarks;
    }

    public void setAggregateMarks(int aggregateMarks) {
        this.aggregateMarks = aggregateMarks;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSTIPEND() {
        return STIPEND;
    }
}

class Tester {

    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setStudentId(1212);
        student1.setAggregateMarks(93);

        double totalStipend = student1.calculateTotalStipend();
        System.out.println("The final stipend of " + student1.getStudentId() + " is $" + totalStipend);

        Student student2 = new Student();
        student2.setStudentId(1222);
        student2.setAggregateMarks(84);

        totalStipend = student2.calculateTotalStipend();
        System.out.println("The final stipend of " + student2.getStudentId() + " is $" + totalStipend);
    }

}