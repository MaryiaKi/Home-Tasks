package Lesson_14;

public class Factorial {
    static String NegativeNumberErrorMessage = "Entered number cannot be negative";
    public static String calculateFactorial(int n) {
        int curr_fact = 1;
        if (n < 0) {
            return NegativeNumberErrorMessage;
        } else if (n == 0) {
            return String.valueOf(curr_fact);
        } else {
            for (int i = 1; i <= n; i++) {
                curr_fact = curr_fact * i;
            }
            return String.valueOf(curr_fact);
        }
    }
}
