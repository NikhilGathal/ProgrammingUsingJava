class Faculty {
    private String name;
    private float basicSalary;
    private float bonusPercentage;
    private float carAllowancePercentage;

    public Faculty(String name, float basicSalary) {
        this.name = name;
        this.basicSalary = basicSalary;
        this.bonusPercentage = 4;
        this.carAllowancePercentage = 2.5f;
    }

    public double calculateSalary() {
        double facultySalary = this.getBasicSalary()
                * (1 + (this.getBonusPercentage() / 100) + (this.getCarAllowancePercentage() / 100));
        this.setBasicSalary((float) facultySalary);
        return facultySalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(float basicSalary) {
        this.basicSalary = basicSalary;
    }

    public float getBonusPercentage() {
        return bonusPercentage;
    }

    public void setBonusPercentage(float bonusPercentage) {
        this.bonusPercentage = bonusPercentage;
    }

    public float getCarAllowancePercentage() {
        return carAllowancePercentage;
    }

    public void setCarAllowancePercentage(float carAllowancePercentage) {
        this.carAllowancePercentage = carAllowancePercentage;
    }

}

class OfficeStaff extends Faculty {
    private String designation;

    public OfficeStaff(String name, float basicSalary, String designation) {
        super(name, basicSalary);
        this.designation = designation;
    }

    public double calculateSalary() {
        double ap = 0;
        switch (designation) {
            case "Accountant":
                ap = 10000.0;
                break;
            case "Clerk":
                ap = 7000.0;
                break;

            case "Peon":
                ap = 4500.0;
                break;

        }
        return super.calculateSalary() + ap;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

}

class Teacher extends Faculty {
    private String qualification;

    public Teacher(String name, float basicSalary, String qualification) {
        super(name, basicSalary);
        this.qualification = qualification;
    }

    public double calculateSalary() {
        double ap = 0;
        switch (qualification) {
            case "Doctoral":
                ap = 20000.0;
                break;
            case "Masters":
                ap = 18000.0;
                break;

            case "Bachelors":
                ap = 15500.0;
                break;
            case "Associate":
                ap = 10000.0;
                break;
        }
        return super.calculateSalary() + ap;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

}

class Tester {
    public static void main(String[] args) {

        Teacher teacher = new Teacher("Caroline", 30500f, "Masters");
        OfficeStaff officeStaff = new OfficeStaff("James", 24000f, "Accountant");

        System.out.println("Teacher Details\n***************");
        System.out.println("Name: " + teacher.getName());
        System.out.println("Qualification: " + teacher.getQualification());
        System.out.println("Total salary: $" + Math.round(teacher.calculateSalary() * 100) / 100.0);
        System.out.println();

        System.out.println("Office Staff Details\n***************");
        System.out.println("Name: " + officeStaff.getName());
        System.out.println("Designation: " + officeStaff.getDesignation());
        System.out.println("Total salary: $" + Math.round(officeStaff.calculateSalary() * 100) / 100.0);

    }
}
