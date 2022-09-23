package com.ericsHouse.view.util;

import com.ericsHouse.jsonParser.JsonParser;
import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.panels.GamePanel;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Objects;

import static com.ericsHouse.rooms.RoomMap.roomMap;
import static com.ericsHouse.view.panels.GamePanel.currentRoom;
import static com.ericsHouse.view.util.Time.gameTimer;

public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed, getPressed;
    private GamePanel gp;
    //    public static int objIndex;
    public static String objIndex;
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
                String index = gp.cChecker.checkObject(gp.player, true); // Index was an int
                if (!Objects.equals(index, "")) {
                    try {
                        objIndex = index;
                        currentRoom.mapObjects.get(objIndex).interact(index, gp);
                    } catch (JsonProcessingException ex) {
                        throw new RuntimeException(ex);
                    }

                }
            }
            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.pauseState;
            }
        }
        else if(gp.gameState == gp.introState){
            if(code == KeyEvent.VK_E){
                gp.ui.currentDialogue = JsonParser.getPrompt("askShaq", gp);
                gameTimer.start();
                gp.gameState = gp.Shaq;
            }
        }
        else if (gp.gameState == gp.pauseState) {
            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.playState;
            }
        } else if (gp.gameState == gp.dialogueState) {
            if (SuperObject.win && code == KeyEvent.VK_E) {
                gp.gameState = gp.winState;
            } else if (code == KeyEvent.VK_E) {
                gp.gameState = gp.playState;
            }

        } else if (gp.gameState == gp.rockPaperScissors) {
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
            if (code == KeyEvent.VK_E) {
                if (SuperObject.win) {
                    gp.ui.currentDialogue = "You already beat your reflection too many times..  ";
                    gp.gameState = gp.dialogueState;
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
                        gp.gameState = gp.dialogueState;
                    }
                    if (wins >= 2) {
                        SuperObject.win = true;
                        gp.ui.currentDialogue = "You won!!\nThe mirror shows a vision of you standing outside.\nmight be some through the looking glass sort of thing.\nYou walk through to the garden on the other side....";
                        try {
                            roomMap.get("bathroom").mapObjects.get("davidMirror").image = ImageIO.read(Riddle.class.getResourceAsStream("/rooms/bathroom/bathroom_OBJ/david-mirror-won.png"));
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        gp.gameState = gp.dialogueState;

                    } else if (games > 2) {
                        games = 0;
                        wins = 0;
                        gp.ui.currentDialogue = "Sorry you lost, try again";
                        gp.gameState = gp.dialogueState;
                    }
                }
            }

        } else if (gp.gameState == gp.riddleState) {
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
            if (code == KeyEvent.VK_E) {
                Riddle.checkRiddle(gp);

                if (Riddle.riddleCorrect) {
                    gp.gameState = gp.riddleCorrect;
                    currentRoom.mapObjects.get(objIndex).solved = true;
                    Riddle.riddleCorrect = false;
                    gp.ui.currentDialogue = JsonParser.riddleAnswerParser(currentRoom.mapObjects.get(objIndex).name, "correctOut", gp);
                } else {
                    //TODO this needs to be refactored
                    Time.second = Time.second - 60;
                    if (Time.minute <= 0 && Time.second <= 0) {
                        gameTimer.stop();
                    }
                    gp.gameState = gp.riddleIncorrect;
                    gp.ui.currentDialogue = JsonParser.riddleAnswerParser(currentRoom.mapObjects.get(objIndex).name, "falseOut", gp);
                }
            }
        } else if (gp.gameState == gp.riddleCorrect ||gp.gameState == gp.riddleIncorrect || gp.gameState == gp.wordOrder || GamePanel.gameState == gp.Shaq) {
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
