package view;

import java.awt.*;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font ariel;

    public UI(GamePanel gp){
        this.gp = gp;
        ariel = new Font("Ariel", Font.PLAIN, 40);
    }
    public void draw (Graphics2D g2){
        this.g2 = g2;
    g2.setFont(ariel);
    g2.setColor(Color.white);
    if(gp.gameState == gp.playState){

    }
    if(gp.gameState == gp.pauseState){
        pauseScreen();
    }
    }
    public void pauseScreen(){
        String text = "Pause";
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gp.screenWidth/2-length/2;
        int y = gp.screenHeight/2;
        g2.drawString(text, x, y);
    }

}
