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
        Person nelsonMandela = new Person(
                new Name("Nelson", "Mandela"),
                new Date(1918, 7, 18),
                new Date(2013, 12, 5)
        );

        System.out.println(nelsonMandela.getName().getInitials());
        System.out.println(nelsonMandela.getName().getFullName());
        System.out.println(nelsonMandela.getName().getReverseName());
        System.out.println(nelsonMandela.getDetails());

        BankClient nelsonMandelaBankClient = new BankClient(
                nelsonMandela.getName(),
                nelsonMandela.getBirthDate(),
                nelsonMandela.getDeathDate(),
                new Date(1994, 5, 10),
                "654321"
        );

        System.out.println(nelsonMandelaBankClient.getDetails());

        BankAccount nelsonMandelaBankAccount = new BankAccount(
                nelsonMandelaBankClient,
                2000,
                4664,
                nelsonMandelaBankClient.getClientID(),
                nelsonMandelaBankClient.getSignupDate()
        );

        nelsonMandelaBankAccount.withdraw(200, 4664);

        // Frida Kahlo

        Date myBirthday = new Date(2003, 4, 10);
        System.out.println(myBirthday.getDayOfTheWeek());
        // Jackie Chan
    }
}