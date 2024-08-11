//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        checkSumInRange(15, 10 );
        checkRealNumber(-10);
        checkNumberSign(-5);
        printString("Hello friend", 3);
        checkLeapYear(2024);
        replaceArrayElement();
        fillArray();
        changeArray();
        createTwoDimensionalArray();
        createArray(7, 15);
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = -100;
        int b = 50;
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        }
        else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 100;
        if (value <= 0) {
            System.out.println("Красный");
        }
        else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        }
        else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 50;
        int b = 50;
        if (a >= b) {
            System.out.println("a >= b");
        }
        else {
            System.out.println("a < b");
        }
    }

    public static boolean checkSumInRange(int a, int b) {
        if (a + b  > 10 && a + b <= 20) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void checkRealNumber(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        }
        else {
            System.out.println("Число отрицательное");
        }
    }

    public static boolean checkNumberSign(int a) {
        if (a < 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void printString(String s1, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(s1);
        }

    }

    public static boolean checkLeapYear(int year) {
        if (year % 4 == 0) {
            if ((year % 100 != 0) || (year % 400 == 0)) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    public static void replaceArrayElement() {
        int [] nums = { 1,0,0,1,0,1,0,1 };
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)  {
                nums[i] = 1;
            }
            else {
                nums[i] = 0;
            }
        }
    }

    public static void fillArray() {
        int [] nums = new int[100];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
    }

    public static void changeArray() {
        int [] nums = { 1,5,3,2,11,4,5,2,4,8,9,1 };
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 6)  {
                nums[i] = nums[i] * 2;
            }
        }
    }

    public static void createTwoDimensionalArray() {
        int counter = 1;
        int [] [] table = new int[5][5] ;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == j) {
                    table[i][j] = counter;
                }
            }
        }
    }

    public static void createArray(int len, int initialValue) {
        int [] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = initialValue;
        }
    }
}
