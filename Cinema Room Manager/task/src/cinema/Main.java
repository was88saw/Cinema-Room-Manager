package cinema;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
//    public static void main(String[] args) {
//
////        printSeats();
//        calculateTheProfit();
//
//    }

    public static void printSeats(){

        System.out.println("Cinema:");

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 9;j++){
                if(i == 0 && j == 0) {System.out.print("  ");}else
                if(j == 0) {System.out.print(i + " ");} else
                if(i == 0) {System.out.print(j + " ");}else {
                    System.out.print("S ");
                }
            }
            System.out.println();
        }
    }

    public static void calculateTheProfit(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        System.out.print("> ");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        System.out.print("> ");
        int seats = scanner.nextInt();
        System.out.println("Total income:");

        int numberOfSeats = rows * seats;
        int ticketPrice = 10;
        int totalIncome = 0;
        if(numberOfSeats <= 60){
            totalIncome = ticketPrice * numberOfSeats;
        }else{
            if(rows % 2 == 1){
                totalIncome += (rows / 2) * seats * ticketPrice;
                totalIncome += ((rows / 2) + 1) * seats * (ticketPrice - 2);
            }else {
                totalIncome += (rows / 2) * seats * ticketPrice;
                totalIncome += (rows / 2) * seats * (ticketPrice - 2);
            }
        }
        System.out.print("$" + totalIncome);

        scanner.close();
    }
}