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
    private Vector<EnemyTank> enemyTanks;

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

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

    /**
     * 判断敌方坦克是否碰撞
     * 写在这里主要是可以由坦克直接调用，直接去于其他的坦克进行比较
     */
    @SuppressWarnings({"all"})
    public boolean isOverlap() {

        //
        switch (getDirection()) {
            // up
            case 0:
                //
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //这里写入逻辑结构，能够防止自己与自己比较
                    if (enemyTank != this) {
                        //当主比较坦克为上时候，被比较坦克可为上/下，或左/右
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2) {
                            //被比较坦克为上下
                            if (getX() >= enemyTank.getX()
                                    && getX() <= enemyTank.getX() + 40
                                    && getY() >= enemyTank.getY()
                                    && getY() <= enemyTank.getY() + 60

                                    || getX() + 40 >= enemyTank.getX()
                                    && getX() + 40 <=enemyTank.getX() + 40
                                    && getY() >= enemyTank.getY()
                                    && getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3) {
                            //左右
                            if (getX() > enemyTank.getX()
                                    && getX() <= enemyTank.getX() + 60
                                    && getY() >= enemyTank.getY()
                                    && getY() <= enemyTank.getY() + 40

                                    || getX() + 40 >= enemyTank.getX()
                                    && getX() + 40 <= enemyTank.getX() + 60
                                    && getY() >= enemyTank.getY()
                                    && getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1:
                //右
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //这里写入逻辑结构，能够防止自己与自己比较
                    if (enemyTank != this) {
                        //当主比较坦克为上时候，被比较坦克可为上/下，或左/右
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2) {
                            //被比较坦克为上下
                            if (getX() + 60 >= enemyTank.getX()
                                    && getX() + 60 <= enemyTank.getX() + 40
                                    && getY() >=enemyTank.getY()
                                    && getY() <= enemyTank.getY() + 60

                                    || getX() + 60 >= enemyTank.getX()
                                    && getX() + 60 <= enemyTank.getX() + 40
                                    && getY() + 40 >= enemyTank.getY()
                                    && getY() + 40 <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3) {
                            //左右
                            if (getX() + 60 >=enemyTank.getX()
                                    && getX() + 60 <= enemyTank.getX() + 60
                                    && getY() >= enemyTank.getY()
                                    && getY() <= enemyTank.getY() + 40

                                    || getX() + 60 >= enemyTank.getX()
                                    && getX() + 60 <= enemyTank.getX() + 60
                                    && getY() + 40 >= enemyTank.getY()
                                    && getY() + 40 <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2:
                //下
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //这里写入逻辑结构，能够防止自己与自己比较
                    if (enemyTank != this) {
                        //当主比较坦克为上时候，被比较坦克可为上/下，或左/右
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2) {
                            //被比较坦克为上下
                            if (getX() >= enemyTank.getX()
                                    && getX() <=enemyTank.getX() + 40
                                    && getY() + 60 >= enemyTank.getY()
                                    && getY() + 60 <= enemyTank.getY() + 60

                                    || getX() + 40 >= enemyTank.getX()
                                    && getX() + 40 <= enemyTank.getX() + 40
                                    && getY() + 60 >= enemyTank.getY()
                                    && getY() + 60 <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3) {
                            //左右
                            if (getX() >= enemyTank.getX()
                                    && getX() <= enemyTank.getX() + 60
                                    && getY() + 60 >= enemyTank.getY()
                                    && getY() + 60 <= enemyTank.getY() + 40

                                    || getX() + 40 >= enemyTank.getX()
                                    && getX() + 40 <= enemyTank.getX() + 60
                                    && getY() + 60 >= enemyTank.getY()
                                    && getY() + 60 <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3:
                //左
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //这里写入逻辑结构，能够防止自己与自己比较
                    if (enemyTank != this) {
                        //当主比较坦克为上时候，被比较坦克可为上/下，或左/右
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2) {
                            //被比较坦克为上下
                            if (getX() >= enemyTank.getX()
                                    && getX() <= enemyTank.getX() + 40
                                    && getY() >= enemyTank.getY()
                                    && getY() <= enemyTank.getY() + 60

                                    || getX() >= enemyTank.getX()
                                    && getX() <= enemyTank.getX() + 40
                                    && getY() + 40 >= enemyTank.getY()
                                    && getY() + 40 <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3) {
                            //左右
                            if (getX() > enemyTank.getX()
                                    && getX() <= enemyTank.getX() + 60
                                    && getY() >= enemyTank.getY()
                                    && getY() <= enemyTank.getY() + 40

                                    || getX() >= enemyTank.getX()
                                    && getX() <= enemyTank.getX() + 60
                                    && getY() + 40 >= enemyTank.getY()
                                    && getY() + 40 <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }

                    }
                }
                break;
            default:
                System.out.println("-1");
        }
        return false;

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
                        if (getY() > 0 && !isOverlap()) {
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
                        if (getX() + 60 < 1000 && !isOverlap()) {
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
                        if (getY() + 60 < 750 && !isOverlap()) {
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
                        if (getX() > 0 && !isOverlap()) {
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

