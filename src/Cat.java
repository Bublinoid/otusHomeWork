
public class Cat {

     String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat(Plate plate) {
        if (plate.reduceFood(appetite, name)) {
            satiety = true;
            System.out.println(name + " наелся и сыт");

        } else {
            System.out.println(name + " не наелся, недостаточно еды в тарелке");
        }
    }
    public void info() {
        System.out.println(name + ": Твой аппетит = " + appetite + ", твоя сытость = " + satiety);
    }
}
