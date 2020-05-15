package com.Alex.AWT_learning;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Alex on 25.10.2015 025.
 */
public class TestCAnvas extends Canvas{

    public void paint(Graphics g){
        g.drawLine(0, 0, getWidth(), getHeight());
        g.drawLine(0, getHeight(), getWidth(), 0);
    }

    public static void main(String args[]){
        final Frame f = new Frame("Test freme");
        f.setSize(400, 300);

        f.add(new TestCAnvas());
        f.setVisible(true);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });
    }
}
