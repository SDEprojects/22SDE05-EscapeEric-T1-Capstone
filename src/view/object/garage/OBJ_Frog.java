package view.object.garage;

import view.GamePanel;
import view.object.SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_Frog extends SuperObject {

    public OBJ_Frog(){
        name = "frog";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/garage_OBJ/frog.png"));
        }catch (IOException e){
            e.printStackTrace();
        }


    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp){

        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

    }
}
