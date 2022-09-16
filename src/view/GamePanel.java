package view;

import com.ericsHouse.rooms.Room;
import com.ericsHouse.rooms.RoomMap;
import view.entity.Player;
import view.object.AssetSetter;
import view.object.SuperObject;
import view.object.garage.GarageAssetSetter;
import view.tile.garage.GarageTileManager;
import view.tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable{
    //CurrentGamePanelThread
    public boolean gpRun = true;
    public Room currentRoom;
    //SCREEN SETTINGS
    final int originalTileSize = 16; // 16 x 16 tile
    final int scale = 3;
    final int FPS = 60;

    public final int tileSize = originalTileSize * scale; //48 x 48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; //768 pixels
    final int screenHeight = tileSize * maxScreenRow; //576 pixels

    public TileManager tileM = new GarageTileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    public AssetSetter assetSetter = new GarageAssetSetter(this);
    public Player player = new Player(this, keyH);

    public SuperObject[] obj = new SuperObject[10];
    Thread gameThread;
    public RoomMap allRooms = new RoomMap(this);
    public CollisionChecker cChecker = new CollisionChecker(this,tileM,assetSetter,player);

    public void setUpGame() throws IOException {
       currentRoom = allRooms.roomMap.get("garage");
       currentRoom.setRoomItems("Eric's Garage");
    }

    public void setCurrentRoom(String roomName){
        currentRoom = allRooms.roomMap.get(roomName);
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
    }

    public void update() throws IOException {
        player.update();
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
        currentRoom.draw(g2);
        player.draw(g2);

        g2.dispose();
    }

}
