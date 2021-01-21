package ru.geekbrains.evstigneeva;

public class Main {
    public static void main(String[] args) {

        Plate plate = new Plate(8);
        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Fedor", 2);
        cats[1] = new Cat("Hodor", 4);
        cats[2] = new Cat("Barsik", 1);
        cats[3] = new Cat("Potter", 5);

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            cats[i].fullnessInfo();
        }


    }

    public void anyString(String anyStr) {
        int lastIndex = anyStr.length() - 1;
        System.out.println(anyStr.charAt(lastIndex));
    }

    public boolean isEndsWithThreeExclamationMark(String strAny) {
        return strAny.endsWith("!!!");
    }

    public boolean isStartsWithILike(String striAny) {
        return striAny.startsWith("I like");
    }

    public boolean isContainsJava(String str) {
        return str.contains("Java");
    }

    public String changeToUper(String str) {
        return str.toUpperCase();
    }

    public String changeToLower(String strI) {
        return strI.toLowerCase();
    }

    public int findJavaPos(String strInt) {
        return strInt.indexOf("Java");
    }

    public String replaceAToO(String strAO) {
        return strAO.replaceAll("a", "o");
    }

    public String cutJava(String strJava) {
        int javaStartPos = findJavaPos(strJava);
        return strJava.substring(javaStartPos, javaStartPos + 3);
    }

}
