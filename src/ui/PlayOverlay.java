package ui;

import main.GamePanel;
import main.LevelHandler;

import java.awt.*;

public class PlayOverlay implements UIPanel{
    GamePanel gp;
    LevelHandler levelH;

    public PlayOverlay(GamePanel gp, LevelHandler levelH){
        this.gp = gp;
        this.levelH = levelH;
    }
    public void draw(Graphics2D g2){
        drawHealthBar(g2);
    }
    void drawHealthBar(Graphics2D g2){
        g2.setColor(Color.DARK_GRAY);
        g2.fillRect(4 * gp.tileSize,gp.tileSize/4, 9 * gp.tileSize, gp.tileSize/2);
        g2.setColor(Color.GREEN);
        g2.fillRect(4 * gp.tileSize,gp.tileSize/4, 9 * gp.tileSize * this.levelH.getBaseHealth()/20, gp.tileSize/2);

    }
}
