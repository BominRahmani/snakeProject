import javax.swing.JFrame;

public class Engine {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Board board = new Board();

        frame.add(board);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Snake Project");
        frame.pack();
        frame.setVisible(true);
    }

}
