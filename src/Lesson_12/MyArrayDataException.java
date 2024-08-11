public class MyArrayDataException extends Exception{
    int errorValueFirstLevel;
    int errorValueSecondLevel;
    String message = "Incorrect data type";
    public MyArrayDataException(int errorValueFirstLevel, int errorValueSecondLevel) {
        this.errorValueFirstLevel = errorValueFirstLevel;
        this.errorValueSecondLevel = errorValueSecondLevel;
    }
}
