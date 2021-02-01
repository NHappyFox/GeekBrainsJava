package ru.geekbrains.evstigneeva;

public class Main {


    public static final int ALLOWED_ARRAY_SIZE = 4;

    public static void main(String[] args) {

        try {
            String[][] arrayTwoD = new String[3][4];
            arrayTwoD[0][0] = "6";
            arrayTwoD[0][1] = "54";
            arrayTwoD[0][2] = "8";
            arrayTwoD[0][3] = "9";
            arrayTwoD[1][0] = "11";
            arrayTwoD[1][1] = "52";
            arrayTwoD[1][2] = "154";
            arrayTwoD[1][3] = "25";
            arrayTwoD[2][0] = "1";
            arrayTwoD[2][1] = "44";
            arrayTwoD[2][2] = "51";
            arrayTwoD[2][3] = "69";
            arrayTwoD[3][0] = "h";
            arrayTwoD[3][1] = "58";
            arrayTwoD[3][2] = "14";
            arrayTwoD[3][3] = "67";


            int sum = getSum(arrayTwoD);
            System.out.println("Sum: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Exception");
            System.out.println(e);
        }


    }

    public static int getSum(String[][] strArr) throws MyArrayDataException, MyArraySizeException {
        if (strArr.length != ALLOWED_ARRAY_SIZE) {
            throw new MyArraySizeException();
        }
        if (strArr[0].length != ALLOWED_ARRAY_SIZE) {
            throw new MyArraySizeException();
        }
        int sum = 0;

        for (int i = 0; i < strArr.length; i++) {

            for (int j = 0; j < strArr.length; j++) {

                try {
                    int anInt = Integer.parseInt(strArr[i][j]);
                    sum = sum + anInt;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка по адресу [" + i + "][" + j + "]. Этот симбвол не является числом");
                }
            }
        }
        return sum;
    }

}
