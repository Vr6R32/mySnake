import java.awt.*;
import java.util.Random;

public class Fruit {

    boolean appleReset;
    public int fruitX;
    public int fruitY;
    Random random = new Random();

    GameWindow gameWindow;

    public Fruit(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setFruitPosition();

    }

    public void update() {

//        if(Snake.eatNow){
//            setFruitPosition();
//        }
    }


    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.RED);
        graphics2D.fillOval(fruitX, fruitY, GameWindow.unitSize, GameWindow.unitSize);
    }

    public void setFruitPosition() {

            fruitY = random.nextInt((int) (GameWindow.windowWidth / GameWindow.unitSize)) * GameWindow.unitSize;
            fruitX = random.nextInt((int) (GameWindow.windowWidth / GameWindow.unitSize)) * GameWindow.unitSize;
//        fruitY = 100;
//        fruitX = 100;
    }
    public int getFruitX() {
        return fruitX;
    }

    public void setFruitX(int fruitX) {
        this.fruitX = fruitX;
    }
    public int getFruitY() {
        return fruitY;
    }

    public void setFruitY(int fruitY) {
        this.fruitY = fruitY;
    }

}
