package ca.bcit.comp2522.bank;

public class Main {
    public static void main(String[] args) {
        // Albert Einstein
        Name n = new Name("Albert", "Einstein");

        System.out.println(n.getInitials());
        System.out.println(n.getFullName());
        System.out.println(n.getReverseName());

        Date aeBirthDate = new Date(1879, 3, 14);
        Date aeDeathDate = new Date(1955, 4, 18);
        Date aeBankOpenDate = new Date(1900, 1, 1);
        Date aeBankCloseDate = new Date(1950, 10, 14);

        Person ae = new Person(n, aeBirthDate, aeDeathDate);
        System.out.println(ae.getDetails());

        BankClient bc1 = new BankClient(n, aeBirthDate, aeDeathDate, aeBankOpenDate,"654321");
        System.out.println(bc1.getDetails());

        BankAccount ba1 = new BankAccount(bc1, 1000, 3141, "654321", aeBankOpenDate, aeBankCloseDate);
        System.out.println(ba1.getDetails());
        ba1.withdraw(100, 3141);
        System.out.println(ba1.getDetails());

        // Nelson Mandela
        final Person nelsonMandela = new Person(
                new Name("Nelson", "Mandela"),
                new Date(1918, 7, 18),
                new Date(2013, 12, 5)
        );

        final String nelsonMandelaAccountNumber = "654321";
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
                nelsonMandelaAccountNumber
        );

        System.out.println(nelsonMandelaBankClient.getDetails());

        BankAccount nelsonMandelaBankAccount = new BankAccount(
                nelsonMandelaBankClient,
                2000,
                4664,
                nelsonMandelaAccountNumber,
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

        final String fridaKahloAccountNumber = "frd123";
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
                fridaKahloAccountNumber
        );

        System.out.println(fridaKahloBankClient.getDetails());

        BankAccount fridaKahloBankAccount = new BankAccount(
                fridaKahloBankClient,
                500,
                1907,
                fridaKahloAccountNumber,
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

        final String jackieChanAccountNumber = "chan789";
        final Date jackieChanSignUpDate = new Date(1980, 8, 1);

        System.out.println(jackieChan.getName().getInitials());
        System.out.println(jackieChan.getName().getFullName());
        System.out.println(jackieChan.getName().getReverseName());
        System.out.println(jackieChan.getDetails());

        BankClient jackieChanBankClient = new BankClient(
                jackieChan.getName(),
                jackieChan.getBirthDate(),
                jackieChanSignUpDate,
                jackieChanAccountNumber
        );

        System.out.println(jackieChanBankClient.getDetails());

        BankAccount jackieChanBankAccount = new BankAccount(
                jackieChanBankClient,
                3000,
                1954,
                jackieChanAccountNumber,
                jackieChanSignUpDate
        );

        System.out.println(jackieChanBankAccount.getDetails());

        jackieChanBankAccount.withdraw(500, 1954);

        System.out.println(jackieChanBankAccount.getDetails());
    }
}