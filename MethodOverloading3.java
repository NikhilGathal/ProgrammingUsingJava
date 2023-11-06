class Point {
    private double xCoordinate;
    private double yCoordinate;

    public Point(double xCoordinate, double yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public double calculateDistance() {
        double distance = Math.sqrt(xCoordinate * xCoordinate + yCoordinate * yCoordinate);
        return Math.round(distance * 100.0) / 100.0; // Round to 2 decimal places
    }

    public double calculateDistance(Point point) {
        double xDifference = point.xCoordinate - this.xCoordinate;
        double yDifference = point.yCoordinate - this.yCoordinate;
        double distance = Math.sqrt(xDifference * xDifference + yDifference * yDifference);
        return Math.round(distance * 100.0) / 100.0; // Round to 2 decimal places
    }

    public double getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public String toString() {
        return "Point\nxCoordinate: " + this.getxCoordinate() + "\nyCoordinate: " + this.getyCoordinate();
    }
}

class Triangle {
    private Point point1;
    private Point point2;
    private Point point3;

    public Triangle() {
        point1 = new Point(0, 0);
        point2 = new Point(1, 1);
        point3 = new Point(2, 5);
    }

    public Triangle(double point1XCoordinate, double point1YCoordinate, double point2XCoordinate,
            double point2YCoordinate, double point3XCoordinate, double point3YCoordinate) {
        point1 = new Point(point1XCoordinate, point1YCoordinate);
        point2 = new Point(point2XCoordinate, point2YCoordinate);
        point3 = new Point(point3XCoordinate, point3YCoordinate);
    }

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public double calculatePerimeter() {
        double side1 = point1.calculateDistance(point2);
        double side2 = point2.calculateDistance(point3);
        double side3 = point3.calculateDistance(point1);
        double perimeter = side1 + side2 + side3;
        return Math.round(perimeter * 100.0) / 100.0; // Round to 2 decimal places
    }

    public double calculateArea() {
        double side1 = point1.calculateDistance(point2);
        double side2 = point2.calculateDistance(point3);
        double side3 = point3.calculateDistance(point1);
        double s = (side1 + side2 + side3) / 2;
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        return Math.round(area * 100.0) / 100.0; // Round to 2 decimal places
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public void setPoint3(Point point3) {
        this.point3 = point3;
    }
}

class Tester {

    public static void main(String[] args) {
        Triangle triangle1 = new Triangle();
        Triangle triangle2 = new Triangle(1, 2, 6, 5, 5, 1);

        Point point1 = new Point(2, 1);
        Point point2 = new Point(4, 4);
        Point point3 = new Point(9, 1);
        Triangle triangle3 = new Triangle(point1, point2, point3);

        System.out.println("Perimeter of triangle1 is " + triangle1.calculatePerimeter());
        System.out.println("Area of triangle1 is " + triangle1.calculateArea());

        System.out.println("Perimeter of triangle2 is " + triangle2.calculatePerimeter());
        System.out.println("Area of triangle2 is " + triangle2.calculateArea());

        System.out.println("Perimeter of triangle3 is " + triangle3.calculatePerimeter());
        System.out.println("Area of triangle3 is " + triangle3.calculateArea());

        // Create more objects of Triangle class for testing your code

    }
}
