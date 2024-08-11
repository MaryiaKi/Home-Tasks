public class Main1 {
    public static void main(String[] args) {
        SumOfArray sumOfArray = new SumOfArray();
        String [][] myArr = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "i", "16"}
        };
        String [][] myArr1 = {
                {"1", "2", "3"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        String [][] myArr2 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        try{
            sumOfArray.sumOfArray(myArr);
        } catch (MyArraySizeException e) {
            System.out.println(e.message);
        } catch (MyArrayDataException e) {
            System.out.println(e.message);
            System.out.println(e.errorValueFirstLevel);
            System.out.println(e.errorValueSecondLevel);
        };
        try{
            sumOfArray.sumOfArray(myArr1);
        } catch (MyArraySizeException e) {
            System.out.println(e.message);
        } catch (MyArrayDataException e) {
            System.out.println(e.message);
            System.out.println(e.errorValueFirstLevel);
            System.out.println(e.errorValueSecondLevel);
        }
        try{
            sumOfArray.sumOfArray(myArr2);
        } catch (MyArraySizeException e) {
            System.out.println(e.message);
        } catch (MyArrayDataException e) {
            System.out.println(e.message);
            System.out.println(e.errorValueFirstLevel);
            System.out.println(e.errorValueSecondLevel);
        }
    }
}
