abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();

}

class Triangle extends Shape {

    double sideA;
    double sideB;
    double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    double getArea() {
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

}

class Rectangle extends Shape {

    double length;
    double height;

    public Rectangle(double length, double height) {
        this.length = length;
        this.height = height;
    }

    @Override
    double getPerimeter() {
        return 2 * length + 2 * height;
    }

    @Override
    double getArea() {
        return length * height;
    }

}

class Circle extends Shape {

    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getPerimeter() {
        return Math.PI * 2 * radius;
    }

    @Override
    double getArea() {
        return Math.PI * Math.pow(radius, 2.0);
    }

}