package view;

import com.ericsHouse.rooms.Room;
import view.entity.Entity;
import view.entity.Player;
import view.object.AssetSetter;
import view.object.kitchen.KitchenAssetSetter;
import view.tile.TileManager;
import view.tile.kitchen.KitchenTileManager;

import java.awt.*;
import java.io.IOException;

import static view.BuildWindow.window;

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

    public int checkObject(Entity entity, boolean player) {
        int index = 999;
        for (int i = 0; i < gp.obj.length; i++) {
            if (gp.obj[i] != null) {
                entity.solidArea.x = entity.playerX + entity.solidArea.x;
                entity.solidArea.y = entity.playerY + entity.solidArea.y;

                gp.obj[i].solidArea.x = gp.obj[i].screenX + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].screenY + gp.obj[i].solidArea.y;

                switch (entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;

                        if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if (gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }

                            if (player == true) {
                                //Returns the index of the object (allows for picking up
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;

                        if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if (gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                //Returns the index of the object (allows for picking up
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;

                        if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if (gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                //Returns the index of the object (allows for picking up
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        //Determine if exit Intersect

                        if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if (gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                //Returns the index of the object (allows for picking up
                                index = i;
                            }
                        }
                        break;
                }
            }
            entity.solidArea.x = entity.solidAreaDefaultX;
            entity.solidArea.y = entity.solidAreaDefaultY;
            try {
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
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
            case "down":
            case "left":
                entity.solidArea.x -= entity.speed;
                if (entity.solidArea.intersects(gp.currentRoom.entranceIntersect)) {
                    gp.allRooms.roomMap.get(gp.currentRoom.entrance).setRoomItems(gp.currentRoom.entrance);
                    gp.setCurrentRoom(gp.currentRoom.entrance);
                    gp.player.playerY = 350;
                    gp.player.playerX = 350;

                }else if(entity.solidArea.intersects(gp.currentRoom.exitIntersect)){
                    gp.allRooms.roomMap.get(gp.currentRoom.exit).setRoomItems(gp.currentRoom.exit);
                    gp.setCurrentRoom(gp.currentRoom.exit);
                    gp.player.playerY = 350;
                    gp.player.playerX = 350;
                }
                break;
            case "right":
                entity.solidArea.x += entity.speed;
                if (entity.solidArea.intersects(gp.currentRoom.entranceIntersect)) {
                    gp.allRooms.roomMap.get(gp.currentRoom.entrance).setRoomItems(gp.currentRoom.entrance);
                    gp.setCurrentRoom(gp.currentRoom.entrance);
                    gp.player.playerY = 350;
                    gp.player.playerX = 350;
                }else if(entity.solidArea.intersects(gp.currentRoom.exitIntersect)){
                    gp.allRooms.roomMap.get(gp.currentRoom.exit).setRoomItems(gp.currentRoom.exit);
                    gp.setCurrentRoom(gp.currentRoom.exit);
                    gp.player.playerY = 350;
                    gp.player.playerX = 350;
                }
                break;
        }
        entity.solidArea.x = entity.solidAreaDefaultX;
        entity.solidArea.y = entity.solidAreaDefaultY;

    }
}
