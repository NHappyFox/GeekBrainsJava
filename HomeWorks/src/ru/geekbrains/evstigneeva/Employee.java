package ru.geekbrains.evstigneeva;

public class Employee {

    String name_fio;
    String position;
    String email;
    String phone;
    int salary;
    int age;

    public Employee(String name_fio, String position, String email, String phone, int salary, int age) {
        this.name_fio = name_fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

//    public Employee() {
//        this("Приленский Сергей Николаевич", "мед.брат", "obl.otdel7@mail.ru", "89956845421", 25500, 38);
//    }

    public void printInfo() {
        System.out.println(name_fio + " " + salary + " " + position + " " + age);
    }

}
