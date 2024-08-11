public class SumOfArray {
    public void sumOfArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sumOfArrayEl = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr.length != 4 || arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
                sumOfArrayEl += Integer.parseInt(arr[i][j]);
            }
        }
        System.out.println(sumOfArrayEl);
    }
}
