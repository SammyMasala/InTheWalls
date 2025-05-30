package main;

import entity.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    final int baseTileSize = 16;
    final int scale = 3;

    public final int tileSize = scale * baseTileSize;
    final int maxScreenCol = 17;
    final int maxScreenRow = 5;

    final int screenWidth = tileSize*maxScreenCol;
    final int screenHeight = tileSize*maxScreenRow;

    final int FPS = 60;

    Thread gameThread;
    int gameState;

//    Game initialization
    final KeyHandler keyH = new KeyHandler();
    final LevelHandler levelH = new LevelHandler(this,3);
    final UIHandler uiH = new UIHandler(this, this.levelH);

    final Player player = new Player(this, levelH, keyH, 8, 1);

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

        init();
    }

    void init(){

        this.levelH.setPlayer(this.player);
        this.gameState = 0;
    }

    void startGameThread(){
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

    public void resumeGame(){ this.gameState = 0;}
    public void pauseGame(){ this.gameState = 1;}
    public void endGame(){ this.gameState = 2; }
    public int getGameState(){
        return this.gameState;
    }

    public void update(){
        this.player.update();
        this.levelH.update();
        this.uiH.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        this.player.draw(g2);
        this.levelH.drawEntities(g2);
        this.uiH.draw(g2);
        g2.dispose();
    }
}
