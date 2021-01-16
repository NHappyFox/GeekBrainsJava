package ru.geekbrains.evstigneeva;

public class Main {

    public static void main(String[] args) {

        Employee[] workerArray = new Employee[5];

        workerArray[0] = new Employee("Космодемьянская Зоя Анатольевна", "мед.сетра", "obl.otdel6@mail.ru", "89946845421", 25600, 22);
        workerArray[1] = new Employee("Васильев Андрей Александрович", "мед.брат", "obl.otdel4@mail.ru", "89956824421", 25500, 30);
        workerArray[2] = new Employee("Прохоров Константин Валентинович", "психиатр", "obl.otdel7@mail.ru", "89955475421", 35500, 45);
        workerArray[3] = new Employee("Приленский Сергей Николаевич", "санитар", "obl.otdel20@mail.ru", "89956854821", 20500, 20);
        workerArray[4] = new Employee("Мария Склодовская-Кюри", "глав.врач", "obl.otdel@mail.ru", "89956843641", 40500, 50);

        for (int i = 0; i < workerArray.length; i = i + 1) {
            if (workerArray[i].age > 40) {
                workerArray[i].printInfo();
            }
        }
    }
}
