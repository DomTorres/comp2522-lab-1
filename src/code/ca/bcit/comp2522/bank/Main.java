package ca.bcit.comp2522.bank;

public class Main {
    public static void main(final String[] args) {
        final String default_clientID = "0000000";

        // Albert Einstein
        final Person albertEinstein = new Person(
                new Name("Albert", "Einstein"),
                new Date(1879, 3, 14),
                new Date(1955, 4, 18)
        );

        final Date albertEinsteinSignUpDate = new Date(1950, 10, 14);

        System.out.println(albertEinstein.getName().getInitials());
        System.out.println(albertEinstein.getName().getFullName());
        System.out.println(albertEinstein.getName().getReverseName());
        System.out.println(albertEinstein.getDetails());

        BankClient albertEinsteinBankClient = new BankClient(
                albertEinstein.getName(),
                albertEinstein.getBirthDate(),
                albertEinstein.getDeathDate(),
                albertEinsteinSignUpDate,
                default_clientID
        );

        System.out.println(albertEinsteinBankClient.getDetails());

        BankAccount albertEinsteinBankAccount = new BankAccount(
                albertEinsteinBankClient,
                1000,
                3141,
                "abc123",
                albertEinsteinSignUpDate
        );

        System.out.println(albertEinsteinBankAccount.getDetails());
        albertEinsteinBankAccount.withdraw(100, 3141);
        System.out.println(albertEinsteinBankAccount.getDetails());

        // Nelson Mandela
        final Person nelsonMandela = new Person(
                new Name("Nelson", "Mandela"),
                new Date(1918, 7, 18),
                new Date(2013, 12, 5)
        );

        final Date nelsonMandelaSignUpDate = new Date(1994, 5, 10);

        System.out.println(nelsonMandela.getName().getInitials());
        System.out.println(nelsonMandela.getName().getFullName());
        System.out.println(nelsonMandela.getName().getReverseName());
        System.out.println(nelsonMandela.getDetails());

        BankClient nelsonMandelaBankClient = new BankClient(
                nelsonMandela.getName(),
                nelsonMandela.getBirthDate(),
                nelsonMandela.getDeathDate(),
                nelsonMandelaSignUpDate,
                default_clientID
        );

        System.out.println(nelsonMandelaBankClient.getDetails());

        BankAccount nelsonMandelaBankAccount = new BankAccount(
                nelsonMandelaBankClient,
                2000,
                4664,
                "654321",
                nelsonMandelaSignUpDate
        );

        System.out.println(nelsonMandelaBankAccount.getDetails());
        nelsonMandelaBankAccount.withdraw(200, 4664);
        System.out.println(nelsonMandelaBankAccount.getDetails());

        // Frida Kahlo
        final Person fridaKahlo = new Person(
                new Name("Frida", "Kahlo"),
                new Date(1918, 7, 18),
                new Date(2013, 12, 5));

        final Date fridaKahloSignUpDate = new Date(1940, 1, 1);

        System.out.println(fridaKahlo.getName().getInitials());
        System.out.println(fridaKahlo.getName().getFullName());
        System.out.println(fridaKahlo.getName().getReverseName());
        System.out.println(fridaKahlo.getDetails());

        BankClient fridaKahloBankClient = new BankClient(
                fridaKahlo.getName(),
                fridaKahlo.getBirthDate(),
                fridaKahlo.getDeathDate(),
                fridaKahloSignUpDate,
                default_clientID
        );

        System.out.println(fridaKahloBankClient.getDetails());

        BankAccount fridaKahloBankAccount = new BankAccount(
                fridaKahloBankClient,
                500,
                1907,
                "frd123",
                fridaKahloSignUpDate,
                new Date(1954, 7, 13)
        );

        System.out.println(fridaKahloBankAccount.getDetails());
        fridaKahloBankAccount.withdraw(50, 1907);
        System.out.println(fridaKahloBankAccount.getDetails());

        // Jackie Chan
        final Person jackieChan = new Person(
                new Name("Jackie", "Chan"),
                new Date(1954, 4, 7)
        );

        final Date jackieChanSignUpDate = new Date(1980, 8, 1);

        System.out.println(jackieChan.getName().getInitials());
        System.out.println(jackieChan.getName().getFullName());
        System.out.println(jackieChan.getName().getReverseName());
        System.out.println(jackieChan.getDetails());

        BankClient jackieChanBankClient = new BankClient(
                jackieChan.getName(),
                jackieChan.getBirthDate(),
                jackieChanSignUpDate,
                default_clientID
        );

        System.out.println(jackieChanBankClient.getDetails());

        BankAccount jackieChanBankAccount = new BankAccount(
                jackieChanBankClient,
                3000,
                1954,
                "chan789",
                jackieChanSignUpDate
        );

        System.out.println(jackieChanBankAccount.getDetails());
        jackieChanBankAccount.withdraw(500, 1954);
        System.out.println(jackieChanBankAccount.getDetails());

    }
}