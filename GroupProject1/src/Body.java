public class Body {

    private char symbol = 's';
    private int xPos, yPos;
    private boolean isHit;

    public Body() {
        xPos = 0;
        yPos = 0;
        isHit = false;
    }

    public Body(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        isHit = false;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }
}
