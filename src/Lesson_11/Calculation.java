public interface Calculation {
        default double perimeter() {
            return 0;
        }
        double area();
        void print();
    }


