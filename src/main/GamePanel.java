package main;

import controller.AIController;
import entity.Base;
import entity.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    final int baseTileSize = 16;
    final int scale = 3;

    public final int tileSize = scale * baseTileSize;
    final int maxScreenCol = 17;
    final int maxScreenRow = 10;

    final int screenWidth = tileSize*maxScreenCol;
    final int screenHeight = tileSize*maxScreenRow;

    final int FPS = 60;

    Thread gameThread;

//    Game initialization
    KeyHandler keyH = new KeyHandler();
    Player player = new Player(this, keyH, 8 * tileSize, 4 * tileSize);
    final public Base base = new Base(this, 7 * tileSize, 10 * tileSize);
    AIController aiController = new AIController(this, base);

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = (double) 1000000000 /FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime-lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();

                delta --;
            }
        }
    }

    public void update(){
        this.player.update();
        this.aiController.next();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        this.player.draw(g2);
        this.aiController.draw(g2);

        g2.dispose();
    }
}
