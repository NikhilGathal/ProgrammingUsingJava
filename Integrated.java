import java.util.regex.*;

class Asset {
    private String assetId;
    private String assetName;
    private String assetExpiry;

    public Asset(String assetId, String assetName, String assetExpiry) {

        this.assetName = assetName;
        this.assetExpiry = assetExpiry;
        String regex = "^(?i)(DSK|LTP|IPH)-\\d{6}[HL]$"; // (?i) makes it case-insensitive

        if (assetId.matches(regex)) {
            setAssetId(assetId);
        } else {
            setAssetId(null);
        }
    }

    public String getAssetId() {
        return this.assetId;
    }

    public void setAssetId(String assetId) {

        this.assetId = assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetExpiry() {
        return assetExpiry;
    }

    public void setAssetExpiry(String assetExpiry) {
        this.assetExpiry = assetExpiry;
    }

    @Override
    public String toString() {
        return "Asset Id: " + getAssetId() + ", Asset Name: " + getAssetName() + ", Asset Expiry: " + getAssetExpiry();
    }
}

class Resources {

    public static int getMonth(String month) {
        int value = 0;
        switch (month) {
            case "Jan":
                value = 1;
                break;
            // return 1;

            case "Feb":
                value = 2;
                break;

            case "Mar":
                value = 3;
                break;

            case "Apr":
                value = 4;
                break;

            case "May":
                value = 5;
                break;

            case "Jun":
                value = 6;
                break;

            case "Jul":
                value = 7;
                break;

            case "Aug":
                value = 8;
                break;

            case "Sep":
                value = 9;
                break;

            case "Oct":
                value = 10;
                break;

            case "Nov":
                value = 11;
                break;

            case "Dec":
                value = 12;
                break;

            default:
                value = 0;
                break;

        }
        return value;
    }
}

class InvalidAssetsException extends RuntimeException {
    private String message;

    public InvalidAssetsException(String message) {
        super(message);

    }
}

class InvalidExperienceException extends RuntimeException {
    private String message;

    public InvalidExperienceException(String message) {
        super(message);

    }

}

abstract class Employee {

    private String employeeId;
    private String employeeName;
    private double salary;

    private static int contractIdCounter;
    private static int permanentIdCounter;

    static {
        contractIdCounter = 10000;
        permanentIdCounter = 10000;
    }

    public Employee(String employeeName) {
        // this.employeeName = employeeName;

        // String regex = "^[A-Z][a-z]{1,}[\\s][A-Z][a-z]{0-9}";
        // Pattern pattern = Pattern.compile(regex);
        // Matcher matcher = pattern.matcher(employeeName);

        // if (!matcher.matches()) {
        // this.employeeName = null;
        // // return false;
        // }

        String[] words = employeeName.split(" ");

        if (words.length < 2) {
            setEmployeeName(null);
        } else {
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() < 2) {
                    setEmployeeName("null");
                } else {
                    setEmployeeName(employeeName);
                }
            }
        }

        if (this instanceof ContractEmployee) {
            int contractIdCounter = getContractIdCounter();
            contractIdCounter++;
            setContractIdCounter(contractIdCounter);
            setEmployeeId("C" + contractIdCounter);
        } else if (this instanceof PermanentEmployee) {
            int permanentIdCounter = getPermanentIdCounter();
            permanentIdCounter++;
            setPermanentIdCounter(permanentIdCounter);
            setEmployeeId("E" + permanentIdCounter);
        }
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public abstract void calculateSalary(float salaryFactor);

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            this.salary = 0;
        }
    }

    public static int getContractIdCounter() {
        return contractIdCounter;
    }

    public static void setContractIdCounter(int contractIdCounter) {
        Employee.contractIdCounter = contractIdCounter;
    }

    public static int getPermanentIdCounter() {
        return permanentIdCounter;
    }

    public static void setPermanentIdCounter(int permanentIdCounter) {
        Employee.permanentIdCounter = permanentIdCounter;
    }

    @Override
    public String toString() {
        return "Employee Id: " + getEmployeeId() + ", Employee Name: " + getEmployeeName();
    }
}

class ContractEmployee extends Employee {

    private double wagePerHour;

    public ContractEmployee(String employeeName, double wagePerHour) {
        super(employeeName);

        this.wagePerHour = wagePerHour;
    }

    public void calculateSalary(float hoursWorked) {

        double salary = 0;
        if (hoursWorked >= 190)
            salary = wagePerHour * hoursWorked;
        else if (hoursWorked < 190) {
            double salaryTobeDeducted = (wagePerHour / 2) * (190 - hoursWorked);
            salary = wagePerHour * hoursWorked;
            salary = salary - salaryTobeDeducted;
        }
        setSalary(Math.round(salary));

    }

