package model;


public class Cell{
    private int x;
    private int y;
    private boolean visible = false;
    private int state;
    private int bombsAround;

    public Cell(int x, int y, int state, int bombsAround){
        this.x = x;
        this.y = y;
        this.state = state;
        this.bombsAround = bombsAround;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getState(){
        return this.state;
    }

    public boolean getVisible(){
        return this.visible;
    }

    public int getBombsAround(){
        return this.bombsAround;
    }

    public void setState(int i){
        this.state = i;
    }

    public void setBombsAround(int i){
        this.bombsAround = i;
    }

    public void setVisible(boolean x){
        this.visible = x;
    }
}