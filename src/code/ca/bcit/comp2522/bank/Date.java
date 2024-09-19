package ca.bcit.comp2522.bank;

/**
 * This class represents a valid date.
 *
 * @author Dom Torres
 * @version 1.0
 */
public class Date
{
    private static final int JANUARY    = 1;
    private static final int FEBRUARY   = 2;
    private static final int MARCH      = 3;
    private static final int APRIL      = 4;
    private static final int MAY        = 5;
    private static final int JUNE       = 6;
    private static final int JULY       = 7;
    private static final int AUGUST     = 8;
    private static final int SEPTEMBER  = 9;
    private static final int OCTOBER    = 10;
    private static final int NOVEMBER   = 11;
    private static final int DECEMBER   = 12;

    private static final int SATURDAY   = 0;
    private static final int SUNDAY     = 1;
    private static final int MONDAY     = 2;
    private static final int TUESDAY    = 3;
    private static final int WEDNESDAY  = 4;
    private static final int THURSDAY   = 5;
    private static final int FRIDAY     = 6;

    private static final int FIRST_YEAR = 1800;
    private static int currentYear      = 2024;

    private static final int FIRST_MONTH    = 1;
    private static final int LAST_MONTH     = 12;

    private static final int FIRST_DAY = 1;
    private static int lastDay;

    private static final String MONTH_CODES = "144025036146";

    private final int year;
    private final int month;
    private final int day;

