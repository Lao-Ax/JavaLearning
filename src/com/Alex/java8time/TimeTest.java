package com.Alex.java8time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Alex on 26.03.2017 026.
 */
public class TimeTest {
    public static void main(String[] args) {
        /**Clock
         Тип Clock предоставляет доступ к текущей дате и времени. Этот тип знает о часовых поясах и может
         использоваться вместо вызова System.currentTimeMillis() для возвращения миллисекунд.
         Такая точная дата также может быть представлена классом Instant. Объекты этого класса могут быть
         использованы для создания объектов устаревшего типа java.util.Date.
         */

        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();

        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);   // legacy java.util.Date

        /**
         LocalDate
         Тип LocalDate представляет конкретную дату, например, 2014-03-11. Объекты LocalDate неизменяемы.
         Пример демонстрирует вычисление новой даты путем сложения или вычитания дней, месяцев
         или годов. Помните, что каждая операция возвращает новый экземпляр.
         */

        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(2);

        LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println(dayOfWeek);    // FRIDAY

        /**
         Создание экземпляра LocalDate путем парсинга строки:
         */

        DateTimeFormatter germanFormatter =
                DateTimeFormatter
                        .ofLocalizedDate(FormatStyle.MEDIUM)
                        .withLocale(Locale.GERMAN);

        LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter);
        System.out.println(xmas);   // 2014-12-24


        DateTimeFormatter formatter =
                DateTimeFormatter
                        .ofPattern("MMM dd, yyyy - HH:mm");

        LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter);
        System.out.println(parsed);
        String string = formatter.format(parsed);
        System.out.println(string);     // Nov 03, 2014 - 07:13
    }
}
