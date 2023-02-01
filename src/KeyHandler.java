
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class KeyHandler implements KeyListener {

    public boolean upPressed;
    public boolean downPressed;
    public boolean leftPressed;
    public boolean rightPressed;


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            upPressed = true;
            downPressed = false;
            leftPressed = false;
            rightPressed = false;
        }
        if(code == KeyEvent.VK_S){
            upPressed = false;
            downPressed = true;
            leftPressed = false;
            rightPressed = false;
        }
        if(code == KeyEvent.VK_A){
            upPressed = false;
            downPressed = false;
            leftPressed = true;
            rightPressed = false;
        }
        if(code == KeyEvent.VK_D){
            upPressed = false;
            downPressed = false;
            leftPressed = false;
            rightPressed = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

//        int code = e.getKeyCode();
//
//        if(code == KeyEvent.VK_W){
//            upPressed = false;
//        }
//        if(code == KeyEvent.VK_S){
//            downPressed = false;
//        }
//        if(code == KeyEvent.VK_A){
//            leftPressed = false;
//        }
//        if(code == KeyEvent.VK_D){
//            rightPressed = false;
//        }

    }
}
