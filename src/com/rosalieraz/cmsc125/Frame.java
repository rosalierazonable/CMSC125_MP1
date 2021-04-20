package com.rosalieraz.cmsc125;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Frame extends JFrame {

    Frame() {

        this.setVisible(true);
        this.setSize(500, 500);
        this.setTitle("Multiprogramming with Time-sharing");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0x12345));

//        ImageIcon bg = new ImageIcon("https://replit.com/@rsraz/Multiprogramming#uploads/background.jpg");
//        this.setIconImage(bg.getImage());
    }
}