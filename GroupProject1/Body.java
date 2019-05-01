import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.io.File;

public class Body {

    private int xPos;
    private int yPos;
    private int height;
    private int width;
    private Color color;
    private Clip clip;

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

    public void setSoundFile(String soundFile) {
        try {
            File file = new File(soundFile);
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        } catch (Exception e) {

        }
    }

    public void play() {
        clip.setFramePosition(0);
        clip.start();
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
