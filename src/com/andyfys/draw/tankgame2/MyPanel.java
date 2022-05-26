package com.andyfys.draw.tankgame2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author Andyfys
 * @version 1.0
 */
public class MyPanel extends JPanel implements KeyListener, Runnable {
    MyTank myTank = null;

    Vector<EnemyTank> enemyTanks = new Vector<>();
    Vector<Bomb> bombs = new Vector<>();
    Vector<MyTank> myTanks = new Vector<>();
    int enemyTankSize = 4;
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel() {

        myTank = new MyTank(300, 300, 2);
        //myTanks.add(myTank);
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 2, 2);
//            Bullet bullet = new Bullet(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirection());
//            enemyTank.getVector().add(bullet);
//
//
//            new Thread(bullet).start();
            new Thread(enemyTank).start();
            enemyTanks.add(enemyTank);

        }
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);


        if(myTank.isState() && myTanks != null){
            drawTank(myTank.getX(), myTank.getY(), g, myTank.getType(), myTank.getDirection());
        }


        //绘制子弹，一开始做成了方法会有莫名奇妙的空指针异常，没有想清楚
        for (int i = 0; i < myTank.getVector().size(); i++) {
            Bullet bullet = myTank.getVector().get(i);
            if (bullet != null && bullet.isState()) {
                g.fill3DRect(bullet.getX(), bullet.getY(), 3, 3, false);
            } else {
                //当子弹的生命周期不在时，移除
                myTank.getVector().remove(bullet);
            }
        }


        //画出爆炸效果
        for (int i = 0; i < bombs.size(); i++) {

            Bomb bomb = bombs.get(i);
            if (bomb.getLifeRes() > 6) {
                g.drawImage(image1, bomb.getX(), bomb.getY(), 60, 60, this);
            } else if (i > 3) {
                g.drawImage(image2, bomb.getX(), bomb.getY(), 60, 60, this);
            } else {
                g.drawImage(image3, bomb.getX(), bomb.getY(), 60, 60, this);
            }
            bomb.lifeResReduce();
            if (bomb.getLifeRes() == 0) {
                bombs.remove(bomb);
            }
        }

        //绘出敌人坦克
        for (int i = 0; i < enemyTanks.size(); i++) {

            EnemyTank enemyTank = enemyTanks.get(i);
            if (enemyTank.isState()) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getType(), enemyTank.getDirection());
                //细节很重要，这里遍历的是我们敌人坦克中用于存放子弹的集合，所以这里设定的范围要是装有子弹的集合的尺寸！！！！
                //绘制敌人坦克子弹
                for (int j = 0; j < enemyTank.getVector().size(); j++) {
                    Bullet bullet = enemyTank.getVector().get(j);

                    if (bullet.isState()) {
                        g.fill3DRect(bullet.getX(), bullet.getY(), 3, 3, false);
                    } else {
                        /*手误删除了，导致后面敌方坦克不能在发射第一颗子弹后，再次填充坦克，也就是说如果没有这句话
                          会使得，原先的集合中为一个已经死亡的子弹，且由于集合已满导致无法再次新建子弹线程。
                        */
                        enemyTank.getVector().remove(bullet);
                    }
                }
            }

        }


    }

    public void drawTank(int x, int y, Graphics g, int type, int direction) {

            switch (type) {
                case 0:
                    g.setColor(Color.cyan);
                    break;
                case 1:
                    g.setColor(Color.yellow);
                    break;
                default:
                    System.out.println(-1);
            }
            switch (direction) {
                // UP
                case 0:
                    g.fill3DRect(x, y, 10, 60, false);
                    g.fill3DRect(x + 30, y, 10, 60, false);
                    g.fill3DRect(x + 10, y + 10, 20, 40, false);
                    g.fillOval(x + 10, y + 20, 20, 20);
                    g.drawLine(x + 20, y + 30, x + 20, y);
                    break;
                // RIGHT
                case 1:
                    g.fill3DRect(x, y, 60, 10, false);
                    g.fill3DRect(x, y + 30, 60, 10, false);
                    g.fill3DRect(x + 10, y + 10, 40, 20, false);
                    g.fillOval(x + 20, y + 10, 20, 20);
                    g.drawLine(x + 30, y + 20, x + 60, y + 20);
                    break;
                //DOWN
                case 2:
                    g.fill3DRect(x, y, 10, 60, false);
                    g.fill3DRect(x + 30, y, 10, 60, false);
                    g.fill3DRect(x + 10, y + 10, 20, 40, false);
                    g.fillOval(x + 10, y + 20, 20, 20);
                    g.drawLine(x + 20, y + 30, x + 20, y + 60);
                    break;
                case 3:
                    g.fill3DRect(x, y, 60, 10, false);
                    g.fill3DRect(x, y + 30, 60, 10, false);
                    g.fill3DRect(x + 10, y + 10, 40, 20, false);
                    g.fillOval(x + 20, y + 10, 20, 20);
                    g.drawLine(x + 30, y + 20, x, y + 20);
                    break;
                default:
                    System.out.println("输入非法");
            }
        }




    public void isHitEnemy(MyTank myTank) {
        for (int i = 0; i < myTank.getVector().size(); i++) {
            Bullet bullet = myTank.getVector().get(i);
            if (bullet != null && bullet.isState()) {
                for (int j = 0; j < enemyTanks.size(); j++) {
                    EnemyTank enemyTank = enemyTanks.get(j);
                    this.isHist(bullet, enemyTank);
                }

            }
        }

    }

    public void isHistMyTank() {
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            for (int j = 0; j < enemyTank.getVector().size(); j++) {
                Bullet bullet = enemyTank.getVector().get(j);
                if (myTank.isState() && bullet.isState()) {
                    isHist(bullet,myTank);
//                    switch (myTank.getDirection()) {
//                        case 0:
//                        case 2:
//
//                            if (enemyTanksBullet.get(i).getX() > myTank.getX() && enemyTanksBullet.get(i).getX() < myTank.getX() + 40
//                                    && enemyTanksBullet.get(i).getY() > myTank.getY() && enemyTanksBullet.get(i).getY() < myTank.getY() + 60) {
//                                enemyTanksBullet.get(i).setState(false);
//                                myTank.setState(false);
//                                bombs.add(new Bomb(myTank.getX(), myTank.getY()));
//                                myTanks.remove(myTank);
//                                //移除击中地方坦克的子弹
//                                myTank.getVector().remove(bullet);
//
//                            }
//
//                            break;
//                        case 1:
//                        case 3:
//
//                            if (enemyTanksBullet.get(i).getX() > myTank.getX() && enemyTanksBullet.get(i).getX() < myTank.getX() + 60
//                                    && enemyTanksBullet.get(i).getY() > myTank.getY() && enemyTanksBullet.get(i).getY() < myTank.getY() + 40) {
//                                bullet.setState(false);
//                                myTank.setState(false);
//                                bombs.add(new Bomb(myTank.getX(), myTank.getY()));
//                                myTanks.remove(myTank);
//                                myTank.getVector().remove(bullet);
//                            }
//
//
//                            break;
//                        default:
//                            System.out.println("-1");
//                            ;
//
//                    }
                }
            }

        }

    }

    public void isHist(Bullet bullet, Tank enemyTank) {
        switch (enemyTank.getDirection()) {
            case 0:
            case 2:
                if (bullet.getX() > enemyTank.getX() && bullet.getX() < enemyTank.getX() + 40
                        && bullet.getY() > enemyTank.getY() && bullet.getY() < enemyTank.getY() + 60) {
                    bullet.setState(false);
                    enemyTank.setState(false);
                    bombs.add(new Bomb(enemyTank.getX(), enemyTank.getY()));
                    enemyTanks.remove(enemyTank);
                    //移除击中地方坦克的子弹
                    myTank.getVector().remove(bullet);

                }
                break;
            case 1:
            case 3:
                if (bullet.getX() > enemyTank.getX() && bullet.getX() < enemyTank.getX() + 60
                        && bullet.getY() > enemyTank.getY() && bullet.getY() < enemyTank.getY() + 40) {
                    bullet.setState(false);
                    enemyTank.setState(false);
                    bombs.add(new Bomb(enemyTank.getX(), enemyTank.getY()));
                    enemyTanks.remove(enemyTank);
                    myTank.getVector().remove(bullet);
                }
                break;
            default:
                System.out.println("-1");
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            myTank.setDirection(0);
            if (myTank.getY() > 0) {
                myTank.moveUp();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            myTank.setDirection(1);
            if (myTank.getX() + 60 < 1000) {
                myTank.moveRight();
            }

        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            myTank.setDirection(2);
            if (myTank.getY() + 60 < 750) {
                myTank.moveDown();
            }

        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            myTank.setDirection(3);
            if (myTank.getX() > 0) {
                myTank.moveLeft();
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_J) {
//            if(myTank.bullet == null && myTank.bullet.isState() == false){
//                myTank.Shot();
//            }
            myTank.Shot();

        }


        this.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @SuppressWarnings({"all"})
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //遍历以获得多次isHist方法来进行判定
//            for (int i = 0; i < myTank.getVector().size(); i++) {
//                Bullet bullet = myTank.getVector().get(i);
//                if (bullet != null && bullet.isState()) {
//                    for (int j = 0; j < enemyTanks.size(); j++) {
//                        EnemyTank enemyTank = enemyTanks.get(j);
//                        this.isHist(bullet, enemyTank);
//                    }
//
//                }
//            }
            isHitEnemy(myTank);
            isHistMyTank();
            this.repaint();
        }

    }
}


