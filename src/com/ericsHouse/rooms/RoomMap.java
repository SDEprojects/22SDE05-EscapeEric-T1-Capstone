package com.ericsHouse.rooms;

import com.ericsHouse.view.object.AssetSetter;
import com.ericsHouse.view.object.bathroom.BathroomAssetSetter;
import com.ericsHouse.view.object.bedroom.BedroomAssetSetter;
import com.ericsHouse.view.object.garage.GarageAssetSetter;
import com.ericsHouse.view.object.kitchen.KitchenAssetSetter;
import com.ericsHouse.view.object.living_room.LivingRoomAssetSetter;
import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.tile.TileManager;
import com.ericsHouse.view.tile.bathroom.BathroomTileManager;
import com.ericsHouse.view.tile.bedroom.BedroomTileManager;
import com.ericsHouse.view.tile.garage.GarageTileManager;
import com.ericsHouse.view.tile.kitchen.KitchenTileManager;
import com.ericsHouse.view.tile.living_room.LivingRoomTileManager;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RoomMap {

    static GamePanel gp;
    public static Map<String, Room> roomMap;

    /**
     * A class to blueprint and hold the instantiated rooms to be accessed by the game
     * @param gp current instance of the game
     * @throws IOException
     */
    public RoomMap(GamePanel gp) throws IOException {
        RoomMap.gp = gp;
        roomMap = new HashMap<>();
        generateRooms();
    }

    /**
     * Function to reset the instance of the maps to initial game load for the game restart
     * @param gp current instance of the game
     * @throws IOException
     */
    public static void resetMap(GamePanel gp) throws IOException {
        RoomMap.gp = gp;
        roomMap.clear();
        generateRooms();
    }

    /**
     * Instantiating the rooms, this is called on game load
     *  upon generation of the rooms, all the assets/objects, tiles and images are created as well
     * @throws IOException thrown during the created of the Kitchen Tile manager,
     *  possible error in reading the JSON files, i.e. non-existent, corrupted
     */
    public static void generateRooms() throws IOException {
        //KITCHEN TILES AND ASSETS
        Rectangle kEntranceIntersect = new Rectangle(760, 340, 11, 48 * 2);
        Rectangle kExitIntersect = new Rectangle(212 * 3, 17, 30 * 3, 16 * 3);
        AssetSetter kAssets = new KitchenAssetSetter(gp);
        TileManager kTiles = new KitchenTileManager(gp);
        Room kitchen = new Room("kitchen", gp, kAssets, kTiles, "garage", "living-room", kEntranceIntersect, kExitIntersect);

        //GARAGE TILES AND ASSETS
        Rectangle gExitIntersect = new Rectangle(0, 144, 11, 48 * 2);
        Rectangle gEntranceIntersect = new Rectangle(760, 340, 11, 48 * 2);
        AssetSetter gAssets = new GarageAssetSetter(gp);
        TileManager gTiles = new GarageTileManager(gp);
        Room garage = new Room("garage", gp, gAssets, gTiles, "kitchen", "kitchen", gEntranceIntersect, gExitIntersect);

        //LIVING ROOM TILES AND ASSETS
        Rectangle lExitIntersect = new Rectangle(251 * 3, 110 * 3, 11, 48);
        Rectangle lEntranceIntersect = new Rectangle(160 * 3, 189 * 3, 32 * 3, 4 * 3);
        TileManager lTiles = new LivingRoomTileManager(gp);
        AssetSetter lAssets = new LivingRoomAssetSetter(gp);
        Room livingRoom = new Room("living-room", gp, lAssets, lTiles, "kitchen", "bedroom", lEntranceIntersect, lExitIntersect);

        //BEDROOM TILES AND ASSETS
        Rectangle bExitIntersect = new Rectangle(218 * 3, 36 * 3, 26 * 3, 14 * 3);
        Rectangle bEntranceIntersect = new Rectangle(0, 166 * 2, 11, 48 * 2);
        TileManager bTiles = new BedroomTileManager(gp);
        AssetSetter bAssets = new BedroomAssetSetter(gp);
        Room bedroom = new Room("bedroom", gp, bAssets, bTiles, "living-room", "bathroom", bEntranceIntersect, bExitIntersect);


        //BATHROOM TILES AND ASSETS
        Rectangle baExitIntersect = new Rectangle(199 * 3, 34 * 3, 30 * 3, 15 * 3);
        Rectangle baEntranceIntersect = new Rectangle(32 * 3, 187 * 3, 33 * 3, 5 * 3);
        TileManager baTiles = new BathroomTileManager(gp);
        AssetSetter baAssets = new BathroomAssetSetter(gp);
        //BATHROOM EXIT NEEDS TO BE AN END GAME EXIT
        Room bathroom = new Room("bathroom", gp, baAssets, baTiles, "bedroom", "win", baEntranceIntersect, baExitIntersect);

        //Putting Assets in a map for access
        roomMap.put("kitchen", kitchen);
        roomMap.put("garage", garage);
        roomMap.put("living-room", livingRoom);
        roomMap.put("bedroom", bedroom);
        roomMap.put("bathroom", bathroom);

        roomMap.get("kitchen").assetSetter.setObject();
        roomMap.get("garage").assetSetter.setObject();
        roomMap.get("living-room").assetSetter.setObject();
        roomMap.get("bedroom").assetSetter.setObject();
        roomMap.get("bathroom").assetSetter.setObject();
    }
}
