package com.Alex.AWT_learning;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Alex on 25.10.2015 025.
 */
public class MyList_Choice {

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

        Choice color = new Choice();
        color.add("White");
        color.add("Black");
        color.add("Green");
        color.setBounds(10, 10, 150, 20);

        container.add(color);

        List accessories = new List(3);
        accessories.add("Item 1");
        accessories.add("Item 2");
        accessories.add("Item 3");
        accessories.add("Item 4");
        accessories.setBounds(10, 50, 150, 50);

        container.add(accessories);

        f.add(container);
        f.setVisible(true);
    }
}
