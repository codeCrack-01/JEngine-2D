package Physics;

public class Vector2 {
    
    public int x, y;

    public Vector2 (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double magnitude ()
    {
        return Math.sqrt(x^2 + y^2);
    }
    public double angle ()
    {
        return Math.atan((double) this.y / this.x);
    }

    public Vector2 normalize () {
        double length = Math.sqrt(x^2 + y^2);

        // Normalize the vector
        if (length != 0) {
            x = (int) (x / length);
            y = (int) (y / length);

            return new Vector2(x, y);
        }
        else
            return new Vector2(0, 0);
    }
    public Vector2 Copy () {
        return new Vector2(this.x, this.y);
    }

    public static Vector2 Add (Vector2 a, Vector2 b) {
        return new Vector2(a.x + b.x, a.y + b.y);
    }
    public static Vector2 Subtract (Vector2 a, Vector2 b) {
        return new Vector2(a.x - b.x, a.y - b.y);
    }
    public static Vector2 Multiply (Vector2 a, Vector2 b) {
        return new Vector2(a.x * b.x, a.y * b.y);
    }
    public static Vector2 Divide (Vector2 a, Vector2 b) {
        return new Vector2(a.x / b.x, a.y / b.y);
    }

    public static Vector2 Add (Vector2 a, int b) {
        return new Vector2(a.x + b, a.y + b);
    }
    public static Vector2 Subtract (Vector2 a, int b) {
        return new Vector2(a.x - b, a.y - b);
    }
    public static Vector2 Multiply (Vector2 a, int b) {
        return new Vector2(a.x * b, a.y * b);
    }
    public static Vector2 Divide (Vector2 a, int b) {
        return new Vector2(a.x / b, a.y / b);
    }
}
