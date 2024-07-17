package InputSystem;

import java.awt.event.KeyEvent;
import java.util.Objects;

import Physics.Vector2;

public class KeyboardInput extends Input2D {

    public static boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            upPressed = true;
        }
        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            downPressed = true;
        }
        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
        if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }

        xAxis = (rightPressed)?1:((leftPressed)?-1:0);
        yAxis = (upPressed)?-1:((downPressed)?1:0);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }

        xAxis = (rightPressed)?1:((leftPressed)?-1:0);
        yAxis = (upPressed)?-1:((downPressed)?1:0);
    }

    public static int GetAxis(String axis) {

        if (Objects.equals(axis, Axis.Horizontal.toString())) {
            return xAxis;
        }
        else if (Objects.equals(axis, Axis.Vertical.toString())) {
            return yAxis;
        }
        else {
            System.out.println("Error : Invalid Axis");
            return 0;
        }
    }

    public static Vector2 InputVector() {
        xAxis = (rightPressed)?1:((leftPressed)?-1:0);
        yAxis = (upPressed)?-1:((downPressed)?1:0);

        return new Vector2(xAxis, yAxis);
    }
}
