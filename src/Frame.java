import javax.swing.*;

public class Frame {
    public Frame() {
        JFrame window = new JFrame("mySnake");
        JButton button = new JButton("reset");
        GameWindow gameWindow = new GameWindow();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.add(gameWindow);
//        window.add(button);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gameWindow.startGameThread();


    }
}
