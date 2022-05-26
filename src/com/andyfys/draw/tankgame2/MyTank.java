package com.andyfys.draw.tankgame2;

import java.util.Vector;

/**
 * @author Andyfys
 * @version 1.0
 */
public class MyTank extends Tank implements Runnable{
    Bullet bullet = null;
    private Vector<Bullet> vector = new Vector<>();
    private boolean state = true;

    public Bullet getBullet() {
        return bullet;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Vector<Bullet> getVector() {
        return vector;
    }

    public void setVector(Vector<Bullet> vector) {
        this.vector = vector;
    }

    public MyTank(int x, int y, int speed) {
        super(x, y, speed);
        setType(1);
    }

    public void Shot() {
        if(vector.size() == 5){
            return;
        }
        switch (getDirection()) {

            case 0:
                bullet = new Bullet(getX() + 20, getY(), getDirection());
                break;
            case 1:
                bullet = new Bullet(getX() + 60, getY() + 20, getDirection());
                break;
            case 2:
                bullet = new Bullet(getX() + 20, getY() + 60, getDirection());
                break;
            case 3:
                bullet = new Bullet(getX(), getY() + 20, getDirection());
                break;
            default:
                System.out.println("输入非法");
        }
        vector.add(bullet);
        Thread thread = new Thread(bullet);
        thread.start();
    }


    @Override
    public void run() {

    }
}
