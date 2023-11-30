enum TerrainType {
    DENSE_FOREST,
    PLAIN,
    SWAMP
}

public class Human {
    String name;
    Transport currentTransport;

    public Human(String name) {
        this.name = name;
    }

    public void sitOnTransport(Transport transport) {
        if (currentTransport == null) {
            currentTransport = transport;
            System.out.println(name + " сел на " + transport.getType());
        } else {
            System.out.println(name + " уже находится на транспорте");
        }
    }

    public void getOffTransport() {
        if (currentTransport != null) {
            System.out.println(name + " слез с " + currentTransport.getType());
            currentTransport = null;
        } else {
            System.out.println(name + " не находится на транспорте");
        }
    }

    public void move(int distance, TerrainType terrainType) {
        if (currentTransport != null) {
            boolean success = currentTransport.move(distance, terrainType);
            if (success) {
                System.out.println(name + " переместился на " + distance + " км на " + currentTransport.getType());
            } else {
                System.out.println(name + " не удалось переместиться на " + distance + " км на " +
                        currentTransport.getType() + " из-за ограничений местности");
            }
        } else {
            System.out.println(name + " идет пешком на " + distance + " км");
        }
    }
}
