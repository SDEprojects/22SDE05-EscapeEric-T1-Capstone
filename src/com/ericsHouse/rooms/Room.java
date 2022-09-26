package com.ericsHouse.rooms;

import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.object.AssetSetter;
import com.ericsHouse.view.tile.TileManager;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.ericsHouse.view.util.GameFrame.window;


public class Room {

    public final String name;
    GamePanel gp;
    AssetSetter assetSetter;
    public Map<String, SuperObject> mapObjects;
    private final TileManager tileManager;
    public String entrance;
    public String exit;
    public Rectangle entranceIntersect;
    public Rectangle exitIntersect;

    /**
     * Room constructor that takes in parameters listed below.
     * The Room class is used for all the different rooms to be entered in the application
     * @param name name of the room, i.e. Living Room, Dining Room, etc
     * @param gp current state of the game
     * @param assetSetter specific to each room, a setter for the objects and other assets
     * @param tileManager specific to each room, a setter for the tiles and background of the room
     * @param entrance specific to each room, the room that they have just came from
     * @param exit specific to each room, the entrance to the "next" room
     * @param entranceIntersect determined rectangle where if player collides with said rectangle, an action happens
     * @param exitIntersect determined rectangle where if player collides with said rectangle, an action happens
     */
    public Room(String name, GamePanel gp, AssetSetter assetSetter, TileManager tileManager, String entrance, String exit, Rectangle entranceIntersect, Rectangle exitIntersect) {
        this.name = name;
        this.gp = gp;
        this.assetSetter = assetSetter;
        this.tileManager = tileManager;
        this.entranceIntersect = entranceIntersect;
        this.exitIntersect = exitIntersect;
        this.entrance = entrance;
        this.exit = exit;
        this.mapObjects = new LinkedHashMap<>();
    }

    /**
     * Sets up the rooms/current room with the associated tile manager and asset setter, (background and objects)
     * @param title changes the window title to the specific room
     */
    public void setRoomItems(String title) {
        gp.tileM = tileManager;
        gp.assetSetter = assetSetter;
//        gp.assetSetter.setObject();
        window.setTitle(title);
    }

    /**
     * Draws the rectangle of the associated entrance and exit for the character to interact with when overlapped
     * @param g2 the graphics of the object to protect
     */
    public void draw(Graphics2D g2) {
        try {
            g2.drawRect(entranceIntersect.x, entranceIntersect.y, entranceIntersect.width, entranceIntersect.height);
            g2.drawRect(exitIntersect.x, exitIntersect.y, exitIntersect.width, exitIntersect.height);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}

