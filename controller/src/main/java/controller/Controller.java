package controller;

import model.*;
import view.IView;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.SQLException;

/**
 * @author Laurent Class controller (part of the mvc) we define the methods used
 *         by our program
 */
public class Controller implements IController, IOrderPerformer {

    private IEnemy enemy;
    /*
     * The view.
     */
    private IView view;

    /*
     * The model.
     */
    private IModel model;

    /*
     * State of the game
     */
    private boolean isGameOver;

    /*
     * Timer
     */
    private long elapsed;

    /**
     * Instantiates a new controller
     *
     * @param model the model
     */
    public Controller(final IModel model) {
        super();
        this.model = model;
        this.isGameOver = false;
        this.elapsed = 0;
        this.buildMap();
    }

    public void setView(final IView view) {
        this.view = view;
    }

    /**
     * Start method
     * 
     * @throws SQLException the SQL exception
     */
    public void start() throws SQLException {
        this.getView().createWindow((int) (this.getModel().getMap().getWidth() * 16 * 1.5),
                (int) (this.getModel().getMap().getHeight() * 16 * 1.5));
        this.gameLoop();
        if (this.getModel().getMap().getNbDiamond() == this.getModel().getMap().getScore()
                && this.getModel().getPlayer().getIsAlive())
            this.getView().displayMessage("You Win");
        else
            this.getView().displayMessage("Game Over :(");
        this.exitGame();
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    public IView getView() {
        return this.view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() {
        return this.model;
    }

    /*
     * The gameloop
     */
    private void gameLoop() {
        while (!isGameOver) {
            if (this.getModel().getEntities() != null) {
                for (IEntity entity : this.getModel().getEntities()) {
                    entity.move(this.getModel().getMap());
                }
            }

            if (!this.getModel().getPlayer().getIsAlive()) {
                toggleGameOver();
            }
            /*
             * refresh system, in order to not have the boulder to fall too fast
             */
            if (System.nanoTime() - elapsed >= 750000000) {
                elapsed = System.nanoTime();
                moveEnnemy();
                spriteMoveAble();
                Ennemy();

            }
            collisionManager();

            this.display();
        }
    }

    /*
     * Toggle attribute isGameOver
     */
    private void toggleGameOver() {
        isGameOver = !isGameOver;
    }

    /*
     * Manage the collision
     */
    private void collisionManager() {
        IEntity player = this.getModel().getPlayer();
        IMap map = this.getModel().getMap();

        if (player.getX() <= 0)
            player.setX(0);
        if (player.getX() >= map.getWidth() * 16)
            player.setX(map.getWidth() * 16 - 16);
        if (player.getY() <= 0)
            player.setY(0);
        if (player.getY() >= map.getHeight() * 16)
            player.setY(map.getHeight() * 16 - 16);

        int spriteID = map.getSprite(player.getX() / 16, player.getY() / 16).getID();
        /*
         * method to make the character move, and it checks with the direction if the
         * next block is a breakable block (diamond or dirt) and if it is, the player
         * can continue to move in the direction chosen
         */
        switch (player.getDirection()) {
        case UP:
            if (player.getY() >= 0) {
                if (spriteID == 0 || spriteID == 3 || spriteID == 9) {
                    player.setY(player.getY() + 16);
                }
            }
            break;

        case DOWN:
            if (player.getY() < map.getHeight() * 16) {
                if (spriteID == 0 || spriteID == 3 || spriteID == 9) {
                    player.setY(player.getY() - 16);
                }
            }
            break;

        case LEFT:
            if (player.getX() >= 0) {
                if (spriteID == 0 || spriteID == 3 || spriteID == 9) {
                    player.setX(player.getX() + 16);
                }
            }
            break;

        case RIGHT:
            if (player.getX() < map.getWidth() * 16) {
                if (spriteID == 0 || spriteID == 3 || spriteID == 9) {
                    player.setX(player.getX() - 16);
                }
            }
            break;
        }
        /*
         * we test if the next block is the dirt or a diamond and if it's true we
         * replace it with a background sprite
         */
        if (spriteID == 1 || spriteID == 4) {
            map.setSprite(2, player.getX() / 16, player.getY() / 16, this.getModel().getSpritePack());

            if (spriteID == 4) {
                map.setScore(map.getScore() + 1);
            }
        }
        /**
         * @param spriteID variable to contain the sprite/object association Sprite
         *                 association for the exit and if the exit is
         */
        if (spriteID == 6) {
            if (map.getScore() == this.getModel().getMap().getNbDiamond())
                toggleGameOver();
        }
        /*
         * we look if the coordinates of an entity different from a player is on the
         * same coordinates, and if it's true, that means that the player is dead so
         * then the game is over
         */
        for (IEntity entity : this.getModel().getEntities()) {
            if (!entity.isPlayer()) {
                if (entity.getX() == player.getX() && entity.getY() == player.getY())
                    toggleGameOver();
            }
        }
    }

    /*
     * this is the mezthod which makes the boulders mvoe and fall again if they fall
     * on another pile of boulders
     */
    private void spriteMoveAble() {
        IMap map = this.getModel().getMap();
        for (int y = map.getHeight() - 1; y > 0; y--) {
            for (int x = map.getWidth() - 1; x > 0; x--) {
                ISprite sprite = map.getSprite(x, y);
                if (sprite.isFallable() && map.getSprite(x, y + 1).getID() == 2
                        && this.getModel().getPlayer().getY() / 16 != y + 1) {
                    if (sprite.getID() == 3 || sprite.getID() == 4) {
                        /**
                         * here we choose the sprite texture pack we want to use
                         */
                        BufferedImage spritePack = this.getModel().getSpritePack();
                        map.setSprite(2, x, y, spritePack);
                        map.setSprite(sprite.getID(), x, y + 1, spritePack);
                        hit();
                        return;

                    }
                }
            }

        }
    }

    /*
     * The method that builds the map and gets the chosen textures from the "list"
     * the buffered image is the fact it will refresh the image, and in our case we
     * have an image arrayList
     */
    private void buildMap() {
        ISprite[][] spritesPacks = this.getModel().getMap().getSprites();
        BufferedImage tmp = new BufferedImage(this.getModel().getMap().getWidth() * 16,
                this.getModel().getMap().getHeight() * 16, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < this.getModel().getMap().getHeight(); i++) {
            for (int j = 0; j < this.getModel().getMap().getWidth(); j++) {
                int num = spritesPacks[i][j].getID();
                int x = num % 12 * 16;
                int y = num / 12 * 16;
                BufferedImage sprite = this.getModel().getSpritePack().getSubimage(x, y, 16, 16);
                Graphics g = tmp.getGraphics();
                g.drawImage(sprite, j * 16, i * 16, null);
            }
        }
        this.getModel().getMap().setImage(tmp);
    }

    /*
     * method which displays the map (used next in the view)
     */
    private void display() {
        this.getView().drawMap(this.getModel().getMap().getImage());
        if (this.getModel().getEntities() != null) {
            this.getView().drawEntities(this.getModel().getEntities());
        }
        this.getView().drawScore(this.getModel().getMap().getScore() + "/" + this.getModel().getMap().getNbDiamond());
    }

    /*
     * Method to qui the game (close the window)
     */
    private void exitGame() {
        this.getView().closeWindow();
        System.exit(0);
    }

    /**
     * @param userOrder defines the order for the player movement
     */
    @Override
    public void orderPerform(IUserOrder userOrder) {
        if (userOrder != null) {
            Direction direction = null;
            IEntity player = this.getModel().getPlayer();
            int x = player.getX();
            int y = player.getY();

            switch (userOrder.getOrder()) {
            case UP:
                direction = Direction.UP;
                player.setY(y - 16);
                break;

            case DOWN:
                direction = Direction.DOWN;
                player.setY(y + 16);
                break;

            case LEFT:
                direction = Direction.LEFT;
                player.setX(x - 16);
                break;

            case RIGHT:
                direction = Direction.RIGHT;
                player.setX(x + 16);
                break;

            case EXIT:
                this.exitGame();
                break;

            default:
                direction = player.getDirection();
            }

            player.setDirection(direction);
        }
    }

    /**
     * the method to take care the enemy movement
     */
    private void moveEnnemy() {
        IMap map = this.getModel().getMap();
        for (int y = map.getHeight() - 1; y > 0; y--) {
            for (int x = map.getWidth() - 1; x > 0; x--) {
                ISprite sprite = map.getSprite(x, y);
                if (sprite.isFallable() && map.getSprite(x, y + 1).getID() == 2) {
                    if (sprite.getID() == 9) {
                        /**
                         * here we choose the sprite texture pack we want to use
                         */
                        BufferedImage spritePack = this.getModel().getSpritePack();
                        map.setSprite(2, x, y, spritePack);
                        map.setSprite(sprite.getID(), x, y + 1, spritePack);
                        return;
                    }
                }
                if (sprite.isFallable() && map.getSprite(x, y - 1).getID() == 2) {
                    if (sprite.getID() == 9) {
                        /**
                         * here we choose the sprite texture pack we want to use
                         */
                        BufferedImage spritePack = this.getModel().getSpritePack();
                        map.setSprite(2, x, y, spritePack);
                        map.setSprite(sprite.getID(), x, y - 1, spritePack);
                        return;
                    }
                }
                if (sprite.isFallable() && map.getSprite(x + 1, y).getID() == 2) {
                    if (sprite.getID() == 9) {
                        /**
                         * here we choose the sprite texture pack we want to use
                         */
                        BufferedImage spritePack = this.getModel().getSpritePack();
                        map.setSprite(2, x, y, spritePack);
                        map.setSprite(sprite.getID(), x + 1, y, spritePack);
                        return;
                    }
                }
                if (sprite.isFallable() && map.getSprite(x - 1, y).getID() == 2) {
                    if (sprite.getID() == 9) {
                        /**
                         * here we choose the sprite texture pack we want to use
                         */
                        BufferedImage spritePack = this.getModel().getSpritePack();
                        map.setSprite(2, x, y, spritePack);
                        map.setSprite(sprite.getID(), x - 1, y, spritePack);
                        return;
                    }
                }

            }
        }
    }

    /**
     * this is the method for the enemy
     */
    private void Ennemy() {
        IMap map = this.getModel().getMap();
        for (int y = map.getHeight() - 1; y > 0; y--) {
            for (int x = map.getWidth() - 1; x > 0; x--) {
                ISprite sprite = map.getSprite(x, y);
                if (sprite.getID() == 9) {
                    if ((this.getModel().getPlayer().getY() / 16 == y + 1
                            && this.getModel().getPlayer().getX() / 16 == x)
                            || (this.getModel().getPlayer().getY() / 16 == y - 1
                                    && this.getModel().getPlayer().getX() / 16 == x)
                            || (this.getModel().getPlayer().getY() / 16 == y
                                    && this.getModel().getPlayer().getX() / 16 == x + 1)
                            || (this.getModel().getPlayer().getY() / 16 == y
                                    && this.getModel().getPlayer().getX() / 16 == x - 1)) {
                        this.getModel().getPlayer().setIsAlive(false);
                        toggleGameOver();
                        return;
                    }
                }

            }
        }
    }

    public void hit() {
        IMap map = this.getModel().getMap();
        for (int y = map.getHeight() - 1; y > 0; y--) {
            for (int x = map.getWidth() - 1; x > 0; x--) {
                ISprite sprite = map.getSprite(x, y);
                if (sprite.getID() == 3 || sprite.getID() == 4) {
                    if (this.getModel().getPlayer().getY() / 16 == y + 1
                            && this.getModel().getPlayer().getX() / 16 == x) {
                        this.getModel().getPlayer().setIsAlive(false);
                        toggleGameOver();
                        return;
                    }
                    if (map.getSprite(x, y + 1).getID() == 9) {
                        BufferedImage spritePack = this.getModel().getSpritePack();
                        map.setSprite(4, x, y + 1, spritePack);
                        return;

                    }
                }
            }
        }
    }
}