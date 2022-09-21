package com.ericsHouse.view.panels;

import com.ericsHouse.rooms.Room;
import com.ericsHouse.rooms.RoomMap;
import com.ericsHouse.view.entity.Player;
import com.ericsHouse.view.object.AssetSetter;
import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.object.garage.GarageAssetSetter;
import com.ericsHouse.view.tile.TileManager;
import com.ericsHouse.view.tile.garage.GarageTileManager;
import com.ericsHouse.view.tile.TileManager;
import com.ericsHouse.view.util.CollisionChecker;
import com.ericsHouse.view.util.KeyHandler;
import com.ericsHouse.view.util.Time;
import com.ericsHouse.view.util.UI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable {

    //CurrentGamePanelThread
    public boolean gpRun = true;
    public Room currentRoom;
    //SCREEN SETTINGS
    static final int originalTileSize = 16; // 16 x 16 tile
    static final int scale = 3;
    final int FPS = 60;

    public static final int tileSize = originalTileSize * scale; //48 x 48 tile
    public static final int maxScreenCol = 16;
    public static final int maxScreenRow = 12;
    public static final int screenWidth = tileSize * maxScreenCol; //768 pixels (aesprite = 256)
    public static final int screenHeight = tileSize * maxScreenRow; //576 pixels (aesprite = 192)

    public TileManager tileM = new GarageTileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    public AssetSetter assetSetter = new GarageAssetSetter(this);

    public Player player = new Player(this, keyH);

    public SuperObject[] obj = new SuperObject[10];
    Thread gameThread;
    public RoomMap allRooms = new RoomMap(this);
    public CollisionChecker cChecker = new CollisionChecker(this, tileM, assetSetter, player);

    public UI ui = new UI(this);
    //GAME STATES
    public static int gameState;
    public final int playState = 1;
    public final int pauseState = 2;
    public static final int dialogueState = 3;
    public final int deathState = 4;
    public final int riddleState = 5;
    public final int riddleCorrect = 6;
    public final int riddleIncorrect = 7;
    public final int rockPaperScissors = 8;

    //SUB STATES
    public int subState = 0;
    public final int optionOne = 1;
    public final int optionTwo = 2;
    public final int optionThree = 3;
    public final int correctOption = 4;

    public void setUpGame() {

        //TODO make sure the player is starting in the garage
        currentRoom = allRooms.roomMap.get("kitchen");
        currentRoom.setRoomItems("Eric's Garage");
        gameState = playState;
    }

    public void setCurrentRoom(String roomName) {
        currentRoom = allRooms.roomMap.get(roomName);
    }

    public GamePanel() throws IOException {
        //Sets the size of the JPanel
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        //Double buffered improves game performance
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    //GAME ENGINE DELTA TIME
    //calculates the time difference between the previous frame that was drawn and the current frame
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gpRun) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                try {
                    update();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                repaint();

                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) {
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() throws IOException {
        if (gameState == playState) {
            player.update();
        }
        if (gameState == pauseState) {

        }
        if(!Time.gameTimer.isRunning()){
            gameState = deathState;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        //DRAWING EXIT COLLISIONS
        currentRoom.draw(g2);

        //TILES
        tileM.draw(g2);

        //OBJECTS
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] != null) {
                obj[i].draw(g2, this);
            }
        }
        //PLAYER
        player.draw(g2);
        //UI
        ui.draw(g2);

        g2.dispose();
    }

}
