package main;

import ui.GameOverOverlay;
import ui.PauseOverlay;
import ui.PlayOverlay;

import java.awt.*;

public class UIHandler {
    GamePanel gp;
    LevelHandler levelH;
    GameOverOverlay goO;
    PauseOverlay pauseO;
    PlayOverlay playO;

    int gameState;

    public UIHandler(GamePanel gp, LevelHandler levelH){
        this.gp = gp;
        this.levelH = levelH;

        this.goO = new GameOverOverlay(levelH);
        this.pauseO = new PauseOverlay(levelH);
        this.playO = new PlayOverlay(gp, levelH);

    }
    public void update(){

    }

    public void setGameState(int gameState){
        this.gameState = gameState;
    }

    public void draw(Graphics2D g2){
        switch(this.gameState){
            case 0:
                this.playO.draw(g2);
                break;
            case 1:
                this.pauseO.draw(g2);
                break;
            case 2:
                this.goO.draw(g2);
                break;
            default:
                break;
        }
    }
}
