package com.example.assignment2;

import java.util.Scanner;

public class MovieTheatre {
    private boolean[][] seats;
    private int rows;
    private int cols;

    public MovieTheatre(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.seats = new boolean[rows][cols];
    }

    public static int[] parseSeatLabel(String label){
        label = label.trim().toUpperCase();
        if (label.length() != 2) {
            throw new IllegalArgumentException("Please enter a letter + number, e.g. B6");
        }

        int rowIndex = label.charAt(0) - 'A';
        int colIndex = Integer.parseInt(label.substring(1)) - 1;

        return new int[]{rowIndex, colIndex};
    }

    public boolean seatIsAvailable (int row, int col){
        if(row < 0 || row >= rows || col < 0 || col >= cols){
            throw new IllegalArgumentException("Invalid seat position");
        }
        return !seats[row][col];
    }

    public boolean bookSeat (int row, int col){
        if(!seatIsAvailable(row, col)){
            return false;
        }
        seats[row][col] = true;
        return true;
    }

    public boolean cancelSeat (int row, int col){
        if(seatIsAvailable(row, col)){
            return false;
        }
        seats[row][col] = false;
        return true;
    }

    public void printSeating(){
        System.out.println("\nSeating Chart:");

        System.out.print("    ");
        for (int c = 1; c <= cols; c++) {
            System.out.printf("%2d ", c);
        }
        System.out.println();

        for (int r = 0; r < rows; r++) {
            char rowLetter = (char)('A' + r);
            System.out.printf("%2c |", rowLetter);
            for (int c = 0; c < cols; c++) {
                System.out.print(seats[r][c] ? " X " : " O ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int rows = 5;
        int cols = 8;

        MovieTheatre theatre = new MovieTheatre(rows, cols);

        theatre.bookSeat(2,4);
        theatre.bookSeat(2,3);
        theatre.bookSeat(4,1);
        theatre.bookSeat(4,2);

        System.out.println("Welcome to the theatre!");

        int choice;
        do {
            System.out.println("\n=== Theatre Booking System ===");
            theatre.printSeating();
            System.out.println("1. Book a seat");
            System.out.println("2. Cancel a seat");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            // Validate input
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter seat to book (e.g. B6): ");
                    String inputBook = scanner.next();

                    try {
                        int[] idx = parseSeatLabel(inputBook);
                        if (theatre.bookSeat(idx[0], idx[1])) {
                            System.out.printf("✅ Booked %s successfully!%n", inputBook.toUpperCase());
                        } else {
                            System.out.printf("❌ Seat %s was already taken.%n", inputBook.toUpperCase());
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("⚠️ " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter seat to book (e.g. B6): ");
                    String inputCancel = scanner.next();

                    try {
                        int[] idx = parseSeatLabel(inputCancel);
                        if (theatre.cancelSeat(idx[0], idx[1])) {
                            System.out.printf("✅ Cancelled %s successfully!%n", inputCancel.toUpperCase());
                        } else {
                            System.out.printf("❌ Seat %s is not booked.%n", inputCancel.toUpperCase());
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("⚠️ " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
