package ru.geekbrains.evstigneeva;

public class Main {
    public static void main(String[] args) {


        Animal animal = new Animal(25, 2, 3);
        new Animal(25, 2, 5);
        new Animal(25, 2, 4);
        new Animal(25, 2, 1);


        Cat cat = new Cat();
        cat.run(150);
        Dog dog = new Dog();
        dog.jump(0.2f);
        dog.run(100);

        System.out.println(animal.getTotalCount());
        System.out.println(cat.getTotalCount());
        System.out.println(dog.getTotalCount());

    }
}
