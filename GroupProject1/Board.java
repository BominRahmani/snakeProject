import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class Board extends JPanel implements Runnable, KeyListener {

    private static final int WIDTH = 700;
    private static final int HEIGHT = 600;
    private static final int PIXELS = 25;
    private static final int SPEED = 1250000;
    private static final Color headColor = new Color(255, 194, 87);
    private static final Color bodyColor = Color.YELLOW;
    private static final ImageIcon FIELD = new ImageIcon("C:\\Users\\kpopw\\Documents\\NetBeansProjects\\snakeProject\\src\\Grass.png");
    private static final ImageIcon APPLE = new ImageIcon("C:\\Users\\kpopw\\Documents\\NetBeansProjects\\snakeProject\\src\\Apple.png");
    private static final String SOUND = "C:\\Users\\kpopw\\Documents\\NetBeansProjects\\snakeProject\\src\\Crunch.wav";

    private int xApple;
    private int yApple;

    private Body head;
    private Body tail;
    private ArrayList<Body> SNAKE;
    private int score;

    private int xPos = 250, yPos = 250;
    private boolean UP = false, DOWN = false, LEFT = false, RIGHT = false;
    private int counter = 0;

    public boolean gameOver;

    public Board() {
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        head = new Body(xPos, xPos, PIXELS, headColor);
        head.setSoundFile(SOUND);
        tail = head;
        SNAKE = new ArrayList<Body>();
        SNAKE.add(head);
        score = 0;
        UP = false;
        DOWN = false;
        LEFT = false;
        RIGHT = false;

        xApple = randomX();
        yApple = randomY();

        addKeyListener(this);
    }

    //Move the snake
    public void slither() {
        counter++;
        if (counter > SPEED) {
            if (UP)
                yPos -= PIXELS;
            if (DOWN)
                yPos += PIXELS;
            if(LEFT)
                xPos -= PIXELS;
            if(RIGHT)
                xPos += PIXELS;
            counter = 0;

            update();
        }
    }

    //Update snake's position
    public void update() {
        if (length() > 1) {
            for (int i = length() - 1; i > 0; i--) {
                SNAKE.get(i).setxPos(SNAKE.get(i - 1).getxPos());
                SNAKE.get(i).setyPos(SNAKE.get(i - 1).getyPos());
            }
        }
        head.setxPos(xPos);
        head.setyPos(yPos);
    }

    public int randomX() {
        Random rand = new Random();
        return rand.nextInt(28) * 25;
    }

    public int randomY() {
        Random rand = new Random();
        return (rand.nextInt(20) + 2) * 25;
    }

    public int length() {
        return SNAKE.size();
    }

    //Place snake on grid
    public void spawnSnake(Graphics g) {
        for (int i = 0; i < length(); i++) {
            SNAKE.get(i).paintComponent(g);
        }
    }

    //Place apple on grid
    public void spawnApple(Graphics g) {
        while (!checkGrid(xApple, yApple)) {
            xApple = randomX();
            yApple = randomY();
        }
        APPLE.paintIcon(this, g, xApple, yApple);
    }

    //Gameover conditions
    public void collision(){
        //Out of bound check
        if (head.getxPos() < 0 || head.getyPos() < 50 || head.getxPos() > WIDTH || head.getyPos() > HEIGHT - 75) {
            gameOver = true;
        }

        //Body collision check
        for(int x = 1; x < SNAKE.size(); x++){
            if(head.getxPos() == SNAKE.get(x).getxPos() && head.getyPos() == SNAKE.get(x).getyPos()){
                gameOver = true;
            }
        }
    }

    public boolean checkGrid(int x, int y) {
        for (int i = 0; i < length(); i++) {
            if ((SNAKE.get(i).getxPos() == x) && (SNAKE.get(i).getyPos() == y)) {
                elongate();
                head.play();
                return false;
            }
        }
        return true;
    }

    //Adds on to the tail
    public void elongate(){
        ListIterator<Body> itr = SNAKE.listIterator(length() - 1);
        if (itr.hasPrevious()) {
            Body temp = itr.previous();
            if (tail.getxPos() + 25 == temp.getxPos()) {
                tail = new Body(tail.getxPos() - 25, tail.getyPos(), PIXELS, bodyColor);
                SNAKE.add(tail);
            }
            if (tail.getxPos() - 25 == temp.getxPos()) {
                tail = new Body(tail.getxPos() + 25, tail.getyPos(), PIXELS, bodyColor);
                SNAKE.add(tail);
            }
            if (tail.getyPos() - 25 == temp.getyPos()) {
                tail = new Body(tail.getxPos(), tail.getyPos() + 25, PIXELS, bodyColor);
                SNAKE.add(tail);
            }
            if (tail.getyPos() + 25 == temp.getyPos()) {
                tail = new Body(tail.getxPos(), tail.getyPos() - 25, PIXELS, bodyColor);
                SNAKE.add(tail);
            }
        }
        else {
            if (RIGHT) {
                tail = new Body(tail.getxPos() - 25, tail.getyPos(), PIXELS, bodyColor);
                SNAKE.add(tail);
            }
            if (LEFT) {
                tail = new Body(tail.getxPos() + 25, tail.getyPos(), PIXELS, bodyColor);
                SNAKE.add(tail);
            }
            if (UP) {
                tail = new Body(tail.getxPos(), tail.getyPos() + 25, PIXELS, bodyColor);
                SNAKE.add(tail);
            }
            if (DOWN) {
                tail = new Body(tail.getxPos(), tail.getyPos() - 25, PIXELS, bodyColor);
                SNAKE.add(tail);
            }
        }
    }

    public String scoreKeeper(){
        if(head.getxPos() == xApple && head.getyPos() == yApple)
            score += 20;
        return "Score: " + Integer.toString(score);
    }

    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, WIDTH, HEIGHT);

        //Put background
        g.setColor(new Color(92, 56, 25));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        //Draw 20 x 28 grid
        for (int i = 0; i < WIDTH / 25; i++) {
            g.drawLine(i * 25, 50, i * 25, HEIGHT - 50);
        }
        for (int i = 2; i < (HEIGHT - 25) / 25; i++) {
            g.drawLine(0, i * 25, WIDTH, i * 25);
        }

        //Put grass
        for (int i = 0; i < WIDTH / 25; i++) {
            for (int j = 2; j < (HEIGHT - 50) / 25; j++) {
                FIELD.paintIcon(this, g, i * 25, j * 25);
            }
        }

        //Display score
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
        g.drawString(scoreKeeper(), 0,25);

        g.drawString("Size: " + length(), 200, 25);

        spawnSnake(g);
        spawnApple(g);
        scoreKeeper();
        collision();
    }

    @Override
    public void run() {
        while (!gameOver) {
            slither();
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

     @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W && !DOWN) {
            UP = true;
            DOWN = false;
            LEFT = false;
            RIGHT = false;
        }
        if (key == KeyEvent.VK_UP && !DOWN) {
            UP = true;
            DOWN = false;
            LEFT = false;
            RIGHT = false;
        }
        if (key == KeyEvent.VK_S && !UP) {
            UP = false;
            DOWN = true;
            LEFT = false;
            RIGHT = false;
        }
        if (key == KeyEvent.VK_DOWN && !UP) {
            UP = false;
            DOWN = true;
            LEFT = false;
            RIGHT = false;
        }
        if (key == KeyEvent.VK_A && !RIGHT) {
            UP = false;
            DOWN = false;
            LEFT = true;
            RIGHT = false;
        }
        if (key == KeyEvent.VK_LEFT && !RIGHT) {
            UP = false;
            DOWN = false;
            LEFT = true;
            RIGHT = false;
        }
        if (key == KeyEvent.VK_D && !LEFT) {
            UP = false;
            DOWN = false;
            LEFT = false;
            RIGHT = true;
        }
        if (key == KeyEvent.VK_RIGHT && !LEFT) {
            UP = false;
            DOWN = false;
            LEFT = false;
            RIGHT = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
