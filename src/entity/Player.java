package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    int playerX;
    int playerY;

    public Player(GamePanel gp, KeyHandler keyH, int playerX, int playerY){
        this.gp = gp;
        this.playerX = playerX;
        this.playerY = playerY;
        this.keyH = keyH;
    }

    @Override
    public void update(){
        if(keyH.upPressed && playerY/gp.tileSize >= 5){
            playerY -= gp.tileSize;
            keyH.upPressed = false;

        }else if (keyH.downPressed && playerY/gp.tileSize <= 5){
            playerY += gp.tileSize;
            keyH.downPressed = false;
        }

    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        g2.fillRect(playerX,playerY, gp.tileSize, gp.tileSize);
    }
}
