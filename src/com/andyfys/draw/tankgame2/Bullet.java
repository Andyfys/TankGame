package com.andyfys.draw.tankgame2;

/**
 * @author Andyfys
 * @version 1.0
 */
public class Bullet implements Runnable {
    private int x;
    private int y;
    private int direct;
    private int speed = 3;
    private boolean state = true;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public Bullet(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

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



    @Override
    public void run() {
        boolean loop = true;
        while (loop) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch (direct) {
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
                default:
                    System.out.println("不合法");
            }
//            System.out.println("子弹\tx:\t" + x + "\ty:" + y);
            //这里的条件没有想清楚
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isState())) {
                System.out.println("子弹线程结束");
                setState(false);
                loop = false;
            }
        }


    }
}
