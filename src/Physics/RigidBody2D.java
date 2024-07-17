package Physics;

import Entities.Entity;
import General.Time;
import Physics.Colliders.Collider2D;

public class RigidBody2D {

    private Entity entity;
    public Vector2 position, rotation, scale;
    private final Collider2D collider2D;
    public BodyType bodyType;
    //public Velocity/ velocity;

    public RigidBody2D (Entity entity, Collider2D collider2D) {
        this.entity = entity;
        this.collider2D = collider2D;

        bodyType = BodyType.STATIC;

        this.position = entity.transform.position;
        this.rotation = entity.transform.rotation;
        //this.velocity = new Velocity(0, 0);
    }

    public void MovePosition (Vector2 refPosition) {
        if (bodyType == BodyType.DYNAMIC) {
            position = refPosition;
            entity.transform.position = this.position;
        }
    }

    boolean isColliding () {
        if (collider2D.collision) {
            return true;
        } else {
            return false;
        }
    }
}

/*class Velocity {
    private double speed;
    private double direction; // in radians

    private Vector2 vel;

    public Velocity(double speed, double direction) {
        this.speed = speed;
        this.direction = direction;
    }
    public Velocity(int x, int y) {
        vel = new Vector2(x, y);
    }

    // Getters and setters
    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDirectionX() {
        return Math.cos(direction);
    }
    public double getDirectionY() {
        return Math.sin(direction);
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }
    public void setDirection(double directionX, double directionY) {
        this.direction = Math.atan(directionY / directionX);
    }
}*/