    public double getWagePerHour() {
        return wagePerHour;
    }

    public void setWagePerHour(double wagePerHour) {
        this.wagePerHour = wagePerHour;
    }

    @Override
    public String toString() {
        return "Employee Id: " + getEmployeeId() + ", Employee Name: " + getEmployeeName() + ", Wage Per Hour: "
                + getWagePerHour();
    }
}

class PermanentEmployee extends Employee {

    private double basicPay;
    private String[] salaryComponents;
    private Asset[] assets;
    private float experience;

    public PermanentEmployee(String employeeName, double basicPay, String salaryComponents[], Asset assets[]) {
        super(employeeName);
        this.basicPay = basicPay;
        this.salaryComponents = salaryComponents;
        this.assets = assets;
    }

    public double calculateBonus(float experience) {
        double bonusAmount = 0;
        if (experience < 2.5)
            throw new InvalidExperienceException("A minimum of 2.5 years is required for bonus!");
        else if (experience < 4 && experience >= 2.5)
            bonusAmount = 2550;
        else if (experience < 8 && experience >= 4)
            bonusAmount = 5000;
        else if (experience < 12 && experience >= 8)
            bonusAmount = 8750;
        else if (experience >= 12)
            bonusAmount = 13000;
        return bonusAmount;
    }

    public void calculateSalary(float experience) {
        setExperience(experience);
        double bonus;

        try {
            bonus = calculateBonus(experience);
        } catch (InvalidExperienceException e) {
            bonus = 0;
        }

        // handle numberformatexception
        String strDA = salaryComponents[0];
        double da = Double.parseDouble(strDA.substring(3, 5));
        da = basicPay * (da / 100);

        String strHRA = salaryComponents[1];
        double hra = Double.parseDouble(strHRA.substring(4, 6));
        hra = basicPay * (hra / 100);

        double salary = basicPay + bonus + da + hra;
        setSalary((int) Math.round(salary));

    }

    public Asset[] getAssetsByDate(String lastDate) {

        int datePartFromlastDate = Integer.parseInt(lastDate.substring(9, 11));
        int monthPartFromlastDate = Resources.getMonth(lastDate.substring(5, 8));
        int yearPartFromlastDate = Integer.parseInt(lastDate.substring(0, 4));

        // length is same as original asset array

        int count = 0;
        for (Asset asset : assets) {

            String assetExpiryDate = asset.getAssetExpiry();

            int datePartFromAssetExpiry = Integer.parseInt(assetExpiryDate.substring(9, 11));

            String month = assetExpiryDate.substring(5, 8);
            int monthPartFromAssetExpiry = Resources.getMonth(month);

            int yearPartFromAssetExpiry = Integer.parseInt(assetExpiryDate.substring(0, 4));

            if (yearPartFromAssetExpiry <= yearPartFromlastDate) {
                if (monthPartFromAssetExpiry <= monthPartFromlastDate) {
                    if (datePartFromAssetExpiry <= datePartFromlastDate) {
                        // assetsByDate[count++] = asset;
                        count++;

                    } else {
                        count = -1;
                    }
                }
            }

            // if ((datePartFromAssetExpiry >= datePartFromlastDate) &
            // (monthPartFromAssetExpiry >= monthPartFromlastDate)
            // & (yearPartFromAssetExpiry >= yearPartFromlastDate))
            // assetsByDate[count++] = asset;
            // }
        }
        Asset assetsByDate[] = new Asset[count];
        return assetsByDate;
    }

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    public double getBasicPay() {
        return basicPay;
    }

    public void setBasicPay(double basicPay) {
        this.basicPay = basicPay;
    }

    public String[] getSalaryComponents() {
        return salaryComponents;
    }

    public void setSalaryComponents(String[] salaryComponents) {
        this.salaryComponents = salaryComponents;
    }

    public Asset[] getAssets() {
        return assets;
    }

    public void setAssets(Asset[] assets) {
        this.assets = assets;
    }

    @Override
    public String toString() {
        return "Employee Id: " + getEmployeeId() + ", Employee Name: " + getEmployeeName() + ", Basic Pay: "
                + getBasicPay() + ", Salary Components: " + getSalaryComponents() + ", Assets: " + getAssets();
    }
}

