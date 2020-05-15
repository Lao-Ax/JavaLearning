package com.Alex.AWT_learning.Applets;

import java.applet.Applet;
import java.awt.*;

/**
 * Created by Alex on 28.10.2015 028.
 */
public class HelloApplet extends Applet {
    public void init() {
        add(new Label("Hello!"));
        start();
    }
}
