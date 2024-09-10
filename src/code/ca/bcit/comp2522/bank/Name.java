package ca.bcit.comp2522.bank;

/**
 * This Name class represents a person's name, consisting of a first name,
 * and last name. It provides methods to access and utilities for generating
 * formatted representations of the name.
 *
 * @author John and Dom
 * @version 1.0
 */
public class Name {

    public final int ZERO = 0;
    public final int ONE = 1;

    private final String firstName;
    private final String lastName;

    private static final int MAX_NAME_LENGTH = 45;

    /**
     * This is the Name Constructor that validates and initializes
     * the firstName and lastName.
     * @param firstName is a String
     * @param lastName is a String
     */
    public Name(final String firstName, final String lastName)
    {
        validateFirstName(firstName);
        validateLastName(lastName);

        this.firstName = firstName;
        this.lastName = lastName;
    }

    private static void validateFirstName(final String firstName)
    {
        if (firstName == null || firstName.isBlank() || firstName.length() >= MAX_NAME_LENGTH || firstName.toLowerCase().contains("admin"))
        {
            throw new IllegalArgumentException("Invalid First Name: " + firstName);
        }
    }

    private static void validateLastName(final String lastName)
    {
        if (lastName == null || lastName.isBlank() || lastName.length() >= MAX_NAME_LENGTH || lastName.toLowerCase().contains("admin"))
        {
            throw new IllegalArgumentException("Invalid Last Name: " + lastName);
        }
    }

    /**
     * Returns the first name.
     * @return the first name
     */
    public String getFirst()
    {
        return firstName;
    }

    /**
     * Returns the last name.
     * @return the last name
     */
    public String getLast()
    {
        return lastName;
    }

    /**
     * Returns the initials of the full name.
     * The Initials are capitalized and separated by a period.
     * @return the initials of the full name
     */
    public String getInitials()
    {
        return firstName.substring(ZERO, ONE).toUpperCase() + "." + lastName.substring(ZERO, ONE).toUpperCase() + ".";
    }

    /**
     * Returns the full name with the first letter of the first and last name capitalized and the rest lower case.
     * @return the full name
     */
    public String getFullName()
    {
        return firstName.substring(ZERO, ONE).toUpperCase() + firstName.substring(ONE).toLowerCase() + " "
                + lastName.substring(ZERO, ONE).toUpperCase() + lastName.substring(ONE).toLowerCase();
    }

    /**
     * Returns the full name in reverse order
     * @return the full name in reverse order
     */
    public String getReverseName()
    {
        StringBuilder reverseFirst = new StringBuilder();
        StringBuilder reverseLast = new StringBuilder();

        for (int i = firstName.length() - ONE; i >= ZERO; i--)
        {
            reverseFirst.append(firstName.charAt(i));
        }

        for (int i = lastName.length() - ONE; i >= ZERO; i--)
        {
            reverseLast.append(lastName.charAt(i));
        }

        return reverseLast + " " + reverseFirst;
    }
}
