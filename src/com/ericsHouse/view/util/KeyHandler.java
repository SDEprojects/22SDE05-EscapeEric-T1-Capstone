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
import static com.ericsHouse.view.panels.GamePanel.*;
import static com.ericsHouse.view.util.Time.gameTimer;
import static com.ericsHouse.view.util.UI.playAgain;

public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed, getPressed;
    private final GamePanel gp;
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
        if (gameState == playState) {

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
                } catch (Exception ignored) {
                }
            }
            if (code == KeyEvent.VK_N) {
                getPressed = true;
                try {
                    Music.stop();
                } catch (Exception ignored) {
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
                gameState = gp.pauseState;
            }
            if (code == KeyEvent.VK_J) {
                gameState = deathState;
            }
        } else if (gameState == introState) {
            if (code == KeyEvent.VK_E) {
                UI.currentDialogue = JsonParser.getPrompt("askShaq");
                gameTimer.start();
                gameState = gp.Shaq;
            }
        } else if (gameState == gp.pauseState) {
            if (code == KeyEvent.VK_P) {
                gameState = playState;
            }
        } else if (gameState == dialogueState) {
            if (SuperObject.win && code == KeyEvent.VK_E) {
                gameState = winState;
            } else if (code == KeyEvent.VK_E) {
                gameState = playState;
            }

        } else if (gameState == gp.rockPaperScissors) {
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
                    UI.currentDialogue = "You already beat your reflection too many times..  ";
                    gameState = dialogueState;
                } else {
                    if (wins <= 2) {
                        if (UI.checkWin(this.gp.subState)) {
                            wins++;
                        }
                        UI.currentDialogue = "number of wins: " + wins;
                        games++;
                    } else {
                        UI.currentDialogue = "You Lost, final score :" + (games - wins) + wins;
                        gameState = dialogueState;
                    }
                    if (wins >= 2) {
                        SuperObject.win = true;
                        UI.currentDialogue = "You won!!\nThe mirror shows a vision of you standing outside.\nmight be some through the looking glass sort of thing.\nYou walk through to the garden on the other side....";
                        try {
                            roomMap.get("bathroom").mapObjects.get("davidMirror").image = ImageIO.read(Riddle.class.getResourceAsStream("/rooms/bathroom/bathroom_OBJ/david-mirror-won.png"));
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        gameState = dialogueState;

                    } else if (games > 2) {
                        games = 0;
                        wins = 0;
                        UI.currentDialogue = "Sorry you lost, try again";
                        gameState = dialogueState;
                    }
                }
            }

        } else if (gameState == deathState) {
            if (code == KeyEvent.VK_E) {
                try {
                    playAgain(this.gp.subState);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if (code == KeyEvent.VK_S) {
                if (gp.subState < gp.optionTwo) {
                    gp.subState = gp.subState + 1;
                }
            }
            if (code == KeyEvent.VK_W) {
                if (gp.subState > gp.optionOne) {
                    gp.subState = gp.subState - 1;
                }
            }
        } else if (gameState == gp.riddleState) {
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
                    gameState = gp.riddleCorrect;
                    currentRoom.mapObjects.get(objIndex).solved = true;
                    Riddle.riddleCorrect = false;
                    UI.currentDialogue = JsonParser.riddleAnswerParser(currentRoom.mapObjects.get(objIndex).name, "correctOut", gp);
                } else {
                    //TODO this needs to be refactored
                    if (Time.minute > 0) {
                        Time.minute--;
                        gameState = gp.riddleIncorrect;
                        UI.currentDialogue = JsonParser.riddleAnswerParser(currentRoom.mapObjects.get(objIndex).name, "falseOut", gp);
                    } else {
                        gameState = deathState;
                        gameTimer.stop();
                    }
                }
            }
        } else if (gameState == craftState || gameState == gp.riddleCorrect || gameState == gp.riddleIncorrect || gameState == wordOrder || GamePanel.gameState == gp.Shaq) {
            if (code == KeyEvent.VK_E) {
                if (gameState == craftState) {
                    Crafter.clickedItems.clear();
                }
                if (gameState == wordOrder) {
                    WordOrder.clickedObJ.clear();
                }
                gameState = playState;
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
