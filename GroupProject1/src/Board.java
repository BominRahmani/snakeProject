import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Random;

public class Board extends JPanel implements Runnable {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private final int PIXEL = 25;
    private boolean gameOver;
    private Body head;
    private ArrayList<Body> SNAKE;
    private int score;

    public Board() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        head = new Body(randomNum(), randomNum(), PIXEL);
        SNAKE = new ArrayList<Body>();
        SNAKE.add(head);
        score = 0;
    }

    public int randomNum() {
        Random rand = new Random();
        return rand.nextInt(20) * 25;
    }

    public int snakeSize() {
        return SNAKE.size();
    }

    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, WIDTH, HEIGHT);

        //Draw 20 x 20 grid
        for (int i = 0; i < WIDTH / 25; i++) {
            g.drawLine(i * 25, 0, i * 25, HEIGHT);
        }
        for (int i = 0; i < HEIGHT / 25; i++) {
            g.drawLine(0, i * 25, HEIGHT, i * 25);
        }

        //Place the snake on the grid
        for (int i = 0; i < snakeSize(); i++) {
            SNAKE.get(i).paintComponent(g);
        }
    }
    @Override
    public void run() {
        while (!gameOver) {
            //Game code
        }
    }
}
