package com.example.assignment1;

import java.util.Scanner;

public class TempCalc {
    public static double calculateAverage(double[] temps){
        if (temps.length == 0) return 0;
        double sum = 0;
        for (double t : temps) sum += t;
        return sum/temps.length;
    }

    public static int countAboveAverage(double[] temps) {
        double avg = calculateAverage(temps);
        int count = 0;
        for (double t : temps) {
            if (t > avg) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = scanner.nextInt();

        double[] temps = new double[n];
        System.out.println("Enter " + n + " temperature values:");
        for (int i = 0; i < n; i++) {
            System.out.print("  Day " + (i+1) + ": ");
            temps[i] = scanner.nextDouble();
        }

        double avg = calculateAverage(temps);
        int above = countAboveAverage(temps);

        System.out.printf("Average temperature: %.2f%n", avg);
        System.out.println("Number of days above average: " + above);

        scanner.close();
    }


}
