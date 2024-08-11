class Circle implements Calculation {
    String fillColor;
    String borderColor;
    double radius;
    double pi = 3.14;
    public Circle(String fillColor, String borderColor, double radius) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
        this.radius = radius;
    }
    @Override
    public double perimeter() {
        return Math.round(2 * pi * radius * 100.0) / 100.0;
    }
    @Override
    public double area() {
        return Math.round(pi * radius * radius * 100.0) / 100.0;
    }
    @Override
    public void print() {
        System.out.println("Characteristics of a circle: " + perimeter() + ", " + area() + ", " + fillColor + ", " + borderColor);
    }

    public static void main(String[] args) {
        Circle circle = new Circle("red", "blue", 6);
        circle.perimeter();
        circle.area();
        circle.print();
    }
}
