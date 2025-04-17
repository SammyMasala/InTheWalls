package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed = false;
    public boolean upLocked = false;

    public boolean leftPressed = false;
    public boolean leftLocked = false;

    public boolean downPressed = false;
    public boolean downLocked = false;

    public boolean rightPressed = false;
    public boolean rightLocked = false;

    public boolean supPressed = false;
    public boolean supLocked = false;

    public boolean pausePressed = false;
    public boolean pauseLocked = false;



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W && !upLocked){
            upPressed = upLocked = true;
        }else if (code == KeyEvent.VK_A && !leftLocked){
            leftPressed = leftLocked = true;
        }else if (code == KeyEvent.VK_S && !downLocked){
            downPressed = downLocked = true;
        }else if (code == KeyEvent.VK_D && !rightLocked){
            rightPressed = rightLocked = true;
        }else if (code == KeyEvent.VK_V && !supLocked){
            supPressed = supLocked = true;
        }else if (code == KeyEvent.VK_P && !pauseLocked){
            pausePressed = pauseLocked = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W){
            upPressed = upLocked = false;
        }else if (code == KeyEvent.VK_A){
            leftPressed = leftLocked = false;
        }else if (code == KeyEvent.VK_S){
            downPressed = downLocked = false;
        }else if (code == KeyEvent.VK_D){
            rightPressed = rightLocked = false;
        }else if (code == KeyEvent.VK_V){
            supPressed = supLocked = false;
        }else if (code == KeyEvent.VK_P){
            pausePressed = pauseLocked = false;
        }
    }
}
