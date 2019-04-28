import javax.swing.*;
import java.awt.*;

public class engine extends JFrame {

    static final char APPLE = 'A';

    public static void main(String[] args) {
        Board b = new Board();
        b.setSize(800, 600);
        b.setVisible(true);

        b.setSnake();
        b.showBoard();
    }

}
