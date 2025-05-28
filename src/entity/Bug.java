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
    boolean reachedBase;
    boolean isDead;
    int speed;

    public Bug(GamePanel gp, int bugY, Base base, int speed, int direction) {
        this.gp = gp;
        this.bugY = bugY;
        this.base = base;
        this.speed = speed;
        this.direction = direction;
        this.isDead = false;
        this.reachedBase = false;

        if(direction == 0){
            this.bugX = 0;
        }else{
            this.bugX = 17*gp.tileSize;
        }
    }

    @Override
    public void update(){
        if(direction == 0){
            this.bugX += speed;
        }else {
            this.bugX -= speed;
        }

        this.reachedBase = CollisionChecker.checkCollision1D(
                this.base.baseLeftX,
                this.base.baseRightX,
                bugX,
                bugX + gp.tileSize
        );

        if (this.reachedBase){
            isDead = true;
        }
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.BLUE);
        g2.fillRect(this.bugX, this.bugY*gp.tileSize, this.gp.tileSize, this.gp.tileSize);
    }

    public void setIsDead(boolean isDead){
        this.isDead = isDead;
    }

    public boolean getIsDead(){
        return this.isDead;
    }

    public boolean getReachedBase(){
        return this.reachedBase;
    }

    public int getX(){
        return this.bugX;
    }
}
