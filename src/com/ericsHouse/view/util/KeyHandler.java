package com.ericsHouse.view.util;

import com.ericsHouse.jsonParser.JsonParser;
import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.panels.GamePanel;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed, getPressed;
    private final GamePanel gp;
    public static int objIndex;
    int games = 0;
    int wins = 0;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (GamePanel.gameState == gp.playState) {

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
                        System.out.println(objIndex);
                        gp.obj[index].interact(index, gp);
                    } catch (JsonProcessingException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
            if (code == KeyEvent.VK_P) {
                GamePanel.gameState = gp.pauseState;
            }
        } else if (GamePanel.gameState == gp.pauseState) {
            if (code == KeyEvent.VK_P) {
                GamePanel.gameState = gp.playState;
            }
        } else if (GamePanel.gameState == GamePanel.dialogueState) {
            if (code == KeyEvent.VK_E) {
                GamePanel.gameState = gp.playState;
            }
        } else if (GamePanel.gameState == gp.rockPaperScissors) {
            if (code == KeyEvent.VK_E) {
                if (SuperObject.win) {
                    gp.ui.currentDialogue = "You already beat your reflection too many times..  ";
                    GamePanel.gameState = GamePanel.dialogueState;
                } else {
                    if (wins <= 2) {
                        if (UI.checkWin(this.gp.subState, games, wins)) {
                            wins++;
                            gp.ui.currentDialogue = "number of wins: " + wins;
                        } else {
                            gp.ui.currentDialogue = "number of wins: " + wins;
                        }
                        games++;
                    } else {
                        gp.ui.currentDialogue = "You Lost, final score :" + (games - wins) + wins;
                        GamePanel.gameState = GamePanel.dialogueState;
                    }
                    if (wins >= 2) {
                        SuperObject.win = true;
                        gp.ui.currentDialogue = "You Won, you finally beat the person\nwho spends all your money!";
                        GamePanel.gameState = GamePanel.dialogueState;
                    } else if (games > 2) {
                        games = 0;
                        wins = 0;
                        gp.ui.currentDialogue = "Sorry you lost, try again";
                        GamePanel.gameState = GamePanel.dialogueState;
                    }
                }
            }
        } else if (GamePanel.gameState == gp.riddleState) {
            if (code == KeyEvent.VK_E) {
                Riddle.checkRiddle(gp);
                if (Riddle.riddleCorrect) {
                    GamePanel.gameState = gp.riddleCorrect;
                    gp.obj[objIndex].solved = true;
                    Riddle.riddleCorrect = false;
                    gp.ui.currentDialogue = JsonParser.riddleAnswerParser(gp.obj[objIndex].name, "correctOut", gp);
                } else {
                    //TODO this needs to be refactored
                    Time.second = Time.second - 60;
                    if (Time.minute <= 0 && Time.second <= 0) {
                        Time.gameTimer.stop();
                    }
                    GamePanel.gameState = gp.riddleIncorrect;
                    gp.ui.currentDialogue = JsonParser.riddleAnswerParser(gp.obj[objIndex].name, "falseOut", gp);
                }
            }
        } else if (GamePanel.gameState == gp.riddleCorrect) {
            if (code == KeyEvent.VK_E) {
                GamePanel.gameState = gp.playState;
            }

        } else if (GamePanel.gameState == gp.riddleIncorrect) {
            if (code == KeyEvent.VK_E) {
                GamePanel.gameState = gp.playState;
            }
        } else if (GamePanel.gameState == GamePanel.wordOrder) {
            if (code == KeyEvent.VK_E) {
                GamePanel.gameState = gp.playState;
            }
        }else if (GamePanel.gameState == gp.Shaq) {
            if (code == KeyEvent.VK_E) {
                GamePanel.gameState = gp.playState;
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
