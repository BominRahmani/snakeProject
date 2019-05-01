import javax.swing.*;
import java.awt.*;

public class Body {

    private int xPos;
    private int yPos;
    private int height;
    private int width;
    private Color color;

    public Body() {
        xPos = 0;
        yPos = 0;
        height = 0;
        width = 0;
    }

    public Body(int x, int y, int size, Color color) {
        xPos = x;
        yPos = y;
        height = size;
        width = size;
        this.color = color;
    }

    public void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillRect(xPos, yPos, height, width);
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
}
