import javax.swing.*;
import java.security.Key;
import java.util.Random;
import java.util.LinkedList;
import java.awt.event.KeyEvent;

public class Snake {

    private LinkedList<Body> entity = new LinkedList<Body>();
    private Body head;
    private Body tail;
    private int size;

    public Snake(){
        int xPos = randomNum();
        int yPos = randomNum();
        head = new Body(xPos, yPos);
        tail = head;
        entity.add(head);
        size = 1;
    }

    public int randomNum() {
        Random rand = new Random();
        return rand.nextInt(20);
    }

    public LinkedList<Body> getEntity() {
        return entity;
    }

    public void setEntity(LinkedList<Body> entity) {
        this.entity = entity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public Body getHead() {
        return head;
    }

    public void setHead(Body head) {
        this.head = head;
    }

    public Body getTail() {
        return tail;
    }

    public void setTail(Body tail) {
        this.tail = tail;
    }
}
