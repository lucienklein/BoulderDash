package view;

import controller.Order;
import controller.IOrderPerformer;
import controller.UserOrder;
import controller.IUserOrder;

import java.awt.event.KeyEvent;

/**
 * @author Thierry
 * the class eventperformer
 */
public class EventPerformer implements IEventPerformer {
/*the orderperformer*/
    private final IOrderPerformer orderPerformer;

    /**
     * the class constructor
     * @param orderPerformer the orderperformer
     */
    public EventPerformer(IOrderPerformer orderPerformer) {
        this.orderPerformer = orderPerformer;
    }

    /**
     * event performer method
     * @param keyCode the key pressed code
     */
    public void eventPerform(KeyEvent keyCode) {
        IUserOrder userOrder = this.keyCodeToUserOrder(keyCode.getKeyCode());
        if(userOrder != null) {
            this.orderPerformer.orderPerform(userOrder);
        }
    }

    /**
     * method to define the different orders for the player in function of the keys pressed
     * @param keyCode the key pressed code
     * @return the user order (the keyboard input)
     */
    private IUserOrder keyCodeToUserOrder(int keyCode) {

        IUserOrder userOrder = null;

        switch (keyCode) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_Z:
                userOrder = new UserOrder(Order.UP);
                break;

            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                userOrder = new UserOrder(Order.RIGHT);
                break;

            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                userOrder = new UserOrder(Order.DOWN);
                break;

            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_Q:
                userOrder = new UserOrder(Order.LEFT);
                break;

            case KeyEvent.VK_ESCAPE:
                userOrder  = new UserOrder(Order.EXIT);
                break;
        }

        return userOrder;
    }

}
