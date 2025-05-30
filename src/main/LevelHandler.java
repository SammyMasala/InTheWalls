package main;

import entity.Base;
import entity.Player;
import level.Lane;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class LevelHandler {
    GamePanel gp;
    Player player;
    Base base;

    ArrayList<ArrayList<Lane>> lanes;
    Random rand = new Random();
    int baseHealth;
    int currentPlayerY;
    int interval;

    public LevelHandler(GamePanel gp, int floorNum){
        this.gp = gp;
        this.base = new Base(this.gp, 7 *gp.tileSize, 10 * gp.tileSize);
        this.lanes = new ArrayList<>();
        this.baseHealth = 20;
        init(floorNum);
    }

    public void setPlayer(Player player){
       this.player = player;
    }

    public void changePlayerLevel(int direction){
        if(direction == 0 && this.currentPlayerY >= 1){
            this.currentPlayerY -= 1;
        }else if(direction == 1 && this.currentPlayerY <= 1){
            this.currentPlayerY += 1;
        }
        this.player.setPlayerY(this.currentPlayerY);
    }

    void init(int floorNum){
        interval = 0;
        currentPlayerY = 1;
        for (int i = 0;i<floorNum;i++){
            lanes.add(new ArrayList<>());
            lanes.get(i).add(new Lane(gp, this.base, this, i+1, 0));
            lanes.get(i).add(new Lane(gp, this.base, this, i+1, 1));
        }
    }

    public void damageBug(int direction){
        lanes.get(currentPlayerY).get(direction).dealDamage();
    }
    public void damageBase(int damage){
        this.baseHealth -= damage;
        if(baseHealth <= 0){
            baseHealth = 0;
        }
    }

    public int getBaseHealth(){
        return Math.max(0, this.baseHealth);
    }

    public void createBug(){
        int randFloor = rand.nextInt(lanes.size());
        int randDirection = rand.nextInt(2);
        lanes.get(randFloor).get(randDirection).addBug();
    }

    public void update(){
        interval++;
        if(this.baseHealth <= 0){
            gp.endGame();
        }

        this.player.update();
        for (ArrayList<Lane> lanes : lanes) {
            for (Lane lane : lanes) {
                lane.update();
            }
        }
        if (interval >= 60){
            interval = 0;
            createBug();
        }
    }

    public void drawEntities(Graphics2D g2){
        this.player.draw(g2);
        for (ArrayList<Lane> lanes : lanes) {
            for (Lane lane : lanes) {
                lane.draw(g2);
            }
        }
    }
}
