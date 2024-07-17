package PrimitiveShapes;

import java.awt.*;

public class Rectangular extends Shape {
    int width, height;
    public Rectangular (int width, int height, Color color, boolean center) {
        super(color);

        type = ShapeType.RECTANGLE;
        this.isCentered = center;

        this.width = width;
        this.height = height;
    }

    public Rectangular (int width, int height, int posX, int posY, Color color, boolean center) {
        super(color);

        type = ShapeType.RECTANGLE;
        this.isCentered = center;

        this.width = width;
        this.height = height;

        this.posX = posX;
        this.posY = posY;
    }

    public Point GetPos () {
        int Xpos = (GetScreenSize().x/2) - (width/2);
        int Ypos = (GetScreenSize().y/2) - (height/2);

        return new Point(Xpos, Ypos);
    }

    public void draw (Graphics2D g2) {
        g2.setColor(color);
        // ------------- //

        if (isCentered)
            g2.fillRect(GetPos().x, GetPos().y, width, height);
        if (!isCentered)
            g2.fillRect(posX, posY, width, height);
    }
}
