package com.Alex.patterns.ObserverPattern;

import com.Alex.patterns.ObserverPattern.Observer.*;
import com.Alex.patterns.ObserverPattern.Sensors.AbstractSensor;
import com.Alex.patterns.ObserverPattern.Sensors.HumiditySensor;
import com.Alex.patterns.ObserverPattern.Sensors.PressSensor;
import com.Alex.patterns.ObserverPattern.Sensors.TemperatureSensor;
import com.Alex.patterns.ObserverPattern.Subject.WeatherData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alex on 27.10.2015 027.
 */
public class MeteoThreadTest {

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<AbstractSensor> sensors = new ArrayList<AbstractSensor>();
        sensors.add(new TemperatureSensor());
        sensors.add(new HumiditySensor());
        sensors.add(new PressSensor());
        for (AbstractSensor as : sensors) {
            exec.execute(as);
        }

        WeatherData wd = new WeatherData(sensors.get(0), sensors.get(1), sensors.get(2));

        Observer csd = new CurrentStateDisplay(wd);
        Observer sd = new StatisticsDisplay(wd);
        Observer fd = new ForecastDisplay(wd);
        Observer hid = new HeatIndexDisplay(wd);
        for (int i = 0; i < 10; i++) {
            wd.measurementsChanged();
            TimeUnit.MILLISECONDS.sleep(300);
        }
        exec.shutdownNow();
    }
}
