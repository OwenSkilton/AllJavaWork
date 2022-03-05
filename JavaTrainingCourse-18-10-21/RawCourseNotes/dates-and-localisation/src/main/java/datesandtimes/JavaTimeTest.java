package datesandtimes;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;

public class JavaTimeTest {

    @Test
    public void testOldSchoolDates() {
        // Both of these classes have their issues:
        // e.g. Date months are indexed from 0
        // Niether Date nor Calendar instances are immutable
        var date = new Date();
        var calendar = new GregorianCalendar();
        System.out.println(date);
        System.out.println(calendar);
    }

    @Test
    public void testModernDates() {
        // All of the classes in the java.time produce immutable instances
        // CREATION
        var today = LocalDate.now();
        var magnaCarta = LocalDate.of(1215, 6, 15);

        // ARITHMETIC
        var twoWeeksFromNow = today.plusWeeks(2);
        var threeMonthsAgo = today.minusMonths(3);
        var someDateInTheFuture = today.plusYears(1).plusMonths(6).plusDays(10);

        // CALCULATING PERIODS
        var sinceMagnaCarta1 = magnaCarta.until(today);
        var sinceMagnaCarta2 = Period.between(magnaCarta, today);

        // FORMATTING
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(formatter.format(today));

        // PARSING
        var stringDate = "6/10/1977";
        var localDate = formatter.parse(stringDate);

        // CONVERT FROM OLD TO NEW
        var oldSchoolDate = new Date();
        var modernDate = oldSchoolDate.toInstant().atZone(ZoneId.systemDefault());
    }
}
