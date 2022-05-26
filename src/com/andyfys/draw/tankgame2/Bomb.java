package com.andyfys.draw.tankgame2;

/**
 * @author Andyfys
 * @version 1.0
 */
public class Bomb {
    private int x;
    private int y;
    private int lifeRes = 9;
    private boolean state = true;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLifeRes() {
        return lifeRes;
    }

    public void setLifeRes(int lifeRes) {
        this.lifeRes = lifeRes;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void lifeResReduce(){
        if(lifeRes > 0){
            lifeRes--;
        } else {
            state = false;
        }




    }
}
