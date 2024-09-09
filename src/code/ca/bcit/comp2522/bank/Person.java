package ca.bcit.comp2522.bank;

/**
 * The Person class represents an individual with a name, birth date, and an optional death date.
 * It provides methods to access the details of the Person's name, birth, and death date if applicable.
 *
 * @author John and Dom
 * @version 1.0
 */
public class Person {

    public static final Date DEFAULT_DEATHDATE = null; // Person is still alive

    private final Name name;
    private final Date birthDate;
    private final Date deathDate;

    /**
     * The Person Constructor that initializes the object.
     * @param name is a Name
     * @param birthDate is the date of birth
     * @param deathDate is the date of death
     */
    public Person (final Name name, final Date birthDate, final Date deathDate)
    {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    public Person(final Name name, final Date birthDate)
    {
        this(name, birthDate, Date.DEFAULT_DATE);
    }

    public Name getName() {
        return name;
    }

    public boolean isDeath() {
        return deathDate != null;
    }

    public String getDetails()
    {
        final String details;

        if (this.deathDate == null)
        {
            details = String.format("%s (alive) was born on %s, %s %s, %s!",
                    name.getFullName(),
                    birthDate.getDayOfTheWeek(), birthDate.getMonth(), birthDate.getDay(), birthDate.getYear());
        } else {
            details = String.format("%s (died %s, %s %s, %s) was born on %s, %s %s, %s!",
                    name.getFullName(),
                    deathDate.getDayOfTheWeek(), deathDate.getMonth(), deathDate.getDay(), deathDate.getYear(),
                    birthDate.getDayOfTheWeek(), birthDate.getMonth(), birthDate.getDay(), birthDate.getYear());
        }

        return details;
    }
}