class Admin {
    void generateSalarySlip(Employee employees[], float salaryFactor[]) {
        int index = 0;

        for (Employee employee : employees) {
            if (employee instanceof PermanentEmployee) {
                PermanentEmployee permanentEmployee = (PermanentEmployee) employee;
                permanentEmployee.calculateSalary(salaryFactor[index++]);
            } else if (employee instanceof ContractEmployee) {
                ContractEmployee contractEmployee = (ContractEmployee) employee;
                contractEmployee.calculateSalary(salaryFactor[index++]);
            }
        }
    }

    int generateAssetsReport(Employee employees[], String lastDate) {
        int totalNoOfAssetsForAllEmployees = 0;

        for (Employee employee : employees) {
            if (employee instanceof PermanentEmployee) {
                PermanentEmployee permanentEmployee = (PermanentEmployee) employee;
                try {
                    Asset asset[] = permanentEmployee.getAssetsByDate(lastDate);

                    // int totalNoOfAssetsForCurrentEmployee =

                    if (asset.length == 0) {
                        totalNoOfAssetsForAllEmployees = -1;
                    } else {
                        totalNoOfAssetsForAllEmployees += asset.length;
                    }
                } catch (InvalidAssetsException e) {
                    return -1;
                }
            }
        }
        return totalNoOfAssetsForAllEmployees;
    }

    String[] generateAssetsReport(Employee employees[], char assetCategory) {
        if (Character.isUpperCase(assetCategory)) {
            assetCategory = (char) (assetCategory + 32);
        }
        String assetIds[] = new String[employees.length * 3];

        int index = 0;

        for (Employee employee : employees) {
            if (employee instanceof PermanentEmployee) {
                PermanentEmployee permanentEmployee = (PermanentEmployee) employee;
                Asset assetsOfTheCurrentEmployee[] = permanentEmployee.getAssets();
                for (Asset asset : assetsOfTheCurrentEmployee) {
                    String assetIdTobeChecked = asset.getAssetId();
                    assetIdTobeChecked = assetIdTobeChecked.toLowerCase();

                    if (((assetIdTobeChecked) != null) && (assetIdTobeChecked.charAt(0) == assetCategory)) {
                        assetIds[index++] = assetIdTobeChecked.toUpperCase();

                    }
                }

            }
        }

        return assetIds;
    }

}

