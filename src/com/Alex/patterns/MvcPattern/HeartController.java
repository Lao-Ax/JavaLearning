package com.Alex.patterns.MvcPattern;

/**
 * Created by Alex on 02.05.2016 002.
 */
public class HeartController implements  ControllerInterface {
    HeartModelInterface model;
    DJView view;

    public HeartController(HeartModelInterface model) {
        this.model = model;
        view = new DJView(new HeartAdapter(model), this);
        view.createView();
//        view.createControls();
//        view.disableStopMenuItem();
//        view.disableStartMenuItem();
    }

    @Override
    public void start() {}

    @Override
    public void stop() {}

    @Override
    public void increaseBPM() {}

    @Override
    public void decreaseBPM() {}

    @Override
    public void setBPM(int bpm) {}
}
