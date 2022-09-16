package view;

import java.awt.*;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font ariel;
    public String currentDialogue = "";

    public UI(GamePanel gp) {
        this.gp = gp;
        ariel = new Font("Ariel", Font.PLAIN, 20);

    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(ariel);
        g2.setColor(Color.white);
        if (gp.gameState == gp.playState) {

        }
        if (gp.gameState == gp.pauseState) {
            pauseScreen();
        }
        if (gp.gameState == gp.dialogueState) {
            drawDialogueScreen();
        }
    }

    private void drawDialogueScreen() {
        int x = gp.tileSize * 2;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 5;
        drawSubWindow(x, y, width, height);
        x += gp.tileSize;
        y += gp.tileSize;
        g2.drawString(currentDialogue, x, y);
    }

    public void drawSubWindow(int x, int y, int width, int height) {
        Color c = new Color(0, 0, 0,100);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 30, 30);
        c = new Color(255,255,255);
        g2.setStroke(new BasicStroke(5));
        g2.setColor(c);
    }

    public void pauseScreen() {
        String text = "Pause";
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth / 2 - length / 2;
        int y = gp.screenHeight / 2;
        g2.drawString(text, x, y);
    }

}
