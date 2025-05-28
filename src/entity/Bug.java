package entity;

import main.GamePanel;
import utils.CollisionChecker;

import java.awt.*;

public class Bug extends Entity{
    GamePanel gp;
    Base base;
    int bugX;
    int bugY;
    int direction;
    boolean isDead;
    int speed;

    public Bug(GamePanel gp, int bugY, int speed, int direction) {
        this.gp = gp;
        this.bugY = bugY;
        this.base = gp.getBase();
        this.speed = speed;
        this.direction = direction;
        this.isDead = false;

        if(direction == 0){
            this.bugX = 0;
        }else{
            this.bugX = 17*gp.tileSize;
        }
    }

    @Override
    public void update(){
        if(direction == 0){
            bugX += speed;
        }else {
            bugX -= speed;
        }

        if (reachedBase()){
            isDead = true;
        }
    }

    boolean reachedBase(){
        return CollisionChecker.checkCollision1D(base.baseLeftX,  base.baseRightX, bugX, bugX + gp.tileSize);
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.BLUE);
        g2.fillRect(bugX, bugY*gp.tileSize, gp.tileSize, gp.tileSize);
    }

    public void setIsDead(boolean isDead){
        this.isDead = isDead;
    }

    public boolean getIsDead(){
        return this.isDead;
    }

    public int getX(){
        return this.bugX;
    }
}
