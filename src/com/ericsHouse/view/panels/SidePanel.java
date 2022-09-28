package com.ericsHouse.view.panels;

import com.ericsHouse.jsonParser.JsonParser;
import com.ericsHouse.view.entity.Player;
import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.object.living_room.OBJ_Dog;
import com.ericsHouse.view.util.Crafter;
import com.ericsHouse.view.util.Time;
import com.ericsHouse.view.util.UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.ericsHouse.view.panels.GamePanel.gameState;

public class SidePanel extends JPanel {

    private final JFrame jframe;
    public JPanel inventory = new JPanel();
    public JPanel timePanel = new JPanel();
    public JPanel assistButtons = new JPanel();
    public Box box = Box.createHorizontalBox();
    public JButton askShaqButton;
    public JButton helpButton;
    public static Map<String, JButton> items = new HashMap<>();
    final int screenWidth = 216;
    final int screenHeight = GamePanel.screenHeight;
    GridBagConstraints c = new GridBagConstraints();
    GridBagConstraints d = new GridBagConstraints();
    GamePanel gp;

    private Image image;
    JLabel timerLabel = new JLabel("HELLOOOOOO");

    public JLabel time() {
        return this.timerLabel;
    }

    /**
     * Primary constructor for the Side Panel that takes in the parameters listed below
     *
     * @param jframe Current part of the frame that helps with focus and event listening on certain components
     * @param image  background image for the side panel
     * @param gp     current state of the Game Panel
     * @throws IOException
     */
    public SidePanel(JFrame jframe, Image image, GamePanel gp) throws IOException {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setLayout(new BorderLayout());
        this.jframe = jframe;
        this.image = image;
        this.setOpaque(false);
        this.gp = gp;
        timePanel.setOpaque(false);
        assistButtons.setOpaque(false);
        timePanel.setLayout(new BorderLayout());
        timePanel.setBorder(new EmptyBorder(0, 0, 100, 0));
        assistButtons.setLayout(new BorderLayout(15, 15));
        assistButtons.setBackground(Color.BLUE);
    }

    /**
     * This method is used to set up a new JLabel that holds the game timers text
     * Calls Time.setUpTimer to start the timer and have it update persistently
     */
    public void timerSetUp() {
        timerLabel.setFont(UI.importFont());
        timerLabel.setText("08:00");

        Time.setUpTimer(2, 0, timerLabel);

        box.add(Box.createHorizontalGlue());
        box.add(timerLabel);
        box.add(Box.createHorizontalGlue());
        timePanel.setPreferredSize(new Dimension(216, 175));
        timePanel.add(box, BorderLayout.CENTER);
        this.add(timePanel, BorderLayout.PAGE_START);
    }

    /**
     * This method sets up the inventory panel/component that is in the Side Panel
     *
     * @param gp Current Game Panel state, with its appropriate fields are used
     */
    public void inventorySetUp(GamePanel gp) {
//        Player.addItem(new OBJ_Bedroom("side-table-girl", "/rooms/bedroom/bedroom_OBJ/side-table-girl.png", 14, 21));
        for (SuperObject item : gp.player.getBackpack()) {
            ImageIcon image = new ImageIcon(item.image);
            items.put(item.name, new JButton());
            items.get(item.name).setIcon(image);
            items.get(item.name).setPreferredSize(new Dimension(16 * 4, 16 * 4));
        }
        inventory.setOpaque(false);
        inventory.revalidate();
        inventory.repaint();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.ipady = 454;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        this.add(inventory, BorderLayout.CENTER, 1);
    }

    /**
     * This method sets up the individual items that are in the inventory by making sure the
     * item image is rendered inside the inventory
     *
     * @param sp SuperObject, specifically the object that is placed in the inventory
     */
    public void inventorySetUp(SuperObject sp) {
        ImageIcon image = new ImageIcon(sp.image);
        Image newImg = image.getImage();
        Image img = newImg.getScaledInstance(48, 48, Image.SCALE_SMOOTH);
        ImageIcon imgI = new ImageIcon(img);
        JButton button = new JButton(imgI);

        button.setPreferredSize(new Dimension(16 * 4, 16 * 4));
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setName(sp.name);
        button.setContentAreaFilled(false);
        button.addActionListener(e -> {
            if (button.getName() == "aluminum hat") {
                gp.player.newHat();
                gp.player.hatEquipped = true;
            }
            if (Crafter.hammerClicked && button.getName().equals("aluminum")) {
                inventory.remove(button);
            }
            if (gameState == GamePanel.wordOrder) {
                OBJ_Dog.wo.addClickedObject(button.getName());
            }
            if (gameState == GamePanel.craftState) {
                Crafter.addClickedItems(button.getName());
            }
            if (gameState == gp.playState) {
                try {
                    gp.ui.currentDialogue = JsonParser.itemDescriptions(sp.name);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                gameState = GamePanel.dialogueState;
            }
        });

        inventory.revalidate();
        inventory.repaint();
        inventory.add(button);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.ipady = 454;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        this.add(inventory, BorderLayout.CENTER, 1);
    }

    /**
     * This method is used to reset the state of all the items in the inventory
     * Primarily for the restart of the game in the same instance
     */
    public void resetItems() {
        Player.removeAllItems(Player.backpack);
        inventory.removeAll();
        inventory.repaint();
    }

    /**
     * This method is used to set up the 2 buttons, askShaq and help
     * Specifically their sizes, event listeners and images
     */
    public void buttonSetUp() {
        assistButtons.setPreferredSize(new Dimension(screenWidth, 156));
        assistButtons.setBackground(Color.CYAN);

        askShaqButton = new JButton("Ask Shaq");
        askShaqButton.setFont(UI.importFont());
        askShaqButton.setPreferredSize(new Dimension(15, 50));
        askShaqButton.setContentAreaFilled(false);
        askShaqButton.setBorder(BorderFactory.createEmptyBorder());
        assistButtons.add(askShaqButton, BorderLayout.PAGE_START);
        askShaqButton.addActionListener((ActionListener) jframe);

        helpButton = new JButton("Help");
        helpButton.setFont(UI.importFont());
        assistButtons.add(helpButton, BorderLayout.CENTER);
        helpButton.setContentAreaFilled(false);
        helpButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 35, 0));
        helpButton.addActionListener((ActionListener) jframe);
        this.add(assistButtons, BorderLayout.PAGE_END);

    }

    /**
     * Override of the default Jframe method to suit our usage
     *
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(this.image, 0, 0, null); // image full size
        //g.drawImage(background, 0, 0, getWidth(), getHeight(), null); // image scaled
    }

    /**
     * Override of default getPreferredSize() to the applications preferred size
     *
     * @return the overwritten preferred size
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(this.image.getWidth(this), this.image.getHeight(this));
    }
}
