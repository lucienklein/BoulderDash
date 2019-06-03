package view;

import controller.IOrderPerformer;

import model.IEntity;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * @author Thierry
 * the class view
 */
public class View implements IView {

    /*the event performer*/
    private EventPerformer eventPerformer;

   /*the gameframe*/
    GameFrame gameframe;

    /**
     * the view constructor
     * @param orderPerformer the orderperformer
     */
    public View(IOrderPerformer orderPerformer) {
        super();
        this.eventPerformer = new EventPerformer(orderPerformer);
    }

    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    /**
     * Draw the map from its image
     * @param image the image (got by the reading of the arraylist)
     */
    @Override
    public void drawMap(BufferedImage image) {
        gameframe.setImageMap(image);
    }

    /**
     * it draws the entities on the map
     * @param entities the entities
     */
    @Override
    public void drawEntities(ArrayList<IEntity> entities) {
        gameframe.setEntities(entities);
    }

    /**
     * Create the window
     * @param width the width of thge window
     * @param height the height of the window
     */
    @Override
    public void createWindow(int width, int height) {
        gameframe = new GameFrame("BoulderDash", eventPerformer, width, height);
    }

    /*window closing method*/
    @Override
    public void closeWindow() {
        gameframe.dispose();
    }
/*method to display the score*/
    @Override
    public void drawScore(String score) {
        gameframe.setScore(score);
    }

}
