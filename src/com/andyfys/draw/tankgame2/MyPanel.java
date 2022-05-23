package com.andyfys.draw.tankgame2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Andyfys
 * @version 1.0
 */
public class MyPanel extends JPanel implements KeyListener {
    MyTank myTank = null;


    public MyPanel() {

        myTank = new MyTank(100,100,2);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);
        drawTank(myTank.getX(), myTank.getY(), g, myTank.getType(), myTank.getDirection());


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


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            myTank.setDirection(0);
            myTank.move(0);
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            myTank.setDirection(1);
            myTank.move(1);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            myTank.setDirection(2);
            myTank.move(2);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            myTank.setDirection(3);
            myTank.move(3);
        }


        this.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}


