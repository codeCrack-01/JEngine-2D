package General;

import Demos.Box_Thing;
import Entities.Player;
import InputSystem.*;
import Physics.Colliders.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.logging.Logger;

public class GamePanel extends JPanel implements Runnable {

    private static final int originalTileSize = 16; // (16 x 16) pixel tile set
    private static final int scale = 3;

    public static final int tileSize = originalTileSize * scale; // 48x48 tiles

    public static final int maxScreenCol = 16;
    public static final int maxScreenRow = 12;

    public static final int screenWidth = maxScreenCol * tileSize;
    public static final int screenHeight = maxScreenRow * tileSize;

    int FPS = 60;
    public Thread gameThread;

    //TODO: Remove At Complete.
    KeyboardInput keyboard = new KeyboardInput();
    Player player = new Player("Player");

    // EXPERIMENTAL ONLY !
    public static final Logger log = Logger.getLogger(GamePanel.class.getName());
    public static Time time;

    private final CollisionHandler collisionCheck = new CollisionHandler();
    public Box_Thing box1 = new Box_Thing(25, 25, GamePanel.tileSize, GamePanel.tileSize, Color.gray, "Box1");
    public Box_Thing box2 = new Box_Thing(50, 100, GamePanel.tileSize, GamePanel.tileSize, Color.gray, "Box2");
    

    public GamePanel ()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(new Color(32, 32, 32));

        this.setDoubleBuffered(true);
        this.addKeyListener(keyboard);

        this.setFocusable(true);
        time = new Time();
    }

    public void StartGameThread () {
        gameThread = new Thread(this);
        gameThread.start();

        log.info("Game Thread has initialized...");
    }

    @Override
    public void run() {
        double drawInterval = (double) 1000000000 / FPS; // Interval in nano-seconds.
        double delta = 0;

        double lastTime = System.nanoTime();
        double currentTime;

        while (gameThread != null)
        {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta > 1)
            {
                update();
                repaint();

                delta --;
            }
        }
    }

    private void update()
    {
        time.update();
        double scaledDeltaTime = time.getDeltaTime() * 100;

        player.update(scaledDeltaTime);
        collisionCheck.update();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // All Graphics Goes Here...

        // PLAYER !
        player.repaint(g2);
        box1.draw(g2);
        box2.draw(g2);

        // Disposal...
        collisionCheck.draw(g2);
        g2.dispose();
    }
}
