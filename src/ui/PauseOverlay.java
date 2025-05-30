package ui;

import main.GamePanel;
import main.LevelHandler;

import java.awt.*;

public class PauseOverlay extends UIPanel{
    GamePanel gp;
    LevelHandler levelH;
    Font terminal_40B = new Font("Terminal", Font.BOLD, 40);

    public PauseOverlay(GamePanel gp, LevelHandler levelH){
        this.gp = gp;
        this.levelH = levelH;
    }
    public void draw(Graphics2D g2) {
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        drawHealthBar(g2);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
        drawPaused(g2);
    }

    void drawHealthBar(Graphics2D g2){
        g2.setColor(Color.DARK_GRAY);
        g2.fillRect(4 * gp.tileSize,gp.tileSize/4, 9 * gp.tileSize, gp.tileSize/2);
        g2.setColor(Color.GREEN);
        g2.fillRect(4 * gp.tileSize,gp.tileSize/4, 9 * gp.tileSize * this.levelH.getBaseHealth()/20, gp.tileSize/2);
    }

    void drawPaused(Graphics2D g2){
        g2.setFont(terminal_40B);
        g2.setColor(Color.lightGray);
        g2.drawString("--PAUSED--", 11 * gp.tileSize, 4 * gp.tileSize);
    }
}
