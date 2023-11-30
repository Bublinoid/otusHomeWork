public class Bicycle implements Transport {
    private int riderEnergy;

    public Bicycle(int initialRiderEnergy) {
        this.riderEnergy = initialRiderEnergy;
    }

    @Override
    public String getType() {
        return "велосипед";
    }

    @Override
    public boolean move(int distance, TerrainType terrainType) {
        if (terrainType == TerrainType.SWAMP) {
            System.out.println("Велосипед не может переместиться по болоту");
            return false;
        }

        if (riderEnergy >= distance) {
            riderEnergy -= distance;
            return true;
        } else {
            System.out.println("Недостаточно сил для перемещения на " + distance + " км");
            return false;
        }
    }
}
