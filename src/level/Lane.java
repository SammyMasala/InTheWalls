package level;

import entity.Bug;
import main.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Lane {
    GamePanel gp;
    ArrayList<Bug> bugs;
    LevelHandler levelHandler;
    int laneY;
    int direction;

    public Lane(GamePanel gp, LevelHandler levelHandler, int laneY, int direction){
        this.gp = gp;
        this.levelHandler = levelHandler;
        this.bugs = new ArrayList<>();

        this.laneY = laneY;
        this.direction = direction;
    }

    public void addBug(){
        bugs.add(new Bug(gp, laneY, 1, this.direction));
    }

    public void update(){
        Iterator<Bug> it = bugs.iterator();
        while(it.hasNext()){
            Bug bug = it.next();
            if(bug.getIsDead()){
                it.remove();
            }else{
                bug.update();
            }
        }
    }

    public void dealDamage(){
        if (direction == 0){
            bugs.stream().max(Comparator.comparingInt(Bug::getX)).ifPresent(nearest -> nearest.setIsDead(true));
        }else {
            bugs.stream().min(Comparator.comparingInt(Bug::getX)).ifPresent(nearest -> nearest.setIsDead(true));
        }
    }

    public void draw(Graphics2D g2){
//        for(Bug bug: bugs){
//            bug.draw(g2);
//        }
    }
}
