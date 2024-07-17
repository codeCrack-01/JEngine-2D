package General;

import java.awt.*;
import java.util.ArrayList;
import Physics.Colliders.*;

public class CollisionHandler {

    private static ArrayList<Collider2D> objects = new ArrayList<>();
    private boolean drawTest = false;

    private BoxCollider2D testObj1, testObj2;

    public static void RegisterCollider (Collider2D c) {
        objects.add(c);
        GamePanel.log.info("Registered collider : " + c.entity.name);
    }

    public void update () {

        if (!objects.isEmpty()) {
            for (Collider2D object : objects) {
                object.update();
            }
        }

        // Check collision between objects
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i + 1; j < objects.size(); j++) {
                BoxCollider2D obj1 = (BoxCollider2D) objects.get(i);
                BoxCollider2D obj2 = (BoxCollider2D) objects.get(j);

                if (obj1.rectangle.intersects(obj2.rectangle)) {
                    System.out.println("Collision detected between object " + i + " and object " + j + " : " + drawTest);

                    // You can handle collision here, like marking objects or triggering some action
                    drawTest = true;

                    obj1.collision = true;
                    obj2.collision = true;

                    testObj1 = obj1;
                    testObj2 = obj2;

                    CollisionLogic();
                }
            }
        }
    }

    public void draw (Graphics2D g2) {
        if (!objects.isEmpty()) {
            for (Collider2D object : objects) {
                object.draw(g2);
            }
        }

        if (drawTest)
        {
            g2.setColor(Color.YELLOW);
            g2.drawLine(testObj1.centerPoint.x, testObj1.centerPoint.y, testObj2.centerPoint.x, testObj2.centerPoint.y);
        }
    }

    private void CollisionLogic () {
        int testX = (testObj1.centerPoint.x - testObj2.centerPoint.x);
        int testW = testObj1.size.x;

        int result_X = Math.abs(testX) - Math.abs(testW);
        int testing = result_X * -(testX / Math.abs(testX));

        //testObj1.errorMargin.x = result_X;
        //testObj2.errorMargin.x = result_X;

        System.out.println(testing);
    }
}
