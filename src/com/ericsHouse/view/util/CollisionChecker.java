package com.ericsHouse.view.util;

import com.ericsHouse.view.entity.Entity;
import com.ericsHouse.view.entity.Player;
import com.ericsHouse.view.object.AssetSetter;
import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.tile.TileManager;

import java.io.IOException;
import java.util.Map;

import static com.ericsHouse.view.panels.GamePanel.*;

public class CollisionChecker {

    GamePanel gp;
    TileManager tileM;
    AssetSetter assetSetter;
    Player player;

    public CollisionChecker(GamePanel gp, TileManager tileM, AssetSetter assetSetter, Player player) {
        this.gp = gp;
        this.tileM = tileM;
        this.assetSetter = assetSetter;
        this.player = player;
    }

    public void checkTile(Entity entity) throws IOException {
        int entityLeftScreenX = entity.playerX + entity.solidArea.x;
        int entityRightScreenX = entity.playerX + entity.solidArea.x + entity.solidArea.width;
        int entityTopScreenY = entity.playerY + entity.solidArea.y;
        int entityBottomScreenY = entity.playerY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftScreenX / gp.tileSize;
        int entityRightCol = entityRightScreenX / gp.tileSize;
        int entityTopRow = entityTopScreenY / gp.tileSize;
        int entityBottomRow = entityBottomScreenY / gp.tileSize;

        int tileNum1, tileNum2;
        try {
            switch (entity.direction) {
                case "up":
                    //predicting where the player will be while they are moving up
                    entityTopRow = (entityTopScreenY - entity.speed) / gp.tileSize;
                    tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                    tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                    if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                        entity.collisionOn = true;
                    }
                    break;
                case "down":
                    entityBottomRow = (entityBottomScreenY + entity.speed) / gp.tileSize;
                    tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                    tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                    if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                        entity.collisionOn = true;
                    }
                    break;
                case "left":
                    entityLeftCol = (entityLeftScreenX - entity.speed) / gp.tileSize;
                    tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                    tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                    if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                        entity.collisionOn = true;
                    }
                    break;
                case "right":
                    entityRightCol = (entityRightScreenX + entity.speed) / gp.tileSize;
                    tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                    tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                    if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                        entity.collisionOn = true;
                    }
                    break;

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //When the character is out of bounds, then set new window
            //gp.allRooms.roomMap.get("kitchen").setRoomItems("Escape Eric - Garage");
        }

    }

    // Return was int before changes
    public String checkObject(Entity entity, boolean player) {
        String index = "";
        for (Map.Entry<String, SuperObject> entry : currentRoom.mapObjects.entrySet()) {
            entity.solidArea.x = entity.playerX + entity.solidArea.x;
            entity.solidArea.y = entity.playerY + entity.solidArea.y;

            entry.getValue().solidArea.x = entry.getValue().screenX + entry.getValue().solidArea.x;
            entry.getValue().solidArea.y = entry.getValue().screenY + entry.getValue().solidArea.y;

            switch (entity.direction) {
                case "up":
                    entity.solidArea.y -= entity.speed;

                    if (entity.solidArea.intersects(entry.getValue().solidArea)) {
                        if (entry.getValue().collision) {
                            entity.collisionOn = true;
                        }

                        if (player) {
                            //Returns the index of the object (allows for picking up
                            index = entry.getKey();
                        }
                    }
                    break;
                case "down":
                    entity.solidArea.y += entity.speed;

                    if (entity.solidArea.intersects(entry.getValue().solidArea)) {
                        if (entry.getValue().collision) {
                            entity.collisionOn = true;
                        }
                        if (player) {
                            //Returns the index of the object (allows for picking up
                            index = entry.getKey();
                        }
                    }
                    break;
                case "left":
                    entity.solidArea.x -= entity.speed;

                    if (entity.solidArea.intersects(entry.getValue().solidArea)) {
                        if (entry.getValue().collision) {
                            entity.collisionOn = true;
                        }
                        if (player) {
                            //Returns the index of the object (allows for picking up
                            index = entry.getKey();
                        }
                    }
                    break;
                case "right":
                    entity.solidArea.x += entity.speed;
                    //Determine if exit Intersect

                    if (entity.solidArea.intersects(entry.getValue().solidArea)) {
                        if (entry.getValue().collision) {
                            entity.collisionOn = true;
                        }
                        if (player) {
                            //Returns the index of the object (allows for picking up
                            index = entry.getKey();
                        }
                    }
                    break;
            }
//            }
            entity.solidArea.x = entity.solidAreaDefaultX;
            entity.solidArea.y = entity.solidAreaDefaultY;
            try {
                entry.getValue().solidArea.x = entry.getValue().solidAreaDefaultX;
                entry.getValue().solidArea.y = entry.getValue().solidAreaDefaultY;
            } catch (NullPointerException e) {

            }
        }
        return index;
    }

    public void checkExit(Entity entity) {

        entity.solidArea.x = entity.playerX + entity.solidArea.x;
        entity.solidArea.y = entity.playerY + entity.solidArea.y;

        switch (entity.direction) {
            case "up":
                entity.solidArea.x += entity.speed;
              if (entity.solidArea.intersects(currentRoom.entranceIntersect)) {
                    gp.allRooms.roomMap.get(currentRoom.entrance).setRoomItems(currentRoom.entrance);
                    gp.setCurrentRoom(currentRoom.entrance);
                    gp.player.playerY = currentRoom.exitIntersect.y - 75;
                    gp.player.playerX = currentRoom.exitIntersect.x;
                } else if (entity.solidArea.intersects(currentRoom.exitIntersect)) {
                    gp.allRooms.roomMap.get(currentRoom.exit).setRoomItems(currentRoom.exit);
                    gp.setCurrentRoom(currentRoom.exit);
                    gp.player.playerY = currentRoom.entranceIntersect.y - 75;
                    gp.player.playerX = currentRoom.entranceIntersect.x;
                }
                break;
            case "down":
                entity.solidArea.x += entity.speed;
                if (entity.solidArea.intersects(currentRoom.entranceIntersect)) {
                    gp.allRooms.roomMap.get(currentRoom.entrance).setRoomItems(currentRoom.entrance);
                    gp.setCurrentRoom(currentRoom.entrance);
                    gp.player.playerY = currentRoom.exitIntersect.y + 75;
                    gp.player.playerX = currentRoom.exitIntersect.x;
                } else if (entity.solidArea.intersects(currentRoom.exitIntersect)) {
                    gp.allRooms.roomMap.get(currentRoom.exit).setRoomItems(currentRoom.exit);
                    gp.setCurrentRoom(currentRoom.exit);
                    gp.player.playerY = currentRoom.entranceIntersect.y + 75;
                    gp.player.playerX = currentRoom.entranceIntersect.x;
                }
                break;
            case "left":
                entity.solidArea.x += entity.speed;
                if (entity.solidArea.intersects(currentRoom.entranceIntersect)) {
                    gp.allRooms.roomMap.get(currentRoom.entrance).setRoomItems(currentRoom.entrance);
                    gp.setCurrentRoom(currentRoom.entrance);
                    gp.player.playerY = currentRoom.exitIntersect.y;
                    gp.player.playerX = currentRoom.exitIntersect.x - 75;
                } else if (entity.solidArea.intersects(currentRoom.exitIntersect)) {
                    gp.allRooms.roomMap.get(currentRoom.exit).setRoomItems(currentRoom.exit);
                    gp.setCurrentRoom(currentRoom.exit);
                    gp.player.playerY = currentRoom.entranceIntersect.y;
                    gp.player.playerX = currentRoom.entranceIntersect.x - 75;
                }
                break;
            case "right":
                entity.solidArea.x += entity.speed;
                if (entity.solidArea.intersects(currentRoom.entranceIntersect)) {
                    gp.allRooms.roomMap.get(currentRoom.entrance).setRoomItems(currentRoom.entrance);
                    gp.setCurrentRoom(currentRoom.entrance);
                    gp.player.playerY = currentRoom.exitIntersect.y;
                    gp.player.playerX = currentRoom.exitIntersect.x + 75;
                } else if (entity.solidArea.intersects(currentRoom.exitIntersect)) {
                    gp.allRooms.roomMap.get(currentRoom.exit).setRoomItems(currentRoom.exit);
                    gp.setCurrentRoom(currentRoom.exit);
                    gp.player.playerY = currentRoom.entranceIntersect.y;
                    gp.player.playerX = currentRoom.entranceIntersect.x + 75;
                }
                break;
        }
        entity.solidArea.x = entity.solidAreaDefaultX;
        entity.solidArea.y = entity.solidAreaDefaultY;

    }
}
