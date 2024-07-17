package Demos;

import Entities.Entity;
import General.GamePanel;
import Physics.Vector2;
import Physics.Colliders.BoxCollider2D;
import PrimitiveShapes.Rectangular;

import java.awt.*;

public class Box_Thing extends Entity {

    Color color;
    Rectangular box;
    BoxCollider2D collider;

    public Box_Thing (int x, int y, int width, int height, Color color, String name)
    {
        transform.position = new Vector2(x, y);
        transform.scale = new Vector2(width, height);

        this.color = color;
        this.name = name;

        box = new Rectangular(transform.scale.x, transform.scale.y, transform.position.x, transform.position.y, color, false);
        collider = new BoxCollider2D(transform.position, new Vector2(GamePanel.tileSize, GamePanel.tileSize), this);
    }

    public void draw (Graphics2D g2) {
        box.draw(g2);
    }
}
