package com.Alex.patterns.ObserverPattern.Version2;

import com.Alex.patterns.ObserverPattern.Version2.Observer.CurrentStateDisplay;
import com.Alex.patterns.ObserverPattern.Version2.Observer.ForecastDisplay;
import com.Alex.patterns.ObserverPattern.Version2.Observer.HeatIndexDisplay;
import com.Alex.patterns.ObserverPattern.Version2.Observer.StatisticsDisplay;
import com.Alex.patterns.ObserverPattern.Version2.Sensors.AbstractSensor;
import com.Alex.patterns.ObserverPattern.Version2.Sensors.HumiditySensor;
import com.Alex.patterns.ObserverPattern.Version2.Sensors.PressSensor;
import com.Alex.patterns.ObserverPattern.Version2.Sensors.TemperatureSensor;
import com.Alex.patterns.ObserverPattern.Version2.Subject.WeatherData;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
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
