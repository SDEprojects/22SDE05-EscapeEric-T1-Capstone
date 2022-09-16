package com.ericsHouse.rooms;

import view.GamePanel;
import view.object.AssetSetter;
import view.object.garage.GarageAssetSetter;
import view.object.kitchen.KitchenAssetSetter;
import view.tile.TileManager;
import view.tile.garage.GarageTileManager;
import view.tile.kitchen.KitchenTileManager;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RoomMap {

    GamePanel gp;
    public Map<String, Room> roomMap = new HashMap<>();

    public RoomMap(GamePanel gp) throws IOException {
        this.gp = gp;

        generateRooms();
    }

    public void generateRooms() throws IOException {
        //Create kitchen
        AssetSetter kAssets = new KitchenAssetSetter(gp);
        TileManager kTiles = new KitchenTileManager(gp);
        Room kitchen = new Room(gp, kAssets,kTiles);

        AssetSetter gAssets = new GarageAssetSetter(gp);
        TileManager gTiles = new GarageTileManager(gp);
        Room garage = new Room(gp,gAssets,gTiles);
        roomMap.put("kitchen", kitchen);
        roomMap.put("garage", garage);
    }
}
