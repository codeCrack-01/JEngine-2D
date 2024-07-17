package PrimitiveShapes;

import java.awt.*;

public class Triangle extends Shape {
    int size;
    double angle = 30;

    public Triangle (int size, Color color, boolean center) {
        super(color);
        this.size = size;

        type = ShapeType.TRIANGLE;
        this.isCentered = center;
    }

    public Triangle (int size, int posX, int posY, Color color, boolean center) {
        super(color);
        this.size = size;

        type = ShapeType.TRIANGLE;
        this.isCentered = center;

        this.posX = posX;
        this.posY = posY;
    }

    public Point GetDefaultPos () {
        int Xpos = (GetScreenSize().x/2) ;//- (size/2);
        int Ypos = (GetScreenSize().y/2) ;//- (size/2);

        return new Point(Xpos, Ypos);
    }
    private void drawEquilateralTriangle(Graphics2D g2, int centerX, int centerY) {
        int halfSize = size / 2;
        int[] xPoints = {centerX, centerX - halfSize, centerX + halfSize};
        int[] yPoints = {centerY - (int) (Math.sqrt(3) / 2 * halfSize), centerY + (int) (Math.sqrt(3) / 2 * halfSize), centerY + (int) (Math.sqrt(3) / 2 * halfSize)};
        g2.setColor(Color.RED);
        g2.fillPolygon(xPoints, yPoints, 3);
    }

    public void draw (Graphics2D g2) {
        g2.setColor(color);
        // ------------- //

        if (isCentered)
            drawEquilateralTriangle(g2, GetDefaultPos().x, GetDefaultPos().y);
        if (!isCentered)
            drawEquilateralTriangle(g2, posX, posY);
    }
}
