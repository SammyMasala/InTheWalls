package entity;

import main.LevelHandler;
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
        if (keyH.pausePressed){
            switch (this.gp.getGameState()){
                case 0:
                    this.gp.pauseGame();
                    break;
                case 1:
                    this.gp.resumeGame();
                    break;
                default:
                    break;
            }
            keyH.pausePressed = false;
        }

        if (this.gp.getGameState() == 0) {
            if (keyH.upPressed) {
                this.levelH.changePlayerLevel(0);
                keyH.upPressed = false;
            } else if (keyH.downPressed && playerY / gp.tileSize <= 5) {
                this.levelH.changePlayerLevel(1);
                keyH.downPressed = false;
            } else if (keyH.leftPressed) {
                this.levelH.damageBug(0);
                keyH.leftPressed = false;
            } else if (keyH.rightPressed) {
                this.levelH.damageBug(1);
                keyH.rightPressed = false;
            }
        }
    }

    public void setPlayerY(int playerY){
        this.playerY = playerY;
    }

    public void draw(Graphics2D g2){
        if (this.gp.getGameState() != 0) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        }else{
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
        }
        g2.setColor(Color.white);
        g2.fillRect(playerX * gp.tileSize,(playerY + 1) * gp.tileSize, gp.tileSize, gp.tileSize);
    }
}
