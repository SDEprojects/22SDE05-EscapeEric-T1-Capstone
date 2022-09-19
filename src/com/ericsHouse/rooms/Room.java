package com.ericsHouse.rooms;

import com.ericsHouse.EricHouseClient;
import com.ericsHouse.characters.David;
import com.ericsHouse.jsonParser.ActionsPrompt;
import com.ericsHouse.jsonParser.RoomZeroParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import view.GamePanel;
import view.object.AssetSetter;
import view.object.kitchen.KitchenAssetSetter;
import view.tile.Tile;
import view.tile.TileManager;
import view.tile.kitchen.KitchenTileManager;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static view.BuildWindow.window;


public class Room{

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

    public void setRoomItems(String title){
        gp.tileM = tileManager;
        gp.assetSetter = assetSetter;
        gp.assetSetter.setObject();
        window.setTitle(title);
    }

    public void draw(Graphics2D g2){
        try{
            g2.drawRect(entranceIntersect.x,entranceIntersect.y,entranceIntersect.width,entranceIntersect.height);
            g2.drawRect(exitIntersect.x, exitIntersect.y, exitIntersect.width, exitIntersect.height);
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

}

