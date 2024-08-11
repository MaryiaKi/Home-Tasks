class Triangle implements Calculation {
    String fillColor;
    String borderColor;
    double sideA;
    double sideB;
    double sideC;
    double height;
    public Triangle(String fillColor, String borderColor, double sideA, double sideB, double sideC, double height) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
        this.sideA = sideA;
        this.sideB = sideB;
    }
    @Override
    public double perimeter() {
        return 2 * (sideA + sideB + sideC);
    }
    @Override
    public double area() {
        return sideA * sideB/2;
    }
    @Override
    public void print() {
        System.out.println("Characteristics of a triangle: " + perimeter() + ", " + area() + ", " + fillColor + ", " + borderColor);
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle("white", "black", 10, 5, 15, 4);
        triangle.perimeter();
        triangle.area();
        triangle.print();
    }
}

