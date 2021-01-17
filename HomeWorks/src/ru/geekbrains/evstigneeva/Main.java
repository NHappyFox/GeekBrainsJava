package ru.geekbrains.evstigneeva;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal(25, 2);
        new Animal(25, 2);
        new Animal(25, 2);
        new Animal(25, 2);
        Cat cat = new Cat();
        Dog dog = new Dog();
        System.out.println(animal.getTotalCount());
        System.out.println(cat.getTotalCount());
        System.out.println(dog.getTotalCount());


    }
}
