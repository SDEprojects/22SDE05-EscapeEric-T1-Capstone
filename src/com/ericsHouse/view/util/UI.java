package com.ericsHouse.view.util;

import com.ericsHouse.jsonParser.JsonParser;
import com.ericsHouse.view.entity.Player;
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
    public static String currentDialogue = "";

    /**
     * UI for this GP.
     */
    public UI(GamePanel gp) {
        this.gp = gp;
        pixelFont = importFont();
    }

    public static Font importFont() {
        InputStream is = UI.class.getResourceAsStream("/font_style/PressStart2P-Regular.ttf");
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            return font.deriveFont(9f);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param g2 Used to display the color for the dialogue boxes.
     *           Whenever the game state changes then it calls a function within.
     */
    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(pixelFont);
        g2.setColor(Color.white);
        if (GamePanel.gameState == GamePanel.playState) {
            //Do nothing
        }
        if (GamePanel.gameState == GamePanel.introState) {
            drawIntroScreen(0, 0, GamePanel.screenWidth, GamePanel.screenHeight);
        }
        if (GamePanel.gameState == gp.pauseState) {
            pauseScreen();
        }
        if (GamePanel.gameState == GamePanel.dialogueState) {
            drawDialogueScreen();
        }
        if (GamePanel.gameState == gp.riddleState) {
            drawRiddleScreen(gp.subState);
        }
        if (GamePanel.gameState == gp.riddleCorrect) {
            drawDialogueScreen();
        }
        if (GamePanel.gameState == gp.riddleIncorrect) {
            drawDialogueScreen();
        }
        if (GamePanel.gameState == GamePanel.deathState) {
            drawDeathScreen(0, 0, GamePanel.screenWidth, GamePanel.screenHeight, gp.subState);
        }
        if (GamePanel.gameState == gp.rockPaperScissors) {
            rockPaperScissorsDisplay(gp.subState);
        }
        if (GamePanel.gameState == GamePanel.wordOrder) {
            drawWordOrderScreen();
        }
        if (GamePanel.gameState == GamePanel.winState) {
            drawWinScreen(0, 0, GamePanel.screenWidth, GamePanel.screenHeight);
        }
        if (GamePanel.gameState == gp.Shaq) {
            drawShaq();
        }
        if (GamePanel.gameState == GamePanel.craftState) {
            drawDialogueScreen();
        }
    }


    /**
     * Creates the dialogue screen when you interact with an object.
     */
    private void drawDialogueScreen() {
        int x = GamePanel.tileSize * 2;
        int y = GamePanel.tileSize / 2;
        int width = GamePanel.screenWidth - (GamePanel.tileSize * 4);
        int height = GamePanel.tileSize * 7;
        drawSubWindow(x, y, width, height);
        x += GamePanel.tileSize;
        y += GamePanel.tileSize;
        for (String escape : currentDialogue.split("\n")) {
            g2.drawString(escape, x, y);
            y += 40;
        }
        if (GamePanel.gameState == GamePanel.craftState) {
            g2.drawString("Press 'E' When you are done", width - 160, height);
        } else {
            g2.drawString("Press 'E' To Continue", width - 125, height);
        }
    }

    /**
     * @param subState Depending on the sub-state you are
     *                 able to pick what answer you want to use.
     *                 using a ternary you can have a highlighted
     *                 > mark.
     */
    private void drawRiddleScreen(int subState) {
        int x = GamePanel.tileSize * 2;
        int y = GamePanel.tileSize / 2;
        int width = GamePanel.screenWidth - (GamePanel.tileSize * 4);
        int height = GamePanel.tileSize * 10;
        drawSubWindow(x, y, width, height);
        x += GamePanel.tileSize;
        y += GamePanel.tileSize;
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

        g2.drawString(riddleOne, x, y + GamePanel.tileSize);
        g2.drawString(riddleTwo, x, y + GamePanel.tileSize * 2);
        g2.drawString(riddleThree, x, y + GamePanel.tileSize * 3);

        g2.drawString("Press 'E' To Submit Your Answer", width - 250, height);
    }

    /**
     * You draw the dialogue for the word order riddle.
     */
    private void drawWordOrderScreen() {
        int x = GamePanel.tileSize * 2;
        int y = GamePanel.tileSize / 2;
        int width = GamePanel.screenWidth - (GamePanel.tileSize * 4);
        int height = GamePanel.tileSize * 7;
        drawSubWindow(x, y, width, height);
        x += GamePanel.tileSize;
        y += GamePanel.tileSize;
        for (String escape : currentDialogue.split("\n")) {
            g2.drawString(escape, x, y);
            y += 40;
        }

        g2.drawString("Click the items in your inventory in the right order.", width - 425, height);
    }

    /**
     * @param subState uses the sub-state to pick the
     *                 users rock paper scissors, pick
     *                 uses a ternary in order to highlight.
     */
    public void rockPaperScissorsDisplay(int subState) {
        int x = GamePanel.tileSize * 2;
        int y = GamePanel.tileSize / 2;
        int width = GamePanel.screenWidth - (GamePanel.tileSize * 4);
        int height = GamePanel.tileSize * 10;
        drawSubWindow(x, y, width, height);
        x += GamePanel.tileSize;
        y += GamePanel.tileSize;
        for (String escape : currentDialogue.split("\n")) {
            g2.drawString(escape, x, y);
            y += 40;
        }
        g2.drawString(subState == gp.optionOne ? ">   Rock" : "   Rock", x, y + GamePanel.tileSize);
        g2.drawString(subState == gp.optionTwo ? ">   Paper" : "   Paper", x, y + GamePanel.tileSize * 2);
        g2.drawString(subState == gp.optionThree ? ">   Scissors" : "   Scissors", x, y + GamePanel.tileSize * 3);
        g2.drawString("Press 'E' To Submit Your Answer", width - 250, height);
    }

    /**
     * @param selection takes in the selection.
     * @return returns a true false if you won.
     */
    public static boolean checkWin(int selection) {
        if (Player.hatEquipped) {
            return true;
        } else {
            int rps = (int) (Math.random() * 3) + 1;
            return rps == selection;
        }
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
        int x = GamePanel.screenWidth / 2 - length / 2;
        int y = GamePanel.screenHeight / 2;
        g2.drawString(text, x, y);
    }

    public void drawDeathScreen(int x, int y, int width, int height, int subState) {
        currentDialogue = "Play again?";
        try {
            BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/game_over/Game-Over.png"));
            g2.drawImage(image, x, y, width, height, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        x += GamePanel.tileSize;
        y += GamePanel.tileSize * 7;
        for (String escape : currentDialogue.split("\n")) {
            g2.drawString(escape, x, y);
            y += 20;
        }
        g2.drawString(subState == gp.optionOne ? ">   Restart" : "   Restart", x, y + GamePanel.tileSize);
        g2.drawString(subState == gp.optionTwo ? ">   End Game" : "   End Game", x, y + GamePanel.tileSize * 2);
        g2.drawString("Press 'E' To Submit Your Answer", x, height - 50);
    }

    public static void playAgain(int subState) throws IOException {
        if (subState == 1) {
            GameFrame.reset();
            GamePanel.gameState = 1;
        } else if (subState == 2) {
            System.exit(0);
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
        int shaqx = GamePanel.tileSize * 5;
        int shaqy = GamePanel.tileSize - 20;
        int shaqwidth = GamePanel.tileSize * 5;
        int shaqheight = GamePanel.tileSize * 4;
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/rooms/garage/garage_OBJ/ask-shaq.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int x = GamePanel.tileSize * 2 - 20;
        int y = GamePanel.tileSize / 2;
        int width = GamePanel.screenWidth - (GamePanel.tileSize * 4);
        int height = GamePanel.tileSize * 11;

        drawSubWindow(x, y, width, height);
        x += GamePanel.tileSize;
        y += GamePanel.tileSize * 5;
        for (String escape : currentDialogue.split("\n")) {
            g2.drawString(escape, x, y);
            y += 40;
        }
        g2.drawString("Press 'E' To Continue", width - 125, height);
        g2.drawImage(image, shaqx, shaqy, shaqwidth, shaqheight, null);
    }
}
