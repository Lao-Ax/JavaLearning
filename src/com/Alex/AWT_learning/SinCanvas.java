package com.Alex.AWT_learning;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Alex on 25.10.2015 025.
 */
public class SinCanvas extends Canvas{

    @Override
    public void paint(Graphics g) {
        int height = getHeight(),
            width = getWidth();

        double k = 2 * Math.PI * 5 / width;
        int sy = calcY(0, width, height, k);

        for (int i = 1; i < width; i++) {
            int nsy = calcY(i, width, height, k);
            g.drawLine(i-1, sy, i, nsy);
            sy = nsy;
        }
    }

    private int calcY(int x, int width, int height, double k) {
        double dx = (x - width / 2.) * k;
        return (int) (height / 2. * (1 - Math.sin(dx)));
    }

    public static void main(String args[]) {
        final Frame f = new Frame("Draw");

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });

        f.setSize(400, 300);

        final Canvas c = new SinCanvas();

        f.add(c);
        f.setVisible(true);
    }
}
