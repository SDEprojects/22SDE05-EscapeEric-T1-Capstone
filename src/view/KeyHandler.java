package view;

import com.ericsHouse.jsonParser.RoomZeroParser;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed, getPressed;
    private GamePanel gp;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (gp.gameState == gp.playState) {


            if (code == KeyEvent.VK_W || code == 38) {
                upPressed = true;
            }
            if (code == KeyEvent.VK_S || code == 40) {
                downPressed = true;
            }
            if (code == KeyEvent.VK_D || code == 39) {
                rightPressed = true;
            }
            if (code == KeyEvent.VK_A || code == 37) {
                leftPressed = true;
            }
            if (code == KeyEvent.VK_M) {
                getPressed = true;
                try {
                    Music.play();
                } catch (Exception ex) {
                }
            }
            if (code == KeyEvent.VK_N) {
                getPressed = true;
                try {
                    Music.stop();
                } catch (Exception ex) {
                }
            }
            if (code == KeyEvent.VK_E) {
                getPressed = true;
                int index = gp.cChecker.checkObject(gp.player, true);
                if (index != 999) {
                    gp.ui.currentDialogue = RoomZeroParser.getPrompt(gp.obj[index].name);
                    gp.gameState = gp.dialogueState;
                    gp.obj[index].interact(index, gp);
                }
            }
            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.pauseState;
            }
            //TODO - remove comment before release, used to test death screen
            if(code == KeyEvent.VK_J){
                gp.gameState = gp.deathState;
            }
        } else if (gp.gameState == gp.pauseState) {
            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.playState;
            }
        } else if (gp.gameState == gp.dialogueState) {
            if (code == KeyEvent.VK_E) {
                gp.gameState = gp.playState;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W || code == 38) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S || code == 40) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_D || code == 39) {
            rightPressed = false;
        }
        if (code == KeyEvent.VK_A || code == 37) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_E) {
            getPressed = false;
        }
    }
}
