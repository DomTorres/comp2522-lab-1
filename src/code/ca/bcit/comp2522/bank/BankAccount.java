package ca.bcit.comp2522.bank;

/**
 * The BankAccount class represents a bank account held by a client.
 * It contains information about the account number, the current balance, a pin,
 * date which the account was opened and closed(optional) and
 * the owner of the account (a BankClient object).
 *
 * @author John & Dom
 * @version 1.0
 */
public class BankAccount {

    private static final int MIN_ACCOUNT_NUMBER_LEN = 6;
    private static final int MAX_ACCOUNT_NUMBER_LEN = 7;

    private final BankClient client;
    private double balanceUSD;
    private final int pin;
    private final String accountNumber;
    private final Date dateOpened;
    private final Date dateClosed;

    /**
     * Constructs a new BankAccount with a BankClient object, balance, pin,
     * account number, date opened and closed.
     * @param client        is the BankClient who owns the account.
     * @param balanceUSD    is the initial balance of the bank account.
     * @param pin           is the pin of the bank account.
     * @param accountNumber is the account number of the bank account.
     * @param dateOpened    is the date when the bank account was opened.
     * @param dateClosed    is the date when the bank account was closed.
     */
    public BankAccount(final BankClient client,
                       final double balanceUSD,
                       final int pin,
                       final String accountNumber,
                       final Date dateOpened,
                       final Date dateClosed)
    {
        validateAccountNumber(accountNumber);

        this.client = client;
        this.balanceUSD = balanceUSD;
        this.pin = pin;
        this.accountNumber = accountNumber;
        this.dateOpened = dateOpened;
        this.dateClosed = dateClosed;
    }

    /**
     * Constructs a new BankAccount with a BankClient object, balance, pin,
     * account number, date opened.
     * This constructor assumes that the bank account has not been closed and
     * sets the dateClosed to null.
     * @param client        is the BankClient who owns the account.
     * @param balanceUSD    is the initial balance of the bank account.
     * @param pin           is the pin of the bank account.
     * @param accountNumber is the account number of the bank account.
     * @param dateOpened    is the date when the bank account was opened.
     */
    public BankAccount(final BankClient client,
                       final double balanceUSD,
                       final int pin,
                       final String accountNumber,
                       final Date dateOpened)
    {
        this(client, balanceUSD, pin, accountNumber, dateOpened, null);
    }

    /* Validates the Account Number.
    * Cannot be blank or null.
    * Must be within the minimum and maximum account number length */
    private void validateAccountNumber(String accountNumber)
    {
        if (accountNumber == null ||
                accountNumber.isBlank() ||
                accountNumber.length() < MIN_ACCOUNT_NUMBER_LEN ||
                accountNumber.length() > MAX_ACCOUNT_NUMBER_LEN)
        {
            throw new IllegalArgumentException("Invalid Client ID:" + accountNumber);
        }
    }

    /**
     * Removes the amount in USD from the account balance if the pin matches
     * the BankAccount pin.
     * @param amountUSD     is the amount to withdraw from the account in USD.
     * @param pinToMatch    is the pin used to authenticate the user.
     */
    public void withdraw(final double amountUSD, final int pinToMatch)
    {
        if (pin != pinToMatch) {
            throw new IllegalArgumentException("Invalid pin: " + pinToMatch);
        } else if (balanceUSD < amountUSD) {
            throw new IllegalArgumentException("Withdraw amount of " + amountUSD
                    + " exceeds Account Balance of " + balanceUSD);
        } else {
            balanceUSD = balanceUSD - amountUSD;
        }
    }

    /**
     * Sends the user an error message because a pin was not inputted.
     * @param amountUSD     is the amount to withdraw from the account in USD.
     */
    public void withdraw(final double amountUSD)
    {
        throw new IllegalArgumentException("No pin inputted.");
    }

    /**
     * Deposits the given amount in USD to the account balance if the correct pin is given.
     * @param amountUSD     is the amount to be deposited from the account in USD.
     * @param pinToMatch    is the pin used to authenticate the user.
     * @return
     */
    public double deposit(final double amountUSD, final int pinToMatch)
    {
        if (pin != pinToMatch) {
            throw (new IllegalArgumentException("Invalid pin: " + pinToMatch));
        } else {
            balanceUSD = balanceUSD + amountUSD;
        }
        return balanceUSD;
    }

    /**
     * Returns a String containing the details of the BankAccount.
     * @return a String representing the details of the BankAccount.
     */
    public String getDetails()
    {
        String details;

        details = String.format("%s had $%.2f USD in account #%s which was opened on %s %s",
                client.getName().getFullName(), balanceUSD, accountNumber, dateOpened.getDayOfTheWeek(),
                dateOpened.toString());

        if (dateClosed != null) {
            details += String.format(" and closed %s %s.",
                    dateClosed.getDayOfTheWeek(), dateClosed.toString());
        }

        return details;
    }
}
