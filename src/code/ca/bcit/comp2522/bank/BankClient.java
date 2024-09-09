package ca.bcit.comp2522.bank;

public class BankClient extends Person {

    private static final int SIX = 6;
    private static final int SEVEN = 7;

    private final Date signupDate;
    private final String clientID;

    /**
     * Constructs a new BankClient with the specified name, birthdate, death date,
     * signup date, and client ID.
     *
     * @param name          The name of the client.
     * @param birthDate     The date of birth of the client.
     * @param deathDate     The death date of the client or null.
     * @param signupDate    The date the client signed up.
     * @param clientID      The client ID, which must be a String of 6 or 7 digits.
     */
    public BankClient(final Name name,final Date birthDate, final Date deathDate,
                      final Date signupDate, final String clientID)
    {
        super (name, birthDate, deathDate);

        validateClientID(clientID);

        this.signupDate = signupDate;
        this.clientID = clientID;
    }

    /**
     * Constructs a new BankClient with the specified name, birthdate, signup date,
     * and client ID.
     *
     * @param name          The name of the client.
     * @param birthDate     The birthdate of the client.
     * @param signupDate    The date the client signed up.
     * @param clientID      The client ID, which must be a String of 6 or 7 digits.
     */
    public BankClient(final Name name, final Date birthDate, final Date signupDate, final String clientID)
    {
        super (name, birthDate, Person.DEFAULT_DEATHDATE);

        validateClientID(clientID);

        this.signupDate = signupDate;
        this.clientID = clientID;
    }

    private void validateClientID(final String clientID)
    {
        if (clientID == null || clientID.isBlank() || clientID.length() < SIX
                || clientID.length() > SEVEN)
        {
            throw (new IllegalArgumentException("Invalid Client ID:" + clientID));
        }
    }

    /**
     * Returns a String containing the details of the bank client.
     *
     * @return a String representing the details of the bank client.
     */
    @Override
    public String getDetails()
    {
        final String details;
        final String stateOfLife;

        if (super.isDeath())
        {
            stateOfLife = "alive";
        } else {
            stateOfLife = "dead";
        }

        details = String.format("%s client #%s (%s) joined the bank on %s, %s %s, %s",
        super.getName().getFullName(), clientID, stateOfLife,
                signupDate.getDayOfTheWeek(), signupDate.getMonth(), signupDate.getDay(), signupDate.getYear());

        return details;
    }
}
