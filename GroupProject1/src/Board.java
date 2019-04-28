import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JFrame {

    private final int ROWS = 20;
    private final int COLUMNS = 20;
    private JTextArea display;
    private char[][] board;
    private Snake snake;

    public Board() {
        super("Snake Project");
        FlowLayout layout = new FlowLayout();
        this.setLayout(layout);

        display = new JTextArea();
        display.setPreferredSize(new Dimension(315, 500));
        display.setEditable(false);
        display.setFont(new Font("bold", 1, 19));
        add(display);

        snake = new Snake();
        board = new char[ROWS][COLUMNS];
        initializeBoard();

        display.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                movement(evt);
            }
        });
    }

    public void initializeBoard() {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                board[x][y] = '-';
            }
        }
    }

    public void showBoard() {
        display.setText("");
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                display.append(board[x][y] + "  ");
            }
            display.append("\n");
        }
    }

    public void setSnake() {
        try {
            board[snake.getHead().getyPos()][snake.getHead().getxPos()] = snake.getHead().getSymbol();
        }
        catch (IndexOutOfBoundsException e) {
            snake.getHead().setxPos(5);
            snake.getHead().setyPos(5);
        }
        finally {
            board[snake.getHead().getyPos()][snake.getHead().getxPos()] = snake.getHead().getSymbol();
        }
    }

    private void movement(KeyEvent evt) {
        int key = evt.getKeyCode();

        if (key == KeyEvent.VK_W) {
            snake.getHead().setyPos(snake.getHead().getyPos() - 1);
        }
        else if (key == KeyEvent.VK_S) {
            snake.getHead().setyPos(snake.getHead().getyPos() + 1);
        }
        else if (key == KeyEvent.VK_A) {
            snake.getHead().setxPos(snake.getHead().getxPos() - 1);
        }
        else if (key == KeyEvent.VK_D) {
            snake.getHead().setxPos(snake.getHead().getxPos() + 1);
        }
        initializeBoard();
        setSnake();
        showBoard();
    }
}