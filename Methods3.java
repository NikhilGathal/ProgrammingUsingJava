class Rectangle {
    public float length;
    public float width;

    Rectangle(float length, float width) {
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        double area = (double) (length * width);
        double roundOff = Math.round(area * 100.0) / 100.0;
        return roundOff;
    }

    public double calculatePerimeter() {
        double perimeter = (double) 2 * (length + width);
        double roundOff = Math.round(perimeter * 100.0) / 100.0;
        return roundOff;
    }
}

class Tester {

    public static void main(String args[]) {

        Rectangle rectangle = new Rectangle(12f, 5f);

        rectangle.length = 12f;
        rectangle.width = 5f;

        System.out.println("Area of the rectangle is " + rectangle.calculateArea());
        System.out.println("Perimeter of the rectangle is " + rectangle.calculatePerimeter());
    }

}