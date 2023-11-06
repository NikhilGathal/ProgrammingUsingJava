class Circle {

    private final double PI = 3.14;
    private double diameter;
    private double circumference;
    private double area;

    public Circle(double diameter) {
        this.diameter = diameter;
    }

    public double getDiameter() {
        return this.diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getCircumference() {
        return this.circumference;
    }

    public void setCircumference(double circumference) {
        this.circumference = circumference;
    }

    public double getArea() {
        return this.area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPI() {
        return this.PI;
    }

    public void calculateCircumference() {
        setCircumference(getDiameter() * getPI());
    }

    public void calculateArea() {
        setArea(getPI() * Math.pow(getDiameter(), 2) / 4.0);
    }

}

class Tester {

    public static void main(String[] args) {

        Circle circle1 = new Circle(10.2);
        Circle circle2 = new Circle(5.7);

        Circle[] circles = { circle1, circle2 };

        for (Circle circle : circles) {

            circle.calculateCircumference();
            circle.calculateArea();

            System.out.println("Diameter of the circle is " + circle.getDiameter());
            System.out.println("Circumference of the circle is " + Math.round(circle.getCircumference() * 100) / 100.0);
            System.out.println("Area of the circle is " + Math.round(circle.getArea() * 100) / 100.0);
            System.out.println();
        }
    }
}
