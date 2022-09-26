package com.ericsHouse.view.util;

import com.ericsHouse.jsonParser.JsonParser;
import com.ericsHouse.rooms.RoomMap;
import com.ericsHouse.view.entity.Entity;
import com.ericsHouse.view.entity.Player;
import com.ericsHouse.view.object.AssetSetter;
import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.tile.TileManager;

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

    public void checkTile(Entity entity) {
        int entityLeftScreenX = Entity.playerX + entity.solidArea.x;
        int entityRightScreenX = Entity.playerX + entity.solidArea.x + entity.solidArea.width;
        int entityTopScreenY = Entity.playerY + entity.solidArea.y;
        int entityBottomScreenY = Entity.playerY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftScreenX / tileSize;
        int entityRightCol = entityRightScreenX / tileSize;
        int entityTopRow = entityTopScreenY / tileSize;
        int entityBottomRow = entityBottomScreenY / tileSize;

        int tileNum1, tileNum2;
        try {
            switch (Entity.direction) {
                case "up":
                    //predicting where the player will be while they are moving up
                    entityTopRow = (entityTopScreenY - Entity.speed) / tileSize;
                    tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                    tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                    if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                        entity.collisionOn = true;
                    }
                    break;
                case "down":
                    entityBottomRow = (entityBottomScreenY + Entity.speed) / tileSize;
                    tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                    tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                    if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                        entity.collisionOn = true;
                    }
                    break;
                case "left":
                    entityLeftCol = (entityLeftScreenX - Entity.speed) / tileSize;
                    tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                    tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                    if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                        entity.collisionOn = true;
                    }
                    break;
                case "right":
                    entityRightCol = (entityRightScreenX + Entity.speed) / tileSize;
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
            entity.solidArea.x = Entity.playerX + entity.solidArea.x;
            entity.solidArea.y = Entity.playerY + entity.solidArea.y;

            entry.getValue().solidArea.x = entry.getValue().screenX + entry.getValue().solidArea.x;
            entry.getValue().solidArea.y = entry.getValue().screenY + entry.getValue().solidArea.y;

            switch (Entity.direction) {
                case "up":
                    entity.solidArea.y -= Entity.speed;

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
                    entity.solidArea.y += Entity.speed;

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
                    entity.solidArea.x -= Entity.speed;

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
                    entity.solidArea.x += Entity.speed;
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
            } catch (NullPointerException ignored) {

            }
        }
        return index;
    }

    public void checkExit(Entity entity) {
        entity.solidArea.x = Entity.playerX + entity.solidArea.x;
        entity.solidArea.y = Entity.playerY + entity.solidArea.y;

        switch (Entity.direction) {
            case "up":
                entity.solidArea.x += Entity.speed;
                if (entity.solidArea.intersects(currentRoom.entranceIntersect)) {
                    RoomMap.roomMap.get(currentRoom.entrance).setRoomItems(currentRoom.entrance);
                    gp.setCurrentRoom(currentRoom.entrance);
                    Entity.playerY = currentRoom.exitIntersect.y - 75;
                    Entity.playerX = currentRoom.exitIntersect.x;
                } else if (entity.solidArea.intersects(currentRoom.exitIntersect)) {
                    RoomMap.roomMap.get(currentRoom.exit).setRoomItems(currentRoom.exit);
                    gp.setCurrentRoom(currentRoom.exit);
                    Entity.playerY = currentRoom.entranceIntersect.y - 75;
                    Entity.playerX = currentRoom.entranceIntersect.x;
                    UI.currentDialogue = JsonParser.roomIntro(currentRoom.name);
                    gameState = dialogueState;
                }
                break;
            case "down":
                entity.solidArea.x += Entity.speed;
                if (entity.solidArea.intersects(currentRoom.entranceIntersect)) {
                    RoomMap.roomMap.get(currentRoom.entrance).setRoomItems(currentRoom.entrance);
                    gp.setCurrentRoom(currentRoom.entrance);
                    Entity.playerY = currentRoom.exitIntersect.y + 75;
                    Entity.playerX = currentRoom.exitIntersect.x;
                } else if (entity.solidArea.intersects(currentRoom.exitIntersect)) {
                    RoomMap.roomMap.get(currentRoom.exit).setRoomItems(currentRoom.exit);
                    gp.setCurrentRoom(currentRoom.exit);
                    Entity.playerY = currentRoom.entranceIntersect.y + 75;
                    Entity.playerX = currentRoom.entranceIntersect.x;
                    UI.currentDialogue = JsonParser.roomIntro(currentRoom.name);
                    gameState = dialogueState;
                }
                break;
            case "left":
                entity.solidArea.x += Entity.speed;
                if (entity.solidArea.intersects(currentRoom.entranceIntersect)) {
                    RoomMap.roomMap.get(currentRoom.entrance).setRoomItems(currentRoom.entrance);
                    gp.setCurrentRoom(currentRoom.entrance);
                    Entity.playerY = currentRoom.exitIntersect.y;
                    Entity.playerX = currentRoom.exitIntersect.x - 75;
                } else if (entity.solidArea.intersects(currentRoom.exitIntersect)) {
                    RoomMap.roomMap.get(currentRoom.exit).setRoomItems(currentRoom.exit);
                    gp.setCurrentRoom(currentRoom.exit);
                    Entity.playerY = currentRoom.entranceIntersect.y;
                    Entity.playerX = currentRoom.entranceIntersect.x - 75;
                    UI.currentDialogue = JsonParser.roomIntro(currentRoom.name);
                    gameState = dialogueState;
                }
                break;
            case "right":
                entity.solidArea.x += Entity.speed;
                if (entity.solidArea.intersects(currentRoom.entranceIntersect)) {
                    RoomMap.roomMap.get(currentRoom.entrance).setRoomItems(currentRoom.entrance);
                    gp.setCurrentRoom(currentRoom.entrance);
                    Entity.playerY = currentRoom.exitIntersect.y;
                    Entity.playerX = currentRoom.exitIntersect.x + 75;
                } else if (entity.solidArea.intersects(currentRoom.exitIntersect)) {
                    RoomMap.roomMap.get(currentRoom.exit).setRoomItems(currentRoom.exit);
                    gp.setCurrentRoom(currentRoom.exit);
                    Entity.playerY = currentRoom.entranceIntersect.y;
                    Entity.playerX = currentRoom.entranceIntersect.x + 75;
                    UI.currentDialogue = JsonParser.roomIntro(currentRoom.name);
                    gameState = dialogueState;
                }
                break;
        }
        entity.solidArea.x = entity.solidAreaDefaultX;
        entity.solidArea.y = entity.solidAreaDefaultY;

    }
}
