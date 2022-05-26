package com.andyfys.draw.tankgame2;

import java.util.Vector;

/**
 * @author Andyfys
 * @version 1.0
 * 敌人坦克自由移动：
 * 首先采取线程的方式，在每次创建敌人坦克的时候，都去产生一个线程，并且启动
 * <p>
 * 敌人坦克，要做成线程才能去自由的移动
 * 线程后自由移动逻辑 ： 在run方法中调用move方法，其move方法输入为一个【0，3】
 * 的随机数
 */
public class EnemyTank extends Tank implements Runnable {


    private Vector<Bullet> vector = new Vector<>();
    private boolean state = true;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public EnemyTank(int x, int y, int speed) {
        super(x, y, speed);
        setType(0);
        setDirection(2);
    }

    public Vector<Bullet> getVector() {
        return vector;
    }

    public void setVector(Vector<Bullet> vector) {
        this.vector = vector;
    }

    @Override
    public void run() {
        while (true) {
            if (isState() && getVector().size() == 0) {
                Bullet bullet = null;
                switch (getDirection()) {
                    case 0:
                        bullet = new Bullet(getX() + 20, getY(), 0);
                        break;
                    case 1:
                        bullet = new Bullet(getX() + 60, getY() + 20, 1);
                        break;
                    case 2:
                        bullet = new Bullet(getX() + 20, getY() + 60, 2);
                        break;
                    case 3:
                        bullet = new Bullet(getX(), getY() + 20, 3);
                        break;
                    default:
                        System.out.println("-1");
                }
                getVector().add(bullet);
                new Thread(bullet).start();
            }

            switch (getDirection()) {
                case 0:
                    for (int i = 0; i < 20; i++) {
                        if (getY() > 0) {
                            moveUp();
                        }

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case 1:
                    for (int i = 0; i < 20; i++) {
                        if (getX() + 60 < 1000) {
                            moveRight();
                        }

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 20; i++) {
                        if (getY() + 60 < 750) {
                            moveDown();
                        }

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 20; i++) {
                        if (getX() > 0) {
                            moveLeft();
                        }

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                default:
                    return;
            }
            setDirection((int) (Math.random() * 4));


            if (isState() == false) {
                break;
            }

            if (!isState()) {
                break;
            }
        }


    }

}

