package com.ericsHouse.rooms;

import view.GamePanel;
import view.object.AssetSetter;
import view.object.garage.GarageAssetSetter;
import view.object.kitchen.KitchenAssetSetter;
import view.tile.TileManager;
import view.tile.garage.GarageTileManager;
import view.tile.kitchen.KitchenTileManager;

import java.awt.*;
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
        Rectangle kEntranceIntersect = new Rectangle(760, 340, 11, 48*2);
        Rectangle kExitIntersect = new Rectangle(678, 144, 11, 48 *2);
        //Create kitchen object
        AssetSetter kAssets = new KitchenAssetSetter(gp);
        TileManager kTiles = new KitchenTileManager(gp);
        Room kitchen = new Room("kitchen",gp, kAssets,kTiles, "garage", "living-room", kEntranceIntersect,kExitIntersect);

        //Create Garage object
        Rectangle gExitIntersect = new Rectangle(0, 144, 11, 48*2);
        Rectangle gEntranceIntersect = new Rectangle(760, 340, 11, 48*2);
        AssetSetter gAssets = new GarageAssetSetter(gp);
        TileManager gTiles = new GarageTileManager(gp);
        Room garage = new Room("garage",gp,gAssets,gTiles,"kitchen", "kitchen", gEntranceIntersect, gExitIntersect);
        roomMap.put("kitchen", kitchen);
        roomMap.put("garage", garage);
    }
}
