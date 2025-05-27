package controller;

import entity.Base;
import entity.Bug;
import main.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class AIController {
    ArrayList<Bug> bugs;
    GamePanel gp;
    Base base;
    Random rand = new Random();

    int interval = 0;

    public AIController(GamePanel gp, Base base){
        this.bugs = new ArrayList<>();
        this.gp = gp;
        this.base = base;
    }

    public void createBug(){
        bugs.add(new Bug(gp, this, rand.nextInt(3) + 4, 1, rand.nextInt(3) % 2));
    }

    public void next(){
        interval++;
        if (interval >= 60){
            interval = 0;
            createBug();
        }

        Iterator<Bug> it = bugs.iterator();
        while(it.hasNext()){
            Bug bug = it.next();
            if(bug.isDead){
                it.remove();
            }else{
                bug.update();
            }
        }
    }

    public void draw(Graphics2D g2){
        for (Bug bug : bugs) {
            bug.draw(g2);
        }
    }
}
