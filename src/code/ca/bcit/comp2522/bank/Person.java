package ca.bcit.comp2522.bank;

/**
 * The Person class represents an individual with a name, birth date, and an optional death date.
 * It provides methods to access the details of the Person's name, birth, and death date if applicable.
 *
 * @author John and Dom
 * @version 1.0
 */
public class Person {

    private final Name name;
    private final Date birthDate;
    private final Date deathDate;

    /**
     * The Person Constructor that initializes the object using their Name, birthdate and death date.
     * @param name is the person's name.
     * @param birthDate is the date of birth.
     * @param deathDate is the date of death.
     */
    public Person (final Name name, final Date birthDate, final Date deathDate)
    {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    /**
     * The Person Constuctor that initializes the object.
     * This constructor is used when the death date is not provided and
     * assumes that the Person is still alive.
     * @param name is the person's name.
     * @param birthDate is the date of birth.
     */
    public Person(final Name name, final Date birthDate)
    {
        this(name, birthDate, Date.DEFAULT_DATE);
    }

    /**
     * Returns the Name of the Person
     * @return the Name of the Person
     */
    public Name getName() {
        return name;
    }

    /**
     * Returns if person is alive.
     * @return true if Person is alive
     */
    public boolean isAlive() {
        return deathDate == null;
    }

    /**
     * Returns a String containing the details of the Person.
     * @return a String representing the details of the Person.
     */
    public String getDetails()
    {
        final String details;

        if (this.deathDate == null)
        {
            details = String.format("%s (alive) was born on %s, %s!",
                    name.getFullName(),
                    birthDate.getDayOfTheWeek(), birthDate.toString());
        } else {
            details = String.format("%s (died %s, %s) was born on %s, %s!",
                    name.getFullName(),
                    deathDate.getDayOfTheWeek(), deathDate.toString(),
                    birthDate.getDayOfTheWeek(), birthDate.toString());
        }

        return details;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Date getDeathDate() {
        return deathDate;
    }
}
