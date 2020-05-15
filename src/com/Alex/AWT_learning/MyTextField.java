package com.Alex.AWT_learning;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Alex on 25.10.2015 025.
 */
public class MyTextField {

    public static void main(String args[]) {
        final Frame f = new Frame("Draw");

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });

        f.setSize(400, 300);

        Container container = new Container();
        TextField tf = new TextField();
        tf.setText("Enter your name");
        tf.setBounds(10, 10, 150, 20);
        container.add(tf);

        f.add(container);
        f.setVisible(true);
    }
}
