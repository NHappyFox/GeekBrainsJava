package ru.geekbrains.evstigneeva;

public class Main {


    public static void main(String[] args) {

        arrayTwoSize(new String[4][4]);


    }

    public static void arrayTwoSize(String[][] arrayTwoD) {

        if (arrayTwoD.length == 4) {
            if (arrayTwoD[0].length == 4) {
                System.out.println("Хорошо");
                return;
            }
        }

        System.out.println("Плохо");


    }

}
