package entity;

import main.GamePanel;

import java.awt.*;

public class Bug extends Entity{
    GamePanel gp;
    int bugX;
    int bugY;
    boolean direction;
    int speed;

    public Bug(GamePanel gp, int speed, boolean direction) {
        this.gp = gp;
        this.speed = speed;
        this.direction = direction;

        this.bugY = 4 * gp.tileSize;
        if(direction){
            this.bugX = 0;
        }else{
            this.bugX = 17*gp.tileSize;
        }
    }

    public void update(){
        if(direction){
            bugX += speed;
        }else{
            bugX -= speed;
        }
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.BLUE);
        g2.fillRect(bugX, bugY, gp.tileSize, gp.tileSize);
    }
}
