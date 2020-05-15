package com.Alex.AWT_learning;

import java.awt.*;
import java.awt.event.*;

public class DrawCanvas extends Canvas {

    private int lastX, lastY;
    private int ex, ey;
    private boolean clear = false;

    public DrawCanvas() {
        super();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lastX = e.getX();
                lastY = e.getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                ex = e.getX();
                ey = e.getY();
                repaint();
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == ' ') {
                    clear = true;
                    repaint();
                }
            }
        });
    }

    @Override
    public void update(Graphics g) {
        if (clear) {
            g.clearRect(0, 0, getWidth(), getHeight());
            clear = false;
        } else {

            g.drawLine(lastX, lastY, ex, ey);
            lastX = ex;
            lastY = ey;
        }
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

        final Canvas c = new DrawCanvas();
        //c.setEnabled(false);
        c.setBackground(Color.BLACK);
        c.setForeground(Color.BLUE);

        f.add(c);
        f.setVisible(true);
    }
}
