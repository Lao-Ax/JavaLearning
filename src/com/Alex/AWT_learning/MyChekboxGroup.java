package com.Alex.AWT_learning;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Alex on 25.10.2015 025.
 */
public class MyChekboxGroup {

    public static void main(String args[]) {
        final Frame f = new Frame("Draw");

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });

        f.setSize(400, 300);

        CheckboxGroup delivery = new CheckboxGroup();

        Checkbox fast = new Checkbox("Срочная (1 день)", delivery, true);
        fast.setBounds(10, 50, 150, 20);
        f.add(fast);

        Checkbox normal = new Checkbox("Обычная (1 неделя)", delivery, false);
        normal.setBounds(10, 80, 150, 20);
        f.add(normal);

        Checkbox postal = new Checkbox("Почтой (1 месяц)", delivery, false);
        postal.setBounds(10, 110, 150, 20);
        f.add(postal);
        f.add(new Checkbox()).setVisible(false);


        f.setVisible(true);
    }


}
