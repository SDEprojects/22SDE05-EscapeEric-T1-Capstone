package com.ericsHouse.view.entity;

import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.util.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Player extends Entity {

    public static ArrayList<SuperObject> backpack = new ArrayList<>();
    private static boolean hatEquipped = false;
    private static boolean glassesEquipped = false;
    GamePanel gp;
    KeyHandler keyH;
    int pressCounter = 0;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        playerX = 300;
        playerY = 300;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/character_images/david/boy_up_1.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/character_images/david/boy_up_2.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/character_images/david/boy_down_1.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/character_images/david/boy_down_2.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/character_images/david/boy_left_1.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/character_images/david/boy_left_2.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/character_images/david/boy_right_1.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/character_images/david/boy_right_2.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() throws IOException {
        if (keyH.leftPressed || keyH.downPressed || keyH.upPressed || keyH.rightPressed) {
            if (keyH.upPressed) {
                direction = "up";

            } else if (keyH.downPressed) {
                direction = "down";

            } else if (keyH.rightPressed) {
                direction = "right";

            } else if (keyH.leftPressed) {
                direction = "left";

            }
            collisionOn = false;
            //CHECK TILE COLLISION
            gp.cChecker.checkTile(this);
            String objIndex = gp.cChecker.checkObject(this, true);
            gp.cChecker.checkExit(this);

            //IF COLLISION IS FALSE, PLAYER CAN MOVE
            if (!collisionOn) {
                switch (direction) {
                    case "up":
                        playerY -= speed;
                        break;
                    case "down":
                        playerY += speed;
                        break;
                    case "left":
                        playerX -= speed;
                        break;
                    case "right":
                        playerX += speed;
                        break;
                }
            }

            //Every 12 frames the sprite changes
            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, playerX, playerY, gp.tileSize, gp.tileSize, null);
    }

    public static void addItem(SuperObject item) {
        backpack.add(item);
    }

    public void removeItem(SuperObject item) {
        backpack.remove(item);
    }

    public static void equipHat() {
        hatEquipped = true;
    }

    public static void equipGlasses() {
        glassesEquipped = true;
    }

    public ArrayList<SuperObject> getBackpack() {
        return backpack;
    }

    public static boolean isHatEquipped() {
        return hatEquipped;
    }

    public static boolean isGlassesEquipped() {
        return glassesEquipped;
    }
}
