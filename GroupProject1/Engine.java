import javax.swing.*;
import java.awt.*;

public class Engine {

    static boolean playing = true;
    static JFrame frame;
    static Board board;

    public Engine() {
        while (playing) {
            frame = new JFrame();
            board = new Board();
            frame.add(board);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Snake Project");
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            board.run();
            if (board.gameOver) {
                int input = JOptionPane.showConfirmDialog(null,
                        "Do you want to restart?", "Game Over", JOptionPane.YES_NO_OPTION);
                if (input == 1) {
                    playing = false;
                    System.exit(0);
                }
                else
                    frame.dispose();
            }
        }
    }

    public static void main(String[] args) {
        Engine e = new Engine();
    }
}
