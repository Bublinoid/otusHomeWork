
public class Main {
    public static void main(String[] args) {

        Plate plate = new Plate(100, 40);
        Cat[] cats = {
                new Cat("Barsik", 10),
                new Cat("Murzik", 15),
                new Cat("Smooky", 20),
        };

        for (Cat cat : cats) {
            cat.eat(plate);
            cat.info();
        }

        plate.info();
        plate.addFood(85);
        plate.info();
    }
}

