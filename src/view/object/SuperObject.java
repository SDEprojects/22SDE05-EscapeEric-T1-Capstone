package view.object;

import view.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;

public class SuperObject {


    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int screenX, screenY;
    //You may need to change this for the different objects, this is only one tile worth of area
    public Rectangle solidArea = new Rectangle(0,0,48*2,48*2);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;

    public void draw(Graphics2D g2, GamePanel gp){

        g2.drawImage(image, screenX, screenY, gp.tileSize * 2, gp.tileSize * 2, null);

    }
}
