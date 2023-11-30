package ru.otus.home_work.main;

import ru.otus.home_work.animal.Cat;
import ru.otus.home_work.animal.Dog;
import ru.otus.home_work.animal.Horse;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 40, 1, 50);
        Dog dog = new Dog("Sharik", 40, 2, 80);
        Horse horse = new Horse("Arrow", 80, 3, 140);

        cat.run(50);
        cat.swim(10);
        cat.info();

        dog.run(50);
        dog.swim(10);
        dog.info();

        horse.run(50);
        horse.swim(10);
        horse.info();

    }
}

