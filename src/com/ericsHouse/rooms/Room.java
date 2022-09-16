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

   GamePanel gp;
    private AssetSetter assetSetter;
    private TileManager tileManager;
    public String entrance;
    String exit;
    public Rectangle entranceIntersect;
    private Rectangle exitIntersect;

    public Room(GamePanel gp, AssetSetter assetSetter, TileManager tileManager) {
        this.gp = gp;
        this.assetSetter = assetSetter;
        this.tileManager = tileManager;
        entranceIntersect = new Rectangle(0, 144, 11, 48*2);
        exitIntersect = new Rectangle(678, 144, 11, 48 *2);
        entrance = "kitchen";

    }

    public void setRoomItems(String title){
        gp.tileM = tileManager;
        gp.assetSetter = assetSetter;
        gp.assetSetter.setObject();
        window.setTitle(title);
        gp.player.playerY = 360;
        gp.player.playerX = 680;
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

