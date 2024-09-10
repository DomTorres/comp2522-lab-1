package ca.bcit.comp2522.bank;

/**
 * This class represents a valid date.
 * @author Dom Torres
 * @version 1.0
 */
public class Date {
    private static final int FIRST_YEAR = 1800;
    private static final int CURRENT_YEAR = 2024;

    private static final int FIRST_MONTH = 1;
    private static final int LAST_MONTH = 12;

    private static final int FIRST_DAY = 1;
    private static int LAST_DAY;

    private final int year;
    private final int month;
    private final int day;

    /**
     * Date constructor.
     * @param year year
     * @param month month
     * @param day day
     */
    public Date(final int year, final int month, final int day) {
        validateDate(year, month, day);

        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Returns day (string) on which this date occurs on.
     * @return day of the week
     */
    public String getDayOfTheWeek() {
        /** Get last two digits of year */
        final int oneHundred = 100;
        int lastTwoDigitsOfYear;
        lastTwoDigitsOfYear = year % oneHundred;

        /** 1. Calculate number of twelves */
        final int twelve = 12;
        int step1;
        step1 = lastTwoDigitsOfYear / twelve;

        /** 2. Calculate remainder from step 1 */
        int step2;
        step2 = lastTwoDigitsOfYear - (step1 * twelve);

        /** 3. Calculate number of fours from step 2 */
        final int four = 4;
        int step3;
        step3 = step2 / four;

        /** 4. Add day of month */
        int step4;
        step4 = day;

        /** 5. Add month code */
        int step5;
        step5 = monthCode(month);

        /** 6. Add previous 5 numbers and mod by 7 */
        int number = step1 + step2 + step3 + step4 + step5;

        /** for January/February dates in leap years, add 6 at the start */
        final int six = 6;
        final int january = 1;
        final int february = 2;
        if ((month == january || month == february) && isLeapYear(year)) {
            number += six;
        }

        /** for all dates in the 2000s, add 6 at the start */
        final int year2000 = 2000;
        if (year >= year2000) {
            number += six;
        }

        /** for all dates in the 1800s, add 2 at the start */
        final int two = 2;
        final int year1800 = 1800;
        final int year1900 = 1900;
        if (year1800 <= year && year < year1900) {
            number += two;
        }

        final int daysInWeek = 7;
        return dayOfTheWeekToString(number % daysInWeek);
    }


    private static void validateDate(final int year, final int month, final int day) {
        validateYear(year);
        validateMonth(month);
        validateDay(year, month, day);
    }

    private static void validateYear(final int year) {
        if (!(FIRST_YEAR <= year && year <= CURRENT_YEAR)) {
            throw new IllegalArgumentException("Invalid year: " + year);
        }
    }

    private static void validateMonth(final int month) {
        if (!(FIRST_MONTH <= month && month <= LAST_MONTH)) {
            throw new IllegalArgumentException("Invalid month: " + month);
        }
    }

    private static void validateDay(final int year, final int month, final int day) {
        LAST_DAY = daysInMonth(month, isLeapYear(year));

        if(!(FIRST_DAY <= day && day <= LAST_DAY)) {
            throw new IllegalArgumentException("Invalid day: " + day);
        }
    }

    private static int daysInMonth(final int month, final boolean isLeapYear) {
        final int thirtyOne = 31;
        final int thirty = 30;
        final int twentyEight = 28;
        final int twentyNine = 29;

        switch (monthToString(month)) {
            case "january", "march", "may", "july", "august", "october", "december":
                return thirtyOne;
            case "april", "june", "september", "november":
                return thirty;
            case "february":
                if (isLeapYear) {
                    return twentyNine;
                } else {
                    return twentyEight;
                }
            default:
                return 0;
        }
    }

    private static boolean isLeapYear(final int year) {
        final int fourHundred = 400;
        final int oneHundred = 100;
        final int four = 4;

        if (year % fourHundred == 0) {
            return true;
        } else if (year % oneHundred == 0) {
            return false;
        } else {
            return year % four == 0;
        }
    }

    private static String dayOfTheWeekToString(final int day) {
        switch (day) {
            case 0: return "saturday";
            case 1: return "sunday";
            case 2: return "monday";
            case 3: return "tuesday";
            case 4: return "wednesday";
            case 5: return "thursday";
            case 6: return "friday";
            default: return "";
        }
    }

    private static String monthToString(final int month) {
        switch (month) {
            case 1: return "january";
            case 2: return "february";
            case 3: return "march";
            case 4: return "april";
            case 5: return "may";
            case 6: return "june";
            case 7: return "july";
            case 8: return "august";
            case 9: return "september";
            case 10: return "october";
            case 11: return "november";
            case 12: return "december";
            default: return "";
        }
    }

    private static int monthCode(final int month) {
        switch (month) {
            case 1: return 1;
            case 2: return 4;
            case 3: return 4;
            case 4: return 0;
            case 5: return 2;
            case 6: return 5;
            case 7: return 0;
            case 8: return 3;
            case 9: return 6;
            case 10: return 1;
            case 11: return 4;
            case 12: return 6;
            default: return -1;
        }
    }

    /**
     * Year getter.
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * Month getter.
     * @return month (number)
     */
    public int getMonth() {
        return month;
    }

    /**
     * Gets string representation of month.
     * @return month (string)
     */
    public String getMonthString() {
        return monthToString(this.getMonth());
    }

    /**
     * Day getter.
     * @return day
     */
    public int getDay() {
        return day;
    }

    /**
     * Returns string representation of date in YYYY-MM-DD format.
     * @return YYYY-MM-DD string
     */
    public String getYYYYMMDD() {
        return year + "-" + month + "-" + day;
    }

    /**
     * Returns string representation of date in Month DD, YYYY format.
     * @return Month DD, YYYY string
     */
    @Override
    public String toString() {
        String month = this.getMonthString();

        /** Capitalize first letter*/
        String formattedMonth = month.substring(0, 1).toUpperCase() + month.substring(1);

        return String.format("%s %d, %d", formattedMonth, this.getDay(), this.getYear());
    }
}
