package Cinema;

import java.util.Scanner;

/*  Cinema Room Manager
Simple program that manage seats in cinema romm.
 After getting 2 parametrs from user, irst number of rows, then number of seat in each row
 program make an array of seats in room, then prins programs menu.
 From that point user can reserve the seat, show occupaded seats, show statistics or quit
 Program runs until user chose to end it from the menu
 Application was created with a java course on Hyperskill.org */

public class Main {
    public static void main(String[] args) {

        showMenu();

    }

    public static void printSeats(int rows, int seats){

        System.out.println("Cinema:");
        String[][] cinemaRoom = new String[rows + 1][seats + 1];
        System.out.println();
    }

    public static int calculateMaxTheProfit(int rows, int seats){
        Scanner scanner = new Scanner(System.in);

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
        return totalIncome;
    }

    public static void calculateMaxTicketPrice(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        System.out.print("> ");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        System.out.print("> ");
        int seats = scanner.nextInt();
        System.out.println();
        printSeats(rows, seats);

        int ticketPrice;

        System.out.println("Enter a row number:");
        System.out.print("> ");
        int row = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        System.out.print("> ");
        int seat = scanner.nextInt();
        System.out.println();

        ticketPrice = getTicketPrice(rows, seats, row);

        System.out.println("Ticket price: $" + ticketPrice);
        System.out.println();

        System.out.println("Cinema:");

        for(int i = 0; i <= rows; i++){
            for(int j = 0; j <= seats;j++){
                if(i == 0 && j == 0) {System.out.print("  ");}else
                if(j == 0) {System.out.print(i + " ");} else
                if(i == 0) {System.out.print(j + " ");}else {
                    if(i == row && j == seat){System.out.print("B ");}else {System.out.print("S ");}
                }
            }
            System.out.println();
        }
        System.out.println();
        scanner.close();
    }

    public static void showMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        System.out.print("> ");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        System.out.print("> ");
        int seats = scanner.nextInt();
        System.out.println();

        String[][] cinemaRoom = new String[rows + 1][seats + 1];
        createRoom(cinemaRoom);

        int currentIncome = 0;
        int maxIncome = calculateMaxTheProfit(rows, seats);
        int purchasedTickets = 0;

        int answer;
        do {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            System.out.print("> ");
            answer = scanner.nextInt();
            System.out.println();

            if (answer == 1){
                printRoom(cinemaRoom);
            };

            if(answer == 2){
                if(currentIncome < maxIncome){
                    boolean condition = true;
                    do{
                        condition = true;
                        System.out.println("Enter a row number:");
                        System.out.print("> ");
                        int row = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        System.out.print("> ");
                        int seat = scanner.nextInt();
                        System.out.println();
                        if(0 < row && row <= rows && 0 < seat && seat <= seats){
                            if(!cinemaRoom[row][seat].equals( "B ")){
                                cinemaRoom[row][seat] = "B ";
                                int ticketPrice = getTicketPrice(rows, seats, row);
                                System.out.println("Ticket price: $" + ticketPrice);
                                System.out.println();
                                currentIncome += ticketPrice;
                                purchasedTickets++;
                                condition = false;
                            }else {
                                System.out.println("That ticket has already been purchased!");
                                System.out.println();
                            }
                        }else {
                            System.out.println("Wrong input!");
                            System.out.println();
                        }
                    }while (condition);
                }
                if(currentIncome == maxIncome){System.out.println("All tickets has already been purchased!");System.out.println();};
            }

            if(answer == 3){
                System.out.println("Number of purchased tickets: " + purchasedTickets);
                System.out.printf("Percentage: %.2f", calculateProcentage(purchasedTickets, seats * rows));System.out.println("%");
                System.out.println("Current income: $" + currentIncome);
                System.out.println("Total income: $" + maxIncome);
                System.out.println();
            }

        }while (answer != 0);
    }

    private static double calculateProcentage(int currentInput, int maxInut){
        double tmpCurrent = (double) currentInput;
        return (tmpCurrent / (double) maxInut) * 100;
    }

    private static void createRoom(String[][] cinemaRoom) {
        for(int i = 0; i < cinemaRoom.length; i++){
            for(int j = 0; j < cinemaRoom[i].length; j++){
                cinemaRoom[i][j] = "S ";
                if(i == 0 && j == 0) {
                    cinemaRoom[i][j] = "  ";}else
                if(j == 0) {
                    cinemaRoom[i][j] = i + " ";}else
                if(i == 0) {
                    cinemaRoom[i][j] = j + " ";}
            }
        }
    }

    private static int getTicketPrice(int rows, int seats, int row) {
        int numberOfSeats = rows * seats;
        int ticketPrice;
        if (numberOfSeats <= 60) {
            ticketPrice = 10;
        } else {
            if (rows % 2 == 1) {
                if (row < ((rows / 2) + 1)) {
                    ticketPrice = 10;
                } else ticketPrice = 8;
            } else {
                if (row < (rows / 2)) {
                    ticketPrice = 10;
                } else ticketPrice = 8;
            }
        }
        return ticketPrice;
    }

    private static void printRoom(String[][] cinemaRoom) {
        System.out.println("Cinema:");
        for(int i = 0; i < cinemaRoom.length; i++){
            for(int j = 0; j < cinemaRoom[i].length; j++){
                System.out.print(cinemaRoom[i][j]);
                if(j == cinemaRoom[i].length - 1){System.out.println();}
            }
        }
        System.out.println();
    }
}