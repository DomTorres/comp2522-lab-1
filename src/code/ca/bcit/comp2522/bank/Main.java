package ca.bcit.comp2522.bank;

public class Main {
    public static void main(String[] args) {
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
    }
}