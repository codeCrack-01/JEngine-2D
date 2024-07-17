package PrimitiveShapes;

import General.*;
import java.awt.*;

public class Shape {
    public enum ShapeType {
        SQUARE, TRIANGLE, RECTANGLE, CIRCLE
    }

    protected ShapeType type;
    protected boolean isCentered;

    public int posX, posY;
    public Color color;

    public Shape (Color color) {
        this.color  = color;
    }

    protected Point GetScreenSize () {
        int screenW = GamePanel.screenWidth;
        int screenH = GamePanel.screenHeight;

        return new Point(screenW, screenH);
    }
}
