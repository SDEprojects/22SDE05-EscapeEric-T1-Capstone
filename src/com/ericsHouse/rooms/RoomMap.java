package com.ericsHouse.rooms;

import view.GamePanel;
import view.object.AssetSetter;
import view.object.garage.GarageAssetSetter;
import view.object.kitchen.KitchenAssetSetter;
import view.object.living_room.LivingRoomAssetSetter;
import view.tile.TileManager;
import view.tile.garage.GarageTileManager;
import view.tile.kitchen.KitchenTileManager;
import view.tile.living_room.LivingRoomTileManager;

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
        //KITCHEN TILES AND ASSETS
        Rectangle kEntranceIntersect = new Rectangle(760, 340, 11, 48*2);
        Rectangle kExitIntersect = new Rectangle(678, 144, 11, 48 *2);
        AssetSetter kAssets = new KitchenAssetSetter(gp);
        TileManager kTiles = new KitchenTileManager(gp);
        Room kitchen = new Room("kitchen",gp, kAssets,kTiles, "garage", "living-room", kEntranceIntersect,kExitIntersect);

        //GARAGE TILES AND ASSETS
        Rectangle gExitIntersect = new Rectangle(0, 144, 11, 48*2);
        Rectangle gEntranceIntersect = new Rectangle(760, 340, 11, 48*2);
        AssetSetter gAssets = new GarageAssetSetter(gp);
        TileManager gTiles = new GarageTileManager(gp);
        Room garage = new Room("garage",gp,gAssets,gTiles,"kitchen", "kitchen", gEntranceIntersect, gExitIntersect);

        //LIVING ROOM TILES AND ASSETS
        Rectangle lExitIntersect = new Rectangle(0, 144, 11, 48*2);
        Rectangle lEntranceIntersect = new Rectangle(760, 340, 11, 48*2);
        TileManager lTiles = new LivingRoomTileManager(gp);
        AssetSetter lAssets = new LivingRoomAssetSetter(gp);
        Room livingRoom = new Room("living-room", gp, lAssets,lTiles,"kitchen","bedroom",lEntranceIntersect,lExitIntersect);

        //BEDROOM TILES AND ASSETS



        //Putting Assets in a map for access
        roomMap.put("kitchen", kitchen);
        roomMap.put("garage", garage);
        roomMap.put("living-room",livingRoom);
    }
}
