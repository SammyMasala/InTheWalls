package entity;

import level.Lane;
import level.LevelHandler;
import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class Player extends Entity{
    GamePanel gp;
    LevelHandler levelH;
    KeyHandler keyH;
    int playerX;
    int playerY;

    public Player(GamePanel gp, LevelHandler levelH, KeyHandler keyH, int playerX, int playerY){
        this.gp = gp;
        this.levelH = levelH;
        this.playerX = playerX;
        this.playerY = playerY;
        this.keyH = keyH;
    }

    @Override
    public void update(){
        if(keyH.upPressed){
            this.levelH.changePlayerLevel(0);
            keyH.upPressed = false;
        }else if (keyH.downPressed && playerY/gp.tileSize <= 5){
            this.levelH.changePlayerLevel(1);
            keyH.downPressed = false;
        } else if (keyH.leftPressed){
            this.levelH.damageBug(0);
            keyH.leftPressed = false;
        } else if (keyH.rightPressed){
            this.levelH.damageBug(1);
            keyH.rightPressed = false;
        }

    }

    public void setPlayerY(int playerY){
        this.playerY = playerY;
    }

    public int getPlayerY(){
        return this.playerY;
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        g2.fillRect(playerX * gp.tileSize,playerY * gp.tileSize, gp.tileSize, gp.tileSize);
    }
}
