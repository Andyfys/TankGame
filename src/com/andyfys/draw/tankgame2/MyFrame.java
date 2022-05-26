package com.andyfys.draw.tankgame2;

import javax.swing.*;

/**
 * @author Andyfysw
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
        this.addKeyListener(myPanel);
        this.setSize(1080,900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        //这里没有想到利用线程来处理
        Thread thread = new Thread(myPanel);
        thread.start();
    }
}
