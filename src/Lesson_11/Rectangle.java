class Rectangle implements Calculation {
    String fillColor;
    String borderColor;
    double sideA;
    double sideB;
    public Rectangle(String fillColor, String borderColor, double sideA, double sideB) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
        this.sideA = sideA;
        this.sideB = sideB;
    }
    @Override
    public double perimeter() {
        return 2 * (sideA + sideB);
    }
    @Override
    public double area() {
        return sideA * sideB;
    }
    @Override
    public void print() {
        System.out.println("Characteristics of a rectangle: " + perimeter() + ", " + area() + ", " + fillColor + ", " + borderColor);
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle("yellow", "green", 5, 10);
        rectangle.perimeter();
        rectangle.area();
        rectangle.print();
    }
}

