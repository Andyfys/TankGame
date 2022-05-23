package com.andyfys.draw.tankgame;

import javax.swing.*;

/**
 * @author Andyfys
 * @version 1.0
 */
public class MyFrame extends JFrame {

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
    }
    MyPanel myPanel = null;
    public MyFrame (){
        myPanel = new MyPanel();
        this.add(myPanel);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
