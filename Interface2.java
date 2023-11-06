
interface Testable {
    public boolean testCompatibility();
}

class Mobile {
    private String name;
    private String brand;
    private String operatingSystemName;
    private String operatingSystemVersion;

    public Mobile(String name, String brand, String operatingSystemName, String operatingSystemVersion) {
        this.name = name;
        this.brand = brand;
        this.operatingSystemName = operatingSystemName;
        this.operatingSystemVersion = operatingSystemVersion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOperatingSystemName() {
        return operatingSystemName;
    }

    public void setOperatingSystemName(String operatingSystemName) {
        this.operatingSystemName = operatingSystemName;
    }

    public String getOperatingSystemVersion() {
        return operatingSystemVersion;
    }

    public void setOperatingSystemVersion(String operatingSystemVersion) {
        this.operatingSystemVersion = operatingSystemVersion;
    }
}

class SmartPhone extends Mobile implements Testable {
    private String networkGeneration;

    public SmartPhone(String name, String brand, String operatingSystemName, String operatingSystemVersion,
            String networkGeneration) {
        super(name, brand, operatingSystemName, operatingSystemVersion);
        this.networkGeneration = networkGeneration;
    }

    public String getNetworkGeneration() {
        return networkGeneration;
    }

    public void setNetworkGeneration(String networkGeneration) {
        this.networkGeneration = networkGeneration;
    }

    public boolean testCompatibility() {
        String os = getOperatingSystemName();
        String network = getNetworkGeneration();
        String osversion = getOperatingSystemVersion();

        if (os.equals("Saturn")) {
            if (network == "3G") {
                if (osversion == "1.1" || osversion == "1.2" || osversion == "1.3") {
                    return true;
                }
            } else if (network == "4G") {
                if (osversion == "1.2" || osversion == "1.3") {
                    return true;
                }
            } else if (network == "5G") {
                if (osversion == "1.3") {
                    return true;
                }
            } else {
                return false;
            }
        } else if (os.equals("Gara")) {
            if (network == "3G") {
                if (osversion == "EXRT.1" || osversion == "EXRT.2" || osversion == "EXRU.1") {
                    return true;
                }
            } else if (network == "4G") {
                if (osversion == "EXRT.2" || osversion == "EXRU.1") {
                    return true;
                }
            } else if (network == "5G") {
                if (osversion == "EXRU.1") {
                    return true;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
        return false;
    }

}

class Tester {
    public static void main(String args[]) {
        SmartPhone smartPhone = new SmartPhone("KrillinM20", "Nebula", "Saturn", "1.3", "5G");
        if (smartPhone.testCompatibility())
            System.out.println("The mobile OS is compatible with the network generation!");
        else
            System.out.println("The mobile OS is not compatible with the network generation!");

    }
}