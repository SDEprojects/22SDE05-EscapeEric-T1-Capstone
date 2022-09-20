package view;

import com.ericsHouse.jsonParser.JsonParser;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static view.KeyHandler.objIndex;


public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font pixelFont;
    public String currentDialogue = "";

    public UI(GamePanel gp) {
        this.gp = gp;
//        ariel = new Font("Arial", Font.PLAIN, 18);
        pixelFont = importFont();

    }

    public Font importFont() {
        InputStream is = UI.class.getResourceAsStream("/font_style/VT323-Regular.ttf");
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            Font sizedFont = font.deriveFont(22f);
            return sizedFont;
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(pixelFont);
        g2.setColor(Color.white);
        if (gp.gameState == gp.playState) {
            //Do nothing
        }
        if (gp.gameState == gp.pauseState) {
            pauseScreen();
        }
        if (gp.gameState == gp.dialogueState) {
            drawDialogueScreen();
        }
        if (gp.gameState == gp.riddleState) {
            drawRiddleScreen(gp.subState);
        }
        if(gp.gameState == gp.riddleCorrect){
           drawDialogueScreen();
        }
        if(gp.gameState == gp.riddleIncorrect){
            drawDialogueScreen();
        }
        if (gp.gameState == gp.deathState) {
            drawDeathScreen(0, 0, gp.screenWidth, gp.screenHeight);
        }
    }

    private void drawDialogueScreen() {
        int x = gp.tileSize * 2;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 7;
        drawSubWindow(x, y, width, height);
        x += gp.tileSize;
        y += gp.tileSize;
        for (String escape : currentDialogue.split("\n")) {
            g2.drawString(escape, x, y);
            y += 40;
        }

        g2.drawString("Press 'E' To Continue", width - 125, height);
    }
    private void drawRiddleScreen(int subState) {
        int x = gp.tileSize * 2;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 10;
        drawSubWindow(x, y, width, height);
        x += gp.tileSize;
        y += gp.tileSize;
        for (String escape : currentDialogue.split("\n")) {
            g2.drawString(escape, x, y);
            y += 40;
        }
        String riddleOne = subState == gp.optionOne ? ">  " + JsonParser.riddleAnswerParser(gp.obj[objIndex].name, "one", gp) :
                "  " + JsonParser.riddleAnswerParser(gp.obj[objIndex].name, "one", gp);
        String riddleTwo = subState == gp.optionTwo ? ">  " + JsonParser.riddleAnswerParser(gp.obj[objIndex].name, "two", gp) :
                "  " + JsonParser.riddleAnswerParser(gp.obj[objIndex].name, "two", gp);
        String riddleThree = subState == gp.optionThree? ">  " + JsonParser.riddleAnswerParser(gp.obj[objIndex].name, "three", gp) :
                "  " + JsonParser.riddleAnswerParser(gp.obj[objIndex].name, "three", gp);

        g2.drawString(riddleOne, x, y + gp.tileSize);
        g2.drawString(riddleTwo, x, y + gp.tileSize * 2);
        g2.drawString(riddleThree, x, y + gp.tileSize * 3);

        g2.drawString("Press 'E' To Submit Your Answer", width - 250, height);
    }



    private void drawSubWindow(int x, int y, int width, int height) {
        Color c = new Color(0, 0, 0, 200);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 50, 50);
        c = new Color(255, 255, 255);
        g2.setStroke(new BasicStroke(3));
        g2.setColor(c);
        g2.drawRoundRect(x, y, width, height, 50, 50);
    }

    public void pauseScreen() {
        String text = "Pause";
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth / 2 - length / 2;
        int y = gp.screenHeight / 2;
        g2.drawString(text, x, y);
    }

    public void drawDeathScreen(int x, int y, int width, int height) {
        try {
            BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/game_over/Game-Over.png"));
            g2.drawImage(image, x, y, width, height, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawIntroScreen(int x, int y, int width, int height) {
        try {
            BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/game_over/intro-screen.png"));
            g2.drawImage(image, x, y, width, height, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
