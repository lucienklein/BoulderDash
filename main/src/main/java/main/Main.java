package main;

import controller.Controller;
import model.Entities.Enemy;
import model.Model;
import model.Entities.Player;
import view.View;

import java.sql.SQLException;

/**
 * @author Laurent the main class
 */
public class Main {

    /**
     * The main method which launches the program
     * 
     * @param args the arguments
     */
    public static void main(final String[] args) {
        final Controller controller = new Controller(new Model(4));
        controller.setView(new View(controller));
        controller.getModel().addEntity(new Player());
        try {
            controller.start();
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
    }

}
