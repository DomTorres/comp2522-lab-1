package ca.bcit.comp2522.bank;

public class BankAccount {

    private final BankClient client;
    private double balanceUSD;
    private final int pin;
    private final String accountNumber;
    private final Date dateOpened;
    private final Date dateClosed;

    public BankAccount(final BankClient client, final double balanceUSD, final int pin,
                       final String accountNumber, final Date dateOpened, final Date dateClosed)
    {
        validateAccountNumber(accountNumber);

        this.client = client;
        this.balanceUSD = balanceUSD;
        this.pin = pin;
        this.accountNumber = accountNumber;
        this.dateOpened = dateOpened;
        this.dateClosed = dateClosed;

    }

    public BankAccount(final BankClient client, final double balanceUSD, final int pin,
                       final String accountNumber, final Date dateOpened)
    {
        this(client, balanceUSD, pin, accountNumber, dateOpened, Date.DEFAULT_DATE);
    }

    private void validateAccountNumber(String accountNumber)
    {
        if (accountNumber == null || accountNumber.isBlank() || accountNumber.length() < 6
                || accountNumber.length() > 7)
        {
            throw (new IllegalArgumentException("Invalid Client ID:" + accountNumber));
        }
    }

    public void withdraw(final double amountUSD, final int pinToMatch)
    {
        if (pin != pinToMatch) {
            throw (new IllegalArgumentException("Invalid pin: " + pinToMatch));
        } else if (balanceUSD < amountUSD) {
            throw (new IllegalArgumentException("Withdraw amount of " + amountUSD
                    + " exceeds Account Balance of " + balanceUSD));
        } else {
            balanceUSD = balanceUSD - amountUSD;
        }
    }

    public void withdraw(final double amountUSD)
    {

    }

    public double deposit(final double amountUSD, final int pinToMatch)
    {
        if (pin != pinToMatch) {
            throw (new IllegalArgumentException("Invalid pin: " + pinToMatch));
        } else {
            balanceUSD = balanceUSD + amountUSD;
        }
        return balanceUSD;
    }

    public String getDetails()
    {
        String details;

        details = String.format("%s had $%.2f USD in account #%s which was opened on %s %s %s, %s",
                client.getName().getFullName(), balanceUSD, accountNumber, dateOpened.getDayOfTheWeek(),
                dateOpened.getMonth(), dateOpened.getDay(), dateOpened.getYear());

        if (dateClosed != null) {
            details += String.format(" and closed %s %s %s, %s.",
                    dateClosed.getDayOfTheWeek(), dateClosed.getMonth(),
                    dateClosed.getDay(), dateClosed.getYear());
        }

        return details;
    }
}
