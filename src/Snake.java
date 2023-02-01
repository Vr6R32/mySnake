import java.awt.*;

public class Snake {
    KeyHandler keyHandler;
    Fruit fruit;
    GameWindow gameWindow;
    public boolean alive = true;
    int snakeParts = 5;
    int appleEaten = 0;
//    public static boolean eatNow = false;
    int x[] = new int[GameWindow.gameUnits];
    int y[] = new int[GameWindow.gameUnits];

    public Snake(GameWindow gameWindow, KeyHandler keyHandler, Fruit fruit) {
        this.gameWindow = gameWindow;
        this.keyHandler = keyHandler;
        this.fruit = fruit;
        keyHandler.rightPressed = true;

    }


    public void update(){

        appleEat();
        if(fruit.appleReset){
            fruit.setFruitPosition();
            fruit.appleReset=false;
        }

        for(int i = snakeParts; i>0; i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        if(keyHandler.upPressed && alive){
//            snakeY -= snakeSpeed;
            y[0] = y[0] - gameWindow.unitSize;
//            System.out.println("Position y : " + y[0]);
//            System.out.println("Position x : " + x[0]);
        }
        if(keyHandler.downPressed&& alive){
//            snakeY += snakeSpeed;
            y[0] = y[0] + gameWindow.unitSize;
        }
        if(keyHandler.leftPressed&& alive){
            x[0] = x[0] - gameWindow.unitSize;
//            snakeX -= snakeSpeed;
        }
        if(keyHandler.rightPressed&& alive){
//            snakeX += snakeSpeed;
            x[0] = x[0] + gameWindow.unitSize;
//            if(!alive) {
//                keyHandler.upPressed = false;
//                keyHandler.downPressed = false;
//                keyHandler.leftPressed = false;
//                keyHandler.rightPressed = false;
//            }
        }



    }
    public void collisionCheck() {
        // head touch body collision
        for(int i = snakeParts;i>0;i--){
            if((x[0] == x[i]) && (y[0] == y[i])){
                alive = false;
            }
        }
        // head touch left side
        if(x[0] < 0){
            alive = false;
        }
        // head touch right side
        if(x[0] > gameWindow.getWidth()){
            alive = false;
        }
        // head touch top side
        if(y[0] < 0){
            alive = false;
        }
        // head touch down side
        if(y[0] > gameWindow.getHeight()){
            alive = false;
        }
    }

        public void appleEat(){

        if((x[0] == fruit.getFruitX()) && (y[0] == fruit.getFruitY())){
            snakeParts++;
            appleEaten++;
            fruit.appleReset = true;
            System.out.println("APPLE TIME");
//            eatNow = true;
//            eatNow = false;
            }
        }
    public void draw(Graphics2D graphics2D) {

            for(int i=0; i<snakeParts;i++){
                if(i == 0) {
                    graphics2D.setColor(Color.GREEN);
                    graphics2D.fillRect(x[i], y[i], gameWindow.unitSize, gameWindow.unitSize);
                } else {
                    graphics2D.setColor(Color.WHITE);
                    graphics2D.fillRect(x[i], y[i], gameWindow.unitSize, gameWindow.unitSize);
                }
            }

                graphics2D.setFont(new Font("Brush Script MT",Font.PLAIN,40));
                graphics2D.setColor(Color.CYAN);
                graphics2D.drawString("Apples eaten : " + appleEaten,200,100);

            if(!alive){

                graphics2D.setFont(new Font("Brush Script MT",Font.PLAIN,100));
                graphics2D.setColor(Color.red);
                graphics2D.drawString("Game Over", 125,300);

            }
    }

}
