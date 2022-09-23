package com.ericsHouse.view.util;

import com.ericsHouse.jsonParser.JsonParser;
import com.ericsHouse.view.panels.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static com.ericsHouse.view.panels.GamePanel.currentRoom;
import static com.ericsHouse.view.util.KeyHandler.objIndex;


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

    public static Font importFont() {
        InputStream is = UI.class.getResourceAsStream("/font_style/PressStart2P-Regular.ttf");
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            Font sizedFont = font.deriveFont(9f);
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
        if(gp.gameState == gp.introState){
            drawIntroScreen(0, 0, gp.screenWidth, gp.screenHeight);
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
        if (gp.gameState == gp.riddleCorrect) {
            drawDialogueScreen();
        }
        if (gp.gameState == gp.riddleIncorrect) {
            drawDialogueScreen();
        }
        if (gp.gameState == gp.deathState) {
            drawDeathScreen(0, 0, gp.screenWidth, gp.screenHeight);
        }
        if (gp.gameState == gp.rockPaperScissors) {
            rockPaperScissorsDisplay(gp.subState);
        }
        if (gp.gameState == gp.wordOrder) {
            drawWordOrderScreen();
        }
        if(gp.gameState == gp.winState){
            drawWinScreen(0, 0, gp.screenWidth, gp.screenHeight);
        }
        if(gp.gameState == gp.Shaq){
            drawShaq();
        }
    }

    private void drawIntroScreen() {
        int x = gp.tileSize * 2;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 7;
        drawSubWindow(x, y, width, height);
        for (String escape : currentDialogue.split("\n")) {
            g2.drawString(escape, x, y);
            y += 40;
        }
        g2.drawString("Press 'E' To Continue", width - 125, height);
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

        String riddleOne = subState == gp.optionOne ? ">  " + JsonParser.riddleAnswerParser(currentRoom.mapObjects.get(objIndex).name, "one", gp) :
                "  " + JsonParser.riddleAnswerParser(currentRoom.mapObjects.get(objIndex).name, "one", gp);
        String riddleTwo = subState == gp.optionTwo ? ">  " + JsonParser.riddleAnswerParser(currentRoom.mapObjects.get(objIndex).name, "two", gp) :
                "  " + JsonParser.riddleAnswerParser(currentRoom.mapObjects.get(objIndex).name, "two", gp);
        String riddleThree = subState == gp.optionThree ? ">  " + JsonParser.riddleAnswerParser(currentRoom.mapObjects.get(objIndex).name, "three", gp) :
                "  " + JsonParser.riddleAnswerParser(currentRoom.mapObjects.get(objIndex).name, "three", gp);

        g2.drawString(riddleOne, x, y + gp.tileSize);
        g2.drawString(riddleTwo, x, y + gp.tileSize * 2);
        g2.drawString(riddleThree, x, y + gp.tileSize * 3);

        g2.drawString("Press 'E' To Submit Your Answer", width - 250, height);
    }

    private void drawWordOrderScreen() {
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

        g2.drawString("Click the items in your inventory in the right order.", width - 425, height);
    }

    public void rockPaperScissorsDisplay(int subState) {
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

        g2.drawString(subState == gp.optionOne ? ">   Rock" : "   Rock", x, y + gp.tileSize);
        g2.drawString(subState == gp.optionTwo ? ">   Paper" : "   Paper", x, y + gp.tileSize * 2);
        g2.drawString(subState == gp.optionThree ? ">   Scissors" : "   Scissors", x, y + gp.tileSize * 3);
        g2.drawString("Press 'E' To Submit Your Answer", width - 250, height);
    }

    public static boolean checkWin(int selection, int games, int wins) {
        int rps = (int) (Math.random() * 3) + 1;
        System.out.println(rps + " " + selection);
        return rps == selection;
    }

    private void drawSubWindow(int x, int y, int width, int height) {
        Color c = new Color(0, 0, 0, 215);
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

    public void drawWinScreen(int x, int y, int width, int height) {
        try {
            BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/game_over/final-screen.png"));
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

    private void drawShaq() {
        int shaqx = gp.tileSize * 5;
        int shaqy = gp.tileSize - 20;
        int shaqwidth = gp.tileSize * 5;
        int shaqheight = gp.tileSize * 4;
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/rooms/garage/garage_OBJ/ask-shaq.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int x = gp.tileSize * 2 -20;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 11;

        drawSubWindow(x, y, width, height);
        x += gp.tileSize;
        y += gp.tileSize *5;
        for (String escape : currentDialogue.split("\n")) {
            g2.drawString(escape, x, y);
            y += 40;
        }
        g2.drawString("Press 'E' To Continue", width - 125, height);
        g2.drawImage(image,shaqx,shaqy,shaqwidth,shaqheight,null);

    }
}
