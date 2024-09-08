package ca.bcit.comp2522.bank;

public class Main {
    public static void main(String[] args) {
        Date date = new Date(2003, 4, 10);
        System.out.println(date.getDayOfTheWeek());
        System.out.println(date.getMonthString());
    }
}