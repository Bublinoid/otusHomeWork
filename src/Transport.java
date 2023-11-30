interface Transport {
    String getType();

    boolean move(int distance, TerrainType terrainType);
}
