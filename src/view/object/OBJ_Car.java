package view.object;

import view.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_Car extends SuperObject{
    public OBJ_Car(){
        name = "note";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/garage_OBJ/car.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
        solidArea = new Rectangle(0,0,150 * 2,90 * 2);

    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp){

        g2.drawImage(image, screenX, screenY, 150 * 2, 90 * 2, null);

    }
}