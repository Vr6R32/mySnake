import javax.swing.*;
import java.awt.*;

public class GameWindow extends JPanel implements Runnable{


    public static final int windowHeight = 600;
    public static final int windowWidth = 600;
    public static final int unitSize = 20;
    public static final int gameUnits = 30*30;



    long fps = 20;
    long singleFrame = 1000/fps;
//    long realfps = 1000/singleFrame;

    Thread gameThread;
    KeyHandler keyHandler = new KeyHandler();
    Fruit fruit = new Fruit(this);
    Snake snake = new Snake(this, keyHandler,this.fruit);



    public GameWindow() {
        this.setPreferredSize(new Dimension(windowWidth,windowHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        while(gameThread != null) {

            update();

            repaint();
            try {
                gameThread.sleep(singleFrame);
//                System.out.println("FPS : " + realfps);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void update() {

        snake.update();
        snake.collisionCheck();
        fruit.update();

//        System.out.println(snake.alive);
//        if(snake.collision()){
//            gameThread.stop();
//        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D)g;

        snake.draw(graphics2D);
        fruit.draw(graphics2D);


//        // DRAW A GRID
//        for(int i=0; i<windowHeight/unitSize;i++){
//            graphics2D.setColor(Color.white);
//            graphics2D.drawLine(i*unitSize,0,i*unitSize,windowHeight);
//        }
//        for(int i=0; i<windowWidth/unitSize;i++){
//            graphics2D.setColor(Color.white);
//            graphics2D.drawLine(0,i*unitSize,windowWidth,i*unitSize);
////            graphics2D.setColor(Color.white);
////            graphics2D.drawLine(0,i*unitSize,i*unitSize,windowWidth);
//        }


        graphics2D.dispose();
    }
}
