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
     * The Person Constructor that initializes the object (dead person).
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

    /**
     * The Person Constructor that initializes the object (alive person).
     * @param name is a Name
     * @param birthDate is the date of birth
     */
    public Person(final Name name, final Date birthDate)
    {
        this(name, birthDate, null);
    }

    public Name getName() {
        return name;
    }

    public boolean isDead() {
        return getDeathDate() != null;
    }

    public String getDetails()
    {
        StringBuilder details = new StringBuilder();

        details.append(name.getFullName() + " ");

        if (this.deathDate == null) {
            details.append("(alive) ");
        } else {
            details.append("(died " + this.deathDate.getDayOfTheWeek() + ", " + this.deathDate + ") ");
        }

        details.append("was born on " + this.birthDate.getDayOfTheWeek() + ", " + this.birthDate + "!");

        return details.toString();
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Date getDeathDate() {
        return deathDate;
    }
}
