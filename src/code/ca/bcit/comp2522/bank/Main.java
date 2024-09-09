package ca.bcit.comp2522.bank;

public class Main {
    public static void main(String[] args) {
        Date date = new Date(2021, 3, 15);
        System.out.println(date.getDayOfTheWeek());
        System.out.println(date.getMonthString());
        System.out.println(date);
    }
}