package entity;

import main.GamePanel;

public class Base extends Entity{
    GamePanel gp;
    public int baseLeftX;
    public int baseRightX;
    public Base(GamePanel gp, int baseLeftX, int baseRightX){
        this.gp = gp;
        this.baseLeftX = baseLeftX;
        this.baseRightX = baseRightX;
    }
}
