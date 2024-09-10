package ca.bcit.comp2522.bank;

/**
 * This class represents a valid date.
 * @author Dom Torres
 * @version 1.0
 */
public class Date {
    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int MARCH = 3;
    private static final int APRIL = 4;
    private static final int MAY = 5;
    private static final int JUNE = 6;
    private static final int JULY = 7;
    private static final int AUGUST = 8;
    private static final int SEPTEMBER = 9;
    private static final int OCTOBER = 10;
    private static final int NOVEMBER = 11;
    private static final int DECEMBER = 12;

    private static final int SATURDAY = 0;
    private static final int SUNDAY = 1;
    private static final int MONDAY = 2;
    private static final int TUESDAY = 3;
    private static final int WEDNESDAY = 4;
    private static final int THURSDAY = 5;
    private static final int FRIDAY = 6;

    private static final int FIRST_YEAR = 1800;
    private static final int CURRENT_YEAR = 2024;

    private static final int FIRST_MONTH = 1;
    private static final int LAST_MONTH = 12;

    private static final int FIRST_DAY = 1;
    private static int LAST_DAY;

    public static final Date DEFAULT_DATE = null;

    private static final String MONTH_CODES = "144025036146";

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
        final int oneHundred;
        oneHundred = 100;

        int lastTwoDigitsOfYear;
        lastTwoDigitsOfYear = year % oneHundred;

        /** 1. Calculate number of twelves */
        final int twelve;
        twelve = 12;

        int step1;
        step1 = lastTwoDigitsOfYear / twelve;

        /** 2. Calculate remainder from step 1 */
        int step2;
        step2 = lastTwoDigitsOfYear - (step1 * twelve);

        /** 3. Calculate number of fours from step 2 */
        final int four;
        four = 4;

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
        final int six;
        six = 6;

        if ((month == JANUARY || month == FEBRUARY) && isLeapYear(year)) {
            number += six;
        }

        /** for all dates in the 2000s, add 6 at the start */
        final int year2000;
        year2000 = 2000;

        if (year >= year2000) {
            number += six;
        }

        /** for all dates in the 1800s, add 2 at the start */
        final int two;
        two = 2;

        final int year1800;
        year1800 = 1800;

        final int year1900;
        year1900 = 1900;

        if (year1800 <= year && year < year1900) {
            number += two;
        }

        final int daysInWeek = 7;
        return dayOfTheWeekToString(number % daysInWeek);
    }

    /**
     * This function validates the date by calling respective validator methods
     * @param year
     * @param month
     * @param day
     */
    private static void validateDate(final int year, final int month, final int day) {
        validateYear(year);
        validateMonth(month);
        validateDay(year, month, day);
    }

    /**
     * This function validates the year by checking if FIRST_YEAR <= year <= CURRENT_YEAR.
     * @param year year
     * @throws IllegalArgumentException if year invalid
     */
    private static void validateYear(final int year) {
        if (!(FIRST_YEAR <= year && year <= CURRENT_YEAR)) {
            throw new IllegalArgumentException("Invalid year: " + year);
        }
    }

    /**
     * This function validates the year by checking if FIRST_MONTH <= year <= CURRENT_MONTH.
     * @param month month
     * @throws IllegalArgumentException if month invalid
     */
    private static void validateMonth(final int month) {
        if (!(FIRST_MONTH <= month && month <= LAST_MONTH)) {
            throw new IllegalArgumentException("Invalid month: " + month);
        }
    }

    /**
     * This function validates the day by getting the LAST_DAY for specific month, then checking if FIRST_DAY <= day <= LAST_DAY.
     * @param day day
     * @throws IllegalArgumentException if day invalid
     */
    private static void validateDay(final int year, final int month, final int day) {
        LAST_DAY = daysInMonth(month, isLeapYear(year));

        if(!(FIRST_DAY <= day && day <= LAST_DAY)) {
            throw new IllegalArgumentException("Invalid day: " + day);
        }
    }

    /**
     * This function returns the number of days in a month.
     * @param month month
     * @param isLeapYear if leap year
     * @return number of days in month
     */
    private static int daysInMonth(final int month, final boolean isLeapYear) {
        final int thirtyOneDays;
        thirtyOneDays = 31;

        final int thirtyDays;
        thirtyDays = 30;

        final int twentyEightDays;
        twentyEightDays = 28;

        final int twentyNineDays;
        twentyNineDays = 29;

        switch (monthToString(month)) {
            case "january", "march", "may", "july", "august", "october", "december":
                return thirtyOneDays;
            case "april", "june", "september", "november":
                return thirtyDays;
            case "february":
                if (isLeapYear) {
                    return twentyNineDays;
                } else {
                    return twentyEightDays;
                }
            default:
                return 0;
        }
    }

    /**
     * This function determines if a year is a leap year.
     * @param year year
     * @return if leap year
     */
    private static boolean isLeapYear(final int year) {
        final int fourHundredYears;
        fourHundredYears = 400;

        final int oneHundredYears;
        oneHundredYears = 100;

        final int fourYears;
        fourYears = 4;

        if (year % fourHundredYears == 0) {
            return true;
        } else if (year % oneHundredYears == 0) {
            return false;
        } else {
            return year % fourYears == 0;
        }
    }

    /**
     * This function converts the day number to a String.
     * @param day day
     * @return day (String)
     */
    private static String dayOfTheWeekToString(final int day) {
        switch (day) {
            case SATURDAY: return "saturday";
            case SUNDAY: return "sunday";
            case MONDAY: return "monday";
            case TUESDAY: return "tuesday";
            case WEDNESDAY: return "wednesday";
            case THURSDAY: return "thursday";
            case FRIDAY: return "friday";
            default: return "invalid day";
        }
    }

    /**
     * This function converts the months number to a String.
     * @param month month
     * @return month (month)
     */
    private static String monthToString(final int month) {
        switch (month) {
            case JANUARY: return "january";
            case FEBRUARY: return "february";
            case MARCH: return "march";
            case APRIL: return "april";
            case MAY: return "may";
            case JUNE: return "june";
            case JULY: return "july";
            case AUGUST: return "august";
            case SEPTEMBER: return "september";
            case OCTOBER: return "october";
            case NOVEMBER: return "november";
            case DECEMBER: return "december";
            default: return "invalid month";
        }
    }

    /**
     * This function returns the month code for a month.
     * @param month month
     * @return month code
     */
    private static int monthCode(final int month) {
        final int one;
        one = 1;

        return Integer.valueOf(MONTH_CODES.substring(month - one, month));
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
        final int zero;
        zero = 0;

        final int one;
        one = 1;

        String formattedMonth = month.substring(zero, one).toUpperCase() + month.substring(1);

        return String.format("%s %d, %d", formattedMonth, this.getDay(), this.getYear());
    }
}
