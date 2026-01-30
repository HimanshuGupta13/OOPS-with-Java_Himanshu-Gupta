class AreaCalculator {
    public double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    public double calculateArea(double length, double width) {
        return length * width;
    }

    public int calculateArea(int side) {
        return side * side;
    }
}
public class Experiment2 {
    public static void main(String[] args) {
        AreaCalculator calculator = new AreaCalculator();
        double circleArea = calculator.calculateArea(5.0);
        System.out.println("Area of Circle: " + circleArea);

        double rectangleArea = calculator.calculateArea(4.0, 6.0);
        System.out.println("Area of Rectangle: " + rectangleArea);

        int squareArea = calculator.calculateArea(7);
        System.out.println("Area of Square: " + squareArea);
    }
}
