package ui;

import main.GamePanel;
import main.LevelHandler;

import java.awt.*;

public class GameOverOverlay extends UIPanel {
    GamePanel gp;
    LevelHandler levelH;
    Font terminal_40B = new Font("Terminal", Font.BOLD, 50);

    public GameOverOverlay(GamePanel gp, LevelHandler levelH){
        this.gp = gp;
        this.levelH = levelH;
    }
    public void draw(Graphics2D g2) {
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        drawHealthBar(g2);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
        drawSignalLost(g2);
    }

    void drawSignalLost(Graphics2D g2){
        interval ++;
        if (interval <= 40){
            g2.setFont(terminal_40B);
            g2.setColor(Color.lightGray);
            g2.drawString("// SIGNAL LOST //", 4 * gp.tileSize, 3 * gp.tileSize);
        } else if(interval >= 80){
            interval = 0;
        }
    }

    void drawHealthBar(Graphics2D g2){
        g2.setColor(Color.DARK_GRAY);
        g2.fillRect(4 * gp.tileSize,gp.tileSize/4, 9 * gp.tileSize, gp.tileSize/2);
        g2.setColor(Color.GREEN);
        g2.fillRect(4 * gp.tileSize,gp.tileSize/4, 9 * gp.tileSize * this.levelH.getBaseHealth()/20, gp.tileSize/2);
    }
}
