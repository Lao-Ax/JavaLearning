package com.Alex.AWT_learning;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 25.10.2015 025.
 */
public class SaveButtonListener implements ActionListener{
    private Frame parent;

    public SaveButtonListener(Frame parentFrame) {
        parent = parentFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FileDialog fd = new FileDialog(parent, "Save file", FileDialog.SAVE);
        fd.setVisible(true);
        System.out.println(fd.getDirectory() + fd.getFile());
    }
}
