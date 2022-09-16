package view;

import view.entity.Player;
import view.object.AssetSetter;
import view.object.SuperObject;
import view.object.garage.GarageAssetSetter;
import view.object.kitchen.KitchenAssetSetter;
import view.tile.garage.GarageTileManager;
import view.tile.TileManager;
import view.tile.kitchen.KitchenTileManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable {

    //CurrentGamePanelThread
    public boolean gpRun = true;
    //SCREEN SETTINGS
    final int originalTileSize = 16; // 16 x 16 tile
    final int scale = 3;
    final int FPS = 60;

    public final int tileSize = originalTileSize * scale; //48 x 48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; //768 pixels
    final int screenHeight = tileSize * maxScreenRow; //576 pixels
    private static boolean isDead = false;

    public TileManager tileM = new GarageTileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    public AssetSetter assetSetter = new GarageAssetSetter(this);
    public Player player = new Player(this, keyH);

    public SuperObject[] obj = new SuperObject[10];
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this,tileM,assetSetter,player);

    public UI ui = new UI(this);

    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;

    public void setUpGame(){
        assetSetter.setObject();
        gameState = playState;
    }

    public GamePanel() throws IOException {
        //Sets the size of the JPanel
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        //Double buffered improves game performance
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    //GAME ENGINE DELTA TIME
    //calculates the time difference between the previous frame that was drawn and the current frame
    public void run(){
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gpRun){
            currentTime = System.nanoTime();

            delta+=(currentTime - lastTime)/drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1){
                try {
                    update();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                repaint();
                delta--;
                drawCount++;
            }
            if(timer >= 1000000000){
                drawCount = 0;
                timer = 0;
            }
        }
        // JPanel for a lose screen
        // Call lose method here?
    }

    public void update() throws IOException {
        if(gameState == playState){
            player.update();
        }
        if(gameState == pauseState){

        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tileM.draw(g2);

        for(int i = 0; i < obj.length; i++){
            if(obj[i] != null){
                obj[i].draw(g2,this);
            }
        }
        player.draw(g2);
        //ui
        ui.draw(g2);
        g2.dispose();
    }

    public static void setDead(boolean dead) {
        isDead = dead;
    }
}
