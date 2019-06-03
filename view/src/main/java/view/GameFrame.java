package view;

import model.IEntity;
import view.IEventPerformer;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * @author Thierry
 * the classe gameframe (the program window)
 */
public class GameFrame extends JFrame implements KeyListener {

   /*the panel*/
    private GamePanel gamePanel;
    /*the event performer*/
    private IEventPerformer eventPerformer;


    /**
     *the constructor for the gameframe
     * @param title the title
     * @param eventPerformer the eventperformer
     * @param width the width
     * @param height the height
     */
    public GameFrame(String title, IEventPerformer eventPerformer, int width, int height) {
/**
 * all the parameters of our frame
 */
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.addKeyListener(this);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.eventPerformer = eventPerformer;
        gamePanel = new GamePanel();
        gamePanel.setDoubleBuffered(true);
        this.setContentPane(gamePanel);
        this.setVisible(true);
    }

    /**
     * @param keyEvent the key used
     */
    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    /**
     * get the key pressed by the user in order
     * @param keyEvent the key pressed
     */
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        this.eventPerformer.eventPerform(keyEvent);
    }

    /**
     * @param keyEvent the key released
     */
    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    /**
     * sets the image of the map
     * @param image the image
     */
    public void setImageMap(BufferedImage image) {
        this.gamePanel.setImageMap(image);
    }

    /**
     * @param entities sets up the entities (by reading the entities arraylist)
     */
    public void setEntities(ArrayList<IEntity> entities) {
        this.gamePanel.setEntities(entities);
    }

    /**
     * @param score the score
     */
    public void setScore(String score) {
        this.gamePanel.setScore(score);
    }
}
