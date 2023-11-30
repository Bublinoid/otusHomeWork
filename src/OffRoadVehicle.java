public class OffRoadVehicle implements Transport {
    @Override
    public String getType() {
        return "вездеход";
    }

    @Override
    public boolean move(int distance, TerrainType terrainType) {
        // Вездеход может перемещаться по любому типу местности
        return true;
    }
}
