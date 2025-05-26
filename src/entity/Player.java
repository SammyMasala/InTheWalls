package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    int playerX;
    int playerY;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.playerX = 8 * gp.tileSize;
        this.playerY = 4 * gp.tileSize;
        this.keyH = keyH;
    }

    public void update(){
        if(keyH.upPressed){
            playerY -= gp.tileSize;
            keyH.upPressed = false;
            if(playerY < 0){
                playerY = 0;
            }
        }else if (keyH.downPressed){
            playerY += gp.tileSize;
            keyH.downPressed = false;
            if(playerY > 300){
                playerY = 300;
            }
        }

    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        g2.fillRect(playerX,playerY, gp.tileSize, gp.tileSize);
    }
}
