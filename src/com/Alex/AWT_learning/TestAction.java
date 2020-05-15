package com.Alex.AWT_learning;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Alex on 25.10.2015 025.
 */
public class TestAction {

    public static void main(String args[]){
        final Frame f = new Frame("Test freme");
        f.setSize(400, 300);

        Panel p = new Panel();
        f.add(p);

        Button save = new Button("save");
        save.addActionListener(new SaveButtonListener(f));
        p.add(save);

        f.setVisible(true);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });
    }
}
