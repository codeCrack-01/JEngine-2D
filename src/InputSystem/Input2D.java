package InputSystem;

import Physics.Vector2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;

enum Axis {
    Horizontal, Vertical
}

public class Input2D implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static int xAxis;
    public static int yAxis;

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
        return new Vector2(xAxis, yAxis);
    }
}
