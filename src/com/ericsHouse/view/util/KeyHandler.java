package com.ericsHouse.view.util;

import com.ericsHouse.jsonParser.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.ericsHouse.view.panels.GamePanel;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed, getPressed;
    private GamePanel gp;
    public static int objIndex;

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
                    try {
                        objIndex = index;
                        gp.obj[index].interact(index, gp);
                    } catch (JsonProcessingException ex) {
                        throw new RuntimeException(ex);
                    }

                }
            }
            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.pauseState;
            }
        } else if (gp.gameState == gp.pauseState) {
            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.playState;
            }
        } else if (gp.gameState == gp.dialogueState) {
            if (code == KeyEvent.VK_E) {
                gp.gameState = gp.playState;
            }
        } else if (gp.gameState == gp.riddleState) {
            if (code == KeyEvent.VK_E) {
                Riddle.checkRiddle(gp);
                if (Riddle.riddleCorrect) {
                    gp.gameState = gp.riddleCorrect;
                    gp.obj[objIndex].solved = true;
                    Riddle.riddleCorrect = false;
                    gp.ui.currentDialogue = JsonParser.riddleAnswerParser(gp.obj[objIndex].name, "correctOut", gp);
                } else {
                    //TODO this needs to be refactored
                    Time.second = Time.second - 60;
                    if (Time.minute <= 0 && Time.second <= 0) {
                        Time.gameTimer.stop();
                    }
                    gp.gameState = gp.riddleIncorrect;
                    gp.ui.currentDialogue = JsonParser.riddleAnswerParser(gp.obj[objIndex].name, "falseOut", gp);
                }

            }
        } else if (gp.gameState == gp.riddleCorrect) {
            if (code == KeyEvent.VK_E) {
                gp.gameState = gp.playState;
            }

        } else if (gp.gameState == gp.riddleIncorrect) {
            if (code == KeyEvent.VK_E) {
                gp.gameState = gp.playState;
            }
        }
        if (code == KeyEvent.VK_S) {
            if (gp.subState < gp.optionThree) {
                gp.subState = gp.subState + 1;
            }
        }
        if (code == KeyEvent.VK_W) {
            if (gp.subState > gp.optionOne) {
                gp.subState = gp.subState - 1;
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
