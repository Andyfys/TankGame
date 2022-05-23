package com.andyfys.draw.drawball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Andyfys
 * @version 1.0
 */
public class DrawBall extends JFrame {
    public static void main(String[] args) {
        DrawBall drawBall = new DrawBall();
    }
    MyPanel myPanel = null;

    public DrawBall(){
        myPanel = new MyPanel();
        this.add(myPanel);
        this.setSize(1000,1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(myPanel);
    }
}

class MyPanel extends JPanel implements KeyListener {
    int positionX = 100;
    int positionY = 100;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(positionX,positionY,10,10);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            positionY--;
        } else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            positionY++;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            positionX--;
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            positionX++;
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}