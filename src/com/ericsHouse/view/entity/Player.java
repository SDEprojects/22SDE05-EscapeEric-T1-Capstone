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
    public static boolean hatEquipped = false;
    GamePanel gp;
    KeyHandler keyH;

    /**
     * Constructor for the Player character that the user will play as
     * @param gp current instance of the game panel
     * @param keyH key handler for the character's/users input
     */
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

    /**
     * Method for setting the Player's default position, speed and downward facing pixel graphic
     * Also used as a part of the game restart mechanism
     */
    public static void setDefaultValues() {
        playerX = 300;
        playerY = 300;
        speed = 4;
        direction = "down";
    }

    /**
     * Method to grab the 2d pixel rendition of the Player pending on movement and directional positioning
     */
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

    /**
     * Method in grabbing 2d pixel rendition of Player when the aluminium hat is equipped
     */
    public void newHat(){
        try {
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/character_images/david/mh_up_1.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/character_images/david/mh_up_2.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/character_images/david/mh_down_1.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/character_images/david/mh_down_2.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/character_images/david/mh_left_1.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/character_images/david/mh_left_2.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/character_images/david/mh_right_1.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/character_images/david/mh_right_2.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method continually checks on the input of the user in terms of movement or colliding with
     *  other objects
     * @throws IOException
     */
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

    /**
     * This method draws the Player onto the GUI, and pending on the direction, getting the appropriate sprite
     * @param g2 the graphics of the player to protect
     */
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

    /**
     * Getter for the ArrayList backpack
     * @return the arrayList backpack/inventory
     */
    public ArrayList<SuperObject> getBackpack() {
        return backpack;
    }

    /**
     * Adds an item to the ArrayList backpack
     * @param item gettable object to be added to backpack/inventory
     */
    public static void addItem(SuperObject item) {
        backpack.add(item);
    }

    /**
     * Removes an item from the ArrayList backpack
     * @param item object inside backpack/inventory to be removed
     */
    public static void removeItem(SuperObject item) {
        backpack.remove(item);
    }

    /**
     * Method apart of the restart game mechanic where it resets the backpack to default, empty
     * @param item the ArrayList backpack
     */
    public static void removeAllItems(ArrayList<SuperObject> item) {
        item.clear();
    }
}
