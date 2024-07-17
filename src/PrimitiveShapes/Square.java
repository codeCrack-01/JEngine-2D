package PrimitiveShapes;

import java.awt.*;

public class Square extends Shape {
    public int size;

    public Square (int size, Color color, boolean center) {
        super(color);
        type = ShapeType.SQUARE;

        this.size = size;
        this.isCentered = center;
    }

    public Square (int size, int posX, int posY, Color color, boolean center) {
        super(color);
        type = ShapeType.SQUARE;

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
            g2.fillRect(GetPos().x, GetPos().y, size, size);
        if (!isCentered)
            g2.fillRect(posX, posY, size, size);
    }
}
