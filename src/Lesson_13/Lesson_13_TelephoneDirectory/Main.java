package Lesson_13.Lesson_13_TelephoneDirectory;

public class Main {
    public static void main(String[] args) {
        TelephoneDirectory td = new TelephoneDirectory();
        td.add("Petrov", "5555555555");
        td.get("Petrov");
        td.add("Petrov", "5555555555");
        td.get("Petrov");
        td.add("Petrov", "5555555556");
        td.get("Petrov");
        td.get("Sidorov");
    }
}