    /**
     * Date constructor.
     *
     * @param year  year
     * @param month month
     * @param day   day
     */
    public Date(
            final int year,
            final int month,
            final int day)
    {
        validateDate(year, month, day);

        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * To get the day of the week, do the following seven steps for dates in the 1900s:
     * e.g. October 31 1977:
     * step 1: calculate the number of twelves in 77:
     * 6
     * step 2: calculate the remainder from step 1: 77 - 12*6 = 77 - 72 =
     * 5
     * step 3: calculate the number of fours in step 2: 5/4 = 1.25, so
     * 1
     * step 4: add the day of the month to each step above: 31 + 6 + 5 + 1 =
     * 43
     * step 5: add the month code (for jfmamjjasond: 144025036146): for october it is 1: 43 + 1 =
     * 44
     * step 6: add the previous five numbers: (44) and mod by 7: 44%7 = 2 (44/7 = 6 remainder 2)
     * step 7: sat sun mon tue wed thu fri is 0 1 2 3 4 5 6; our 2 means Oct 31 1977 was monday
     *
     * @return day of the week
     */
    public String getDayOfTheWeek()
    {
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

        final boolean isYearALeapYear;
        isYearALeapYear = isLeapYear(year);

        if((month == JANUARY || month == FEBRUARY) && isYearALeapYear)
        {
            number += six;
        }

        /** for all dates in the 2000s, add 6 at the start */
        final int year2000;
        year2000 = 2000;

        if(year >= year2000)
        {
            number += six;
        }

        /** for all dates in the 1800s, add 2 at the start */
        final int two;
        two = 2;

        final int year1800;
        year1800 = 1800;

        final int year1900;
        year1900 = 1900;

        if(year1800 <= year && year < year1900)
        {
            number += two;
        }

        final int daysInWeek = 7;
        return dayOfTheWeekToString(number % daysInWeek);
    }

    /**
     * This function validates the date by calling respective validator methods
     *
     * @param year
     * @param month
     * @param day
     */
    private static void validateDate(final int year, final int month, final int day)
    {
        validateYear(year);
        validateMonth(month);
        validateDay(year, month, day);
    }

    /**
     * This function validates the year by checking if FIRST_YEAR <= year <= currentYear.
     *
     * @param year year
     * @throws IllegalArgumentException if year invalid
     */
    private static void validateYear(final int year)
            throws IllegalArgumentException
    {
        if(!(FIRST_YEAR <= year && year <= currentYear))
        {
            throw new IllegalArgumentException("Invalid year: " + year);
        }
    }

    /**
     * This function validates the year by checking if FIRST_MONTH <= year <= CURRENT_MONTH.
     *
     * @param month month
     * @throws IllegalArgumentException if month invalid
     */
    private static void validateMonth(final int month)
            throws IllegalArgumentException
    {
        if(!(FIRST_MONTH <= month && month <= LAST_MONTH))
        {
            throw new IllegalArgumentException("Invalid month: " + month);
        }
    }

    /**
     * This function validates the day by getting the lastDay for specific month,
     * then checking if FIRST_DAY <= day <= lastDay.
     *
     * @param day day
     * @throws IllegalArgumentException if day invalid
     */
    private static void validateDay(final int year, final int month, final int day)
            throws IllegalArgumentException
    {
        lastDay = daysInMonth(month, isLeapYear(year));

        if(!(FIRST_DAY <= day && day <= lastDay))
        {
            throw new IllegalArgumentException("Invalid day: " + day);
        }
    }

    /**
     * This function returns the number of days in a month.
     *
     * @param month      month
     * @param isLeapYear if leap year
     * @return number of days in month
     */
    private static int daysInMonth(final int month, final boolean isLeapYear)
    {
        final int thirtyOneDaysInMonth;
        thirtyOneDaysInMonth = 31;

        final int thirtyDaysInMonth;
        thirtyDaysInMonth = 30;

        final int twentyEightDaysInMonth;
        twentyEightDaysInMonth = 28;

        final int twentyNineDaysInMonth;
        twentyNineDaysInMonth = 29;

        switch(monthToString(month))
        {
            case "january", "march", "may", "july", "august", "october", "december":
                return thirtyOneDaysInMonth;
            case "april", "june", "september", "november":
                return thirtyDaysInMonth;
            case "february":
                if(isLeapYear)
                {
                    return twentyNineDaysInMonth;
                }
                else
                {
                    return twentyEightDaysInMonth;
                }
            default:
                return 0;
        }
    }

    /**
     * This function determines if a year is a leap year.
     *
     * @param year year
     * @return if leap year
     */
    private static boolean isLeapYear(final int year)
    {
        final int fourHundredYears;
        fourHundredYears = 400;

        final int oneHundredYears;
        oneHundredYears = 100;

        final int fourYears;
        fourYears = 4;

        final int no_remainder;
        no_remainder = 0;

        if(year % fourHundredYears == no_remainder)
        {
            return true;
        }
        else if(year % oneHundredYears == no_remainder)
        {
            return false;
        }
        else
        {
            return year % fourYears == no_remainder;
        }
    }

    /**
     * This function converts the day number to a String.
     *
     * @param day day
     * @return day (String)
     */
    private static String dayOfTheWeekToString(final int day)
    {
        switch(day)
        {
            case SATURDAY:
                return "saturday";
            case SUNDAY:
                return "sunday";
            case MONDAY:
                return "monday";
            case TUESDAY:
                return "tuesday";
            case WEDNESDAY:
                return "wednesday";
            case THURSDAY:
                return "thursday";
            case FRIDAY:
                return "friday";
            default:
                return "invalid day";
        }
    }

    /**
     * This function converts the months number to a String.
     *
     * @param month month
     * @return month (month)
     */
    private static String monthToString(final int month)
    {
        switch(month)
        {
            case JANUARY:
                return "january";
            case FEBRUARY:
                return "february";
            case MARCH:
                return "march";
            case APRIL:
                return "april";
            case MAY:
                return "may";
            case JUNE:
                return "june";
            case JULY:
                return "july";
            case AUGUST:
                return "august";
            case SEPTEMBER:
                return "september";
            case OCTOBER:
                return "october";
            case NOVEMBER:
                return "november";
            case DECEMBER:
                return "december";
            default:
                return "invalid month";
        }
    }

    /**
     * This function returns the month code for a month.
     *
     * @param month month
     * @return month code
     */
    private static int monthCode(final int month)
    {
        final int oneIndex;
        oneIndex = 1;

        final String monthCode;
        monthCode = MONTH_CODES.substring(month - oneIndex, month);

        return Integer.valueOf(monthCode);
    }

    /**
     * Year getter.
     *
     * @return year
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Month getter.
     *
     * @return month (number)
     */
    public int getMonth()
    {
        return month;
    }

    /**
     * Gets string representation of month.
     *
     * @return month (string)
     */
    public String getMonthString()
    {
        return monthToString(this.getMonth());
    }

    /**
     * Day getter.
     *
     * @return day
     */
    public int getDay()
    {
        return day;
    }

    /**
     * Returns string representation of date in YYYY-MM-DD format.
     *
     * @return YYYY-MM-DD string
     */
    public String getYYYYMMDD()
    {
        return year + "-" + month + "-" + day;
    }

    /**
     * Returns string representation of date in Month DD, YYYY format.
     *
     * @return Month DD, YYYY string
     */
    @Override
    public String toString()
    {
        String monthString;
        monthString = this.getMonthString();

        /** Capitalize first letter*/
        final int zeroIndex;
        zeroIndex = 0;

        final int oneIndex;
        oneIndex = 1;

        String formattedMonth = monthString.substring(zeroIndex, oneIndex).toUpperCase() +
                                monthString.substring(oneIndex);

        return String.format("%s %d, %d", formattedMonth, this.getDay(), this.getYear());
    }

    /**
     * Returns string representation of date in day, Month DD, YYYY format.
     *
     * @return day, Month DD, YYYY string
     */
    public String getDayAndDateString()
    {
        return String.format("%s, %s", getDayOfTheWeek(), toString());
    }
}
