package Physics.Colliders;

import java.awt.*;

import General.CollisionHandler;
import Physics.Vector2;
import Entities.*;
import General.GamePanel;

public class BoxCollider2D extends Collider2D {

    public Rectangle rectangle = new Rectangle(0, 0, 0, 0);

    public BoxCollider2D (Vector2 pos, Vector2 size, Entity entity) {
        initialPoint = pos;
        this.size = size;

        this.entity = entity;
        Setup();
    }

    void Setup () {
        rectangle.x = initialPoint.x;
        rectangle.y = initialPoint.y;

        rectangle.width = size.x;
        rectangle.height = size.y;

        CollisionHandler.RegisterCollider(this);
    }

    @Override
    public void update () {
        rectangle.x = entity.transform.position.x;
        rectangle.y = entity.transform.position.y;

        centerPoint = new Vector2(rectangle.x + (rectangle.width/2), rectangle.y + (rectangle.height/2));
    }

    @Override
    public void draw (Graphics2D g2) {
        g2.setColor(Color.GREEN);
        g2.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);

        g2.setColor(Color.cyan);
        g2.fillRect(centerPoint.x, centerPoint.y, 1, 1);
    }
}
