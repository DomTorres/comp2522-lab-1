package ca.bcit.comp2522.bank;

/**
 * This Name class represents a person's name, consisting of a first name,
 * and last name. It provides methods to access and utilities for generating
 * formatted representations of the name.
 *
 * @author John and Dom
 * @version 1.0
 */
public class Name
{
    public final int ZERO_INDEX = 0;
    public final int ONE_INDEX = 1;

    private final String firstName;
    private final String lastName;

    // Maximum length of Name
    private static final int MAX_NAME_LENGTH = 45;

    /**
     * This is the Name Constructor that validates and initializes
     * the firstName and lastName.
     *
     * @param firstName is the first name
     * @param lastName  is the last name
     */
    public Name(final String firstName,
                final String lastName)
    {
        validateFirstName(firstName);
        validateLastName(lastName);

        this.firstName = firstName;
        this.lastName = lastName;
    }

    /*
     * Validates the First Name. It cannot be null, blank, or "admin".
     * Must be less than the maximum name length
     * @param firstName is the first name
     */
    private static void validateFirstName(final String firstName)
    {
        if(firstName == null)
        {
            throw new IllegalArgumentException("firstName is null");
        }

        final boolean firstNameIsBlank;
        final boolean firstNameLongerThanMax;
        final boolean firstNameContainsAdmin;

        firstNameIsBlank = firstName.isBlank();
        firstNameLongerThanMax = firstName.length() >= MAX_NAME_LENGTH;
        firstNameContainsAdmin = firstName.toLowerCase().contains("admin");

        if(firstNameIsBlank || firstNameLongerThanMax || firstNameContainsAdmin)
        {
            throw new IllegalArgumentException("Invalid First Name: " + firstName);
        }
    }

    /*
     * Validates the Last Name. Cannot be null, blank, or "admin".
     * Must be less than the maximum name length.
     * @param lastName is the last name
     * */
    private static void validateLastName(final String lastName)
    {
        if(lastName == null)
        {
            throw new IllegalArgumentException("lastName is null");
        }

        final boolean lastNameIsBlank;
        final boolean lastNameLongerThanMax;
        final boolean lastNameContainsAdmin;

        lastNameIsBlank = lastName.isBlank();
        lastNameLongerThanMax = lastName.length() >= MAX_NAME_LENGTH;
        lastNameContainsAdmin = lastName.toLowerCase().contains("admin");

        if(lastNameIsBlank || lastNameLongerThanMax || lastNameContainsAdmin)
        {
            throw new IllegalArgumentException("Invalid Last Name: " + lastName);
        }
    }

    /**
     * Returns the first name.
     *
     * @return the first name
     */
    public String getFirst()
    {
        return firstName;
    }

    /**
     * Returns the last name.
     *
     * @return the last name
     */
    public String getLast()
    {
        return lastName;
    }

    /**
     * Returns the initials of the full name.
     * The Initials are capitalized and separated by a period.
     *
     * @return the initials of the full name
     */
    public String getInitials()
    {
        final String firstNameInitial;
        final String lastNameInitial;
        final String initials;

        firstNameInitial = firstName.substring(ZERO_INDEX, ONE_INDEX).toUpperCase();
        lastNameInitial = lastName.substring(ZERO_INDEX, ONE_INDEX).toUpperCase();
        initials = firstNameInitial + "." + lastNameInitial + ".";

        return initials;
    }

    /**
     * Returns the full name with the first letter of the first and last name capitalized and the rest lower case.
     *
     * @return the full name
     */
    public String getFullName()
    {
        final String formattedFirstName;
        final String formattedLastName;
        final String formattedFullName;

        formattedFirstName =
                firstName.substring(ZERO_INDEX, ONE_INDEX).toUpperCase() +
                        firstName.substring(ONE_INDEX).toLowerCase();

        formattedLastName =
                lastName.substring(ZERO_INDEX, ONE_INDEX).toUpperCase() +
                        lastName.substring(ONE_INDEX).toLowerCase();

        formattedFullName = formattedFirstName + " " + formattedLastName;

        return formattedFullName;
    }

    /**
     * Returns the full name in reverse order.
     *
     * @return the full name in reverse order.
     */
    public String getReverseName()
    {
        final StringBuilder reverseFirst;
        final StringBuilder reverseLast;
        final String reverseFullName;

        reverseFirst = new StringBuilder();
        reverseLast = new StringBuilder();

        for(int i = firstName.length() - ONE_INDEX; i >= ZERO_INDEX; i--)
        {
            reverseFirst.append(firstName.charAt(i));
        }

        for(int i = lastName.length() - ONE_INDEX; i >= ZERO_INDEX; i--)
        {
            reverseLast.append(lastName.charAt(i));
        }

        reverseFullName = reverseLast + " " + reverseFirst;

        return reverseFullName;
    }
}
