package view.object;

import view.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_Door extends SuperObject{
    public OBJ_Door(){
        name = "door";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/garage_OBJ/garage-door-closed.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
        solidArea = new Rectangle(0,0,16,48*2);
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp){

        g2.drawImage(image, screenX, screenY, gp.tileSize * 2, gp.tileSize * 2 + 5, null);

    }
}