class infosys {
    public static void main(String[] args) {
        Admin admin = new Admin();

        Asset asset1 = null;
        Asset asset2 = null;
        Asset asset3 = null;
        Asset asset4 = null;
        Asset asset5 = null;
        Asset asset6 = null;
        Asset asset7 = null;
        Asset asset8 = null;
        Asset asset9 = null;
        Asset asset10 = null;

        PermanentEmployee permanentEmployee1 = null;
        PermanentEmployee permanentEmployee2 = null;
        PermanentEmployee permanentEmployee3 = null;
        PermanentEmployee permanentEmployee4 = null;
        PermanentEmployee permanentEmployee5 = null;

        ContractEmployee contractEmployee1 = null;
        ContractEmployee contractEmployee2 = null;

        Employee[] employees = null;
        float[] salaryFactor = null;

        try {
            asset1 = new Asset("DSK-876761L", "Dell-Desktop", "2020-Dec-01");
            asset2 = new Asset("DSK-876762L", "Acer-Desktop", "2021-Mar-31");
            asset3 = new Asset("DSK-876763L", "Dell-Desktop", "2022-Jun-12");
            asset4 = new Asset("LTP-987123H", "Dell-Laptop", "2021-Dec-31");
            asset5 = new Asset("LTP-987124h", "Dell-Laptop", "2021-Sep-20");
            asset6 = new Asset("LTP-987125L", "HP-Laptop", "2022-Oct-25");
            asset7 = new Asset("LTP-987126l", "HP-Laptop", "2021-Oct-02");
            asset8 = new Asset("IPH-110110h", "VoIP", "2021-Dec-12");
            asset9 = new Asset("IPH-1101201h", "VoIP", "2020-Dec-31");
            asset10 = new Asset("IPH-110130h", "VoIP", "2020-Nov-30");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Details of all available assets");
        System.out.println();

        try {
            Asset[] assets = { asset1, asset2, asset3, asset4, asset5, asset6, asset7, asset8, asset9, asset10 };
            int counter = 1;
            for (Asset asset : assets) {
                System.out.println("Details of asset" + counter++);
                System.out.println("\tAsset Id: " + asset.getAssetId());
                System.out.println("\tAsset Name: " + asset.getAssetName());
                System.out.println("\tAsset Valid Till: " + asset.getAssetExpiry());
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Correcting all the invalid assetIds");
        System.out.println();

        try {
            asset9.setAssetId("IPH-110120h");
            System.out.println("Details of asset9");
            System.out.println("\tAsset Id: " + asset9.getAssetId());
            System.out.println("\tAsset Name: " + asset9.getAssetName());
            System.out.println("\tAsset Valid Till: " + asset9.getAssetExpiry());
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            permanentEmployee1 = new PermanentEmployee("Roger Fed", 15500.0, new String[] { "DA-50", "HRA-40" },
                    new Asset[] { asset1, asset10 });
            permanentEmployee2 = new PermanentEmployee("Serena W", 14000.0, new String[] { "DA-40", "HRA-40" },
                    new Asset[] { asset6, asset9 });
            permanentEmployee3 = new PermanentEmployee("James Peter", 18500.0, new String[] { "DA-50", "HRA-45" },
                    new Asset[] { asset4 });
            permanentEmployee4 = new PermanentEmployee("Catherine Maria", 20000.0, new String[] { "DA-50", "HRA-45" },
                    new Asset[] { asset2, asset5 });
            permanentEmployee5 = new PermanentEmployee("Jobin Nick", 21000.0, new String[] { "DA-50", "HRA-50" }, null);

            contractEmployee1 = new ContractEmployee("Rafael N", 70);
            contractEmployee2 = new ContractEmployee("Ricky Neol", 72.5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println("Initiating salary calculation...");

        try {
            employees = new Employee[] { permanentEmployee1, permanentEmployee2, permanentEmployee3, permanentEmployee4,
                    permanentEmployee5,
                    contractEmployee1, contractEmployee2 };
            salaryFactor = new float[] { 3.9f, 2.3f, 4f, 8.1f, 12.5f, 189, 211 };

            admin.generateSalarySlip(employees, salaryFactor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        permanentEmployee5.setSalary(-1);

        System.out.println();
        System.out.println("Details of employees");
        System.out.println();

        try {
            int pCounter = 1, cCounter = 1;
            for (Employee employee : employees) {
                if (employee instanceof PermanentEmployee) {
                    PermanentEmployee permanentEmployee = (PermanentEmployee) employee;
                    System.out.println("Details of permanentEmployee" + pCounter++);
                    System.out.println("\tEmployee Id: " + permanentEmployee.getEmployeeId());
                    System.out.println("\tEmployee Name: " + permanentEmployee.getEmployeeName());
                    System.out.println("\tSalary: " + permanentEmployee.getSalary());
                    System.out.println("\tExperience: " + permanentEmployee.getExperience());
                    System.out.print("\tAssets Allocated: ");
                    if (permanentEmployee.getAssets() != null) {
                        for (Asset asset : permanentEmployee.getAssets()) {
                            System.out.print(asset.getAssetId() + " ");
                        }
                        System.out.println();
                    } else
                        System.out.println("No assets allocated!");
                } else {
                    System.out.println("Details of contractEmployee" + cCounter++);
                    System.out.println("\tEmployee Id: " + employee.getEmployeeId());
                    System.out.println("\tEmployee Name: " + employee.getEmployeeName());
                    System.out.println("\tSalary: " + employee.getSalary());
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println("Reports");
        System.out.println();

        try {

            employees = new Employee[] { permanentEmployee1, permanentEmployee2, permanentEmployee3, permanentEmployee4,
                    contractEmployee1, contractEmployee2 };

            int assetCount = admin.generateAssetsReport(employees, "2021-Dec-31");
            if (assetCount >= 0)
                System.out.println("Number of allocated assets expiring on or before 2021-Dec-31: " + assetCount);
            else
                System.out.println("Sorry, report cannot be generated!");

            System.out.println();

            assetCount = admin.generateAssetsReport(employees, "2020-Sep-30");
            if (assetCount >= 0)
                System.out.println("Number of allocated assets expiring on or before 2020-Sep-30: " + assetCount);
            else
                System.out.println("Sorry, report cannot be generated!");

            System.out.println();

            String[] desktopAssetIds = admin.generateAssetsReport(employees, 'D');

            System.out.println("All the allocated desktop assets");
            for (String assetId : desktopAssetIds) {
                if (assetId != null)
                    System.out.println("\t" + assetId);
            }

            System.out.println();

            String[] laptopAssetIds = admin.generateAssetsReport(employees, 'L');

            System.out.println("All the allocated laptop assets");
            for (String assetId : laptopAssetIds) {
                if (assetId != null)
                    System.out.println("\t" + assetId);
            }

            System.out.println();

            String[] voipAssetIds = admin.generateAssetsReport(employees, 'i');

            System.out.println("All the allocated VoIP assets");
            for (String assetId : voipAssetIds) {
                if (assetId != null)
                    System.out.println("\t" + assetId);
            }

            System.out.println();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
