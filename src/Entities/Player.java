package Entities;

import General.GamePanel;
import InputSystem.*;
import Physics.BodyType;
import Physics.RigidBody2D;
import Physics.Vector2;
import Physics.Colliders.*;

import java.awt.*;

public class Player extends Entity {
    int speed = 4;
    boolean canMove;

    public BoxCollider2D collider;
    RigidBody2D rb;

    public Player (String name) {
        this.name = name;
        SetDefaults();
    }

    void SetDefaults () {
        transform.position = new Vector2((GamePanel.screenWidth/2) - GamePanel.tileSize, (GamePanel.screenHeight/2) - GamePanel.tileSize);
        transform.scale = new Vector2(GamePanel.tileSize, GamePanel.tileSize);

        canMove = true;
        collider = new BoxCollider2D(transform.position, new Vector2(GamePanel.tileSize, GamePanel.tileSize), this);

        rb = new RigidBody2D(this, collider);
        rb.bodyType = BodyType.DYNAMIC;
    }

    @Override
    public void update(double deltaTime)
    {
        Vector2 input = Input2D.InputVector();

        if (canMove) {
            Vector2 ref = Vector2.Add(rb.position, Vector2.Multiply(Vector2.Multiply(input, speed), (int)deltaTime));
            rb.MovePosition(ref);
        }
    }

    public void repaint(Graphics2D g2)
    {
        g2.setColor(Color.white);
        g2.fillRect(rb.position.x, rb.position.y, GamePanel.tileSize, GamePanel.tileSize);

        g2.setColor(Color.red);
        g2.fillRect(transform.position.x, transform.position.y, 10, 10);
    }
}
