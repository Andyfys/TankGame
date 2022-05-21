package com.andyfys.draw;

import javax.swing.*;
import java.awt.*;

/**
 * @author Andyfys
 * @version 1.0
 */
public class JavaDrawTest extends JFrame{
    MyPanel mp = null;
    public static void main(String[] args) {
        new JavaDrawTest();
    }

    public JavaDrawTest() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400,400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyPanel  extends JPanel {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(0,0,100,100);
    }
}