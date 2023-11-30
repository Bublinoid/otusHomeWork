public class Horse implements Transport {
    private int energy;

    public Horse(int initialEnergy) {
        this.energy = initialEnergy;
    }

    @Override
    public String getType() {
        return "лошадь";
    }

    @Override
    public boolean move(int distance, TerrainType terrainType) {
        if (terrainType == TerrainType.SWAMP) {
            System.out.println("Лошадь не может переместиться по болоту");
            return false;
        }

        if (energy >= distance) {
            energy -= distance;
            return true;
        } else {
            System.out.println("Недостаточно сил для перемещения на " + distance + " км");
            return false;
        }
    }
}
