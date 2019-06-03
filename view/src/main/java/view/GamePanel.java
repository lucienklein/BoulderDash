package view;import model.IEntity;import javax.swing.*;import java.awt.*;import java.awt.image.BufferedImage;import java.util.ArrayList;import java.util.Observable;import java.util.Observer;/** * @author Thierry * the panel class (what will be contained by the window) */public class GamePanel extends JPanel implements Observer {    /*the map*/    private BufferedImage map;    /*the entities array*/    private ArrayList<IEntity> entities;    /*the score*/    private String score;    /*the score*/    public GamePanel() {        map = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);    }    /**     * @param o the observer     * @param arg the argument     */    @Override    public void update(Observable o, Object arg) {    }    /**     * paintcomponent the usual method provided with the jpanel     * @param graphics the graphics     */    @Override    public void paintComponent(Graphics graphics) {        Graphics2D g2 = (Graphics2D) graphics;        g2.scale(1.5, 1.5);        g2.translate(0, 0);        graphics.drawImage(map, 0, 0, null);        if(entities != null) {            for(IEntity entity : entities) {                graphics.drawImage(entity.getImage(), entity.getX(), entity.getY(), null);            }        }        graphics.setColor(Color.WHITE);        graphics.fillRoundRect(0, 0, 75, 20, 10, 10);        g2.setColor(Color.DARK_GRAY);        g2.drawString("Score: " + score, 5, 15);    }    /**     * @param imageMap the map     */    public void setImageMap(BufferedImage imageMap) {        this.map = imageMap;        this.repaint();    }    /**     * @param entities the entities stored in the array list     */    public void setEntities(ArrayList<IEntity> entities) {        this.entities = entities;        this.repaint();    }    /**     * setter for the score     * @param score the score     */    public void setScore(String score) {        this.score = score;        this.repaint();    }}