package General;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {
        private static BufferedImage icon;

        public static void main(String[] args) throws IOException {

            JFrame window = new JFrame();
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            window.setResizable(false);
            window.setTitle("Test Program");

            //icon = ImageIO.read(Objects.requireNonNull(General.Main.class.getResourceAsStream("/icon.png")));
            //window.setIconImage(icon);

            GamePanel gamePanel = new GamePanel();
            window.add(gamePanel);

            window.pack();
            gamePanel.StartGameThread();

            window.setLocationRelativeTo(null);
            window.setVisible(true);
        }
}
