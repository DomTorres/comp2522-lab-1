package ca.bcit.comp2522.bank;

public class BankClient extends Person {

    private static final int MIN_CLIENT_ID_LEN = 6;
    private static final int MAX_CLIENT_ID_LEN = 7;

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
    public BankClient(final Name name,
                      final Date birthDate,
                      final Date deathDate,
                      final Date signupDate,
                      final String clientID)
    {
        super(name, birthDate, deathDate);

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
    public BankClient(final Name name,
                      final Date birthDate,
                      final Date signupDate,
                      final String clientID)
    {
        super(name, birthDate, null);

        validateClientID(clientID);

        this.signupDate = signupDate;
        this.clientID = clientID;
    }

    /* Validates the ClientID.
     * Cannot be blank or null.
     * Must be within the minimum and maximum Client ID length */
    private void validateClientID(final String clientID)
    {
        final String validClientIDRegex;
        validClientIDRegex = "^\\d{" + MIN_CLIENT_ID_LEN + "," + MAX_CLIENT_ID_LEN + "}$";

        if (clientID == null ||
            clientID.isBlank() ||
            !clientID.matches(validClientIDRegex))
        {
            throw (new IllegalArgumentException("Invalid Client ID:" + clientID));
        }
    }

    /**
     * Returns a String containing the details of the bank client.
     * @return a String representing the details of the bank client.
     */
    @Override
    public String getDetails()
    {
        final StringBuilder details = new StringBuilder();

        details.append(String.format("%s client #%s ", getName().getFullName(), clientID));

        if (isAlive())
        {
            details.append("(alive) ");
        } else {
            details.append("(not alive) ");
        }

        details.append(String.format("joined the bank on %s", signupDate.getDayAndDateString()));

        return details.toString();
    }

    /**
     * Returns the signupDate
     * @return the signupDate
     */
    public Date getSignupDate() {
        return signupDate;
    }

    /**
     * Returns the clientID
     * @return the clientID
     */
    public String getClientID() {
        return clientID;
    }
}
