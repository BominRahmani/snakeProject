import javax.swing.*;

public class Engine {

    public Engine() {
        JFrame frame = new JFrame();
        Board board = new Board();

        frame.add(board);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Snake Project");
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        board.run();
        if(board.gameOver){
            JOptionPane.showMessageDialog(frame, "GameOver");
        }
    }

    public static void main(String[] args) {
        Engine e = new Engine();
    }

}