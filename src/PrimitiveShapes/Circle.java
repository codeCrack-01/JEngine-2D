package PrimitiveShapes;

import java.awt.*;

public class Circle extends Shape {
    int size;

    public Circle (int size, Color color, boolean center) {
        super(color);
        type = Shape.ShapeType.CIRCLE;

        this.size = size;
        this.isCentered = center;
    }

    public Circle (int size, int posX, int posY, Color color, boolean center) {
        super(color);
        type = Shape.ShapeType.CIRCLE;

        this.size = size;
        this.isCentered = center;

        this.posX = posX;
        this.posY = posY;
    }

    public Point GetPos () {
        int Xpos = (GetScreenSize().x/2) - (size/2);
        int Ypos = (GetScreenSize().y/2) - (size/2);

        return new Point(Xpos, Ypos);
    }

    public void draw (Graphics2D g2) {
        g2.setColor(color);
        // ------------- //

        if (isCentered)
            g2.fillOval(GetPos().x, GetPos().y, size, size);
        if (!isCentered)
            g2.fillOval(posX, posY, size, size);
    }
}
