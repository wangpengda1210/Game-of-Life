package life;

public class Cell {

    private int positionX;
    private int positionY;
    private boolean alive;

    public Cell(int positionX, int positionY, boolean alive) {
        this.setPositionX(positionX);
        this.setPositionY(positionY);
        this.setAlive(alive);
    }


    public int getPositionX() {
        return positionX;
    }

    private void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    private void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public String toString() {
        return positionX + " " + positionY + " " + alive;
    }
}
