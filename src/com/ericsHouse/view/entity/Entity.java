package com.ericsHouse.view.entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public static int playerX;
    public static int playerY;
    public static int speed;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public static String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;

}
