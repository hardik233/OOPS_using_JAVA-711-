class AreaCalculator {

    double area(double radius) {
        return Math.PI * radius * radius;
    }

    double area(double length, double breadth) {
        return length * breadth;
    }

    double area(double base, double height, boolean isTriangle) {
        return 0.5 * base * height;
    }

    public static void main(String[] args) {
        AreaCalculator obj = new AreaCalculator();

        System.out.println("Area of Circle: " + obj.area(5));
        System.out.println("Area of Rectangle: " + obj.area(4, 6));
        System.out.println("Area of Triangle: " + obj.area(3, 8, true));
    }
}
