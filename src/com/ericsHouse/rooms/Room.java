package com.ericsHouse.rooms;

import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.object.AssetSetter;
import com.ericsHouse.view.tile.TileManager;

import java.awt.*;

import static com.ericsHouse.view.GameFrame.window;


public class Room {

    public final String name;
    GamePanel gp;
    private AssetSetter assetSetter;
    private TileManager tileManager;
    public String entrance;
    public String exit;
    public Rectangle entranceIntersect;
    public Rectangle exitIntersect;

    public Room(String name, GamePanel gp, AssetSetter assetSetter, TileManager tileManager, String entrance, String exit, Rectangle entranceIntersect, Rectangle exitIntersect) {
        this.name = name;
        this.gp = gp;
        this.assetSetter = assetSetter;
        this.tileManager = tileManager;
        this.entranceIntersect = entranceIntersect;
        this.exitIntersect = exitIntersect;
        this.entrance = entrance;
        this.exit = exit;

    }

    public void setRoomItems(String title) {
        gp.tileM = tileManager;
        gp.assetSetter = assetSetter;
        gp.assetSetter.setObject();
        window.setTitle(title);
    }

    public void draw(Graphics2D g2) {
        try {
            g2.drawRect(entranceIntersect.x, entranceIntersect.y, entranceIntersect.width, entranceIntersect.height);
            g2.drawRect(exitIntersect.x, exitIntersect.y, exitIntersect.width, exitIntersect.height);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}

