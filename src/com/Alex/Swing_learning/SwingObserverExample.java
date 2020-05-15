package com.Alex.Swing_learning;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 30.10.2015 030.
 */
public class SwingObserverExample {
    JFrame frame;

    public static void main (String[] args) {
        SwingObserverExample example = new SwingObserverExample();
        example.go();
    }

    public void go(){
        frame = new JFrame();
        JButton button = new JButton("Should I do it?");
        button.addActionListener(new AngelListener());
        button.addActionListener(new DevilListener());
        frame.setSize(400, 300);
        frame.getContentPane().add(BorderLayout.CENTER, button);
        frame.setVisible(true);
    }

    class AngelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Don't do itm you might regret it.");
        }
    }

    class DevilListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Yes! Do it right now!");
        }
    }

}
