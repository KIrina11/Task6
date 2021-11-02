package ru.vsu.cs.kislova_i_v;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        int n = readAndCheckCorrectValue("n");
        int e = readAndCheckCorrectValue("e");
        double x = readAndCheckCorrectX();

        double firstSum = calculateSumNOfTerms(n, x, 0);
        double secondSum = calculateSumNOfTerms(n, x, e);
        double thirdSum = calculateSumNOfTerms(n, x, e / 10);
        double functionValue = calculateFunctionValue(x);

        printResults(n, e, x, firstSum, secondSum, thirdSum, functionValue);
    }

    private static int readAndCheckCorrectValue(String name) {
        System.out.printf("Input %s: ", name);
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();

        if (value > 0) {
            return value;
        } else {
            System.out.println("The " + name + " value is entered incorrectly");
            return readAndCheckCorrectValue(name);
        }
    }

    private static double readAndCheckCorrectX() {
        System.out.print("Input x: ");
        Scanner scanner = new Scanner(System.in);
        double value = scanner.nextDouble();

        if (value > -1 && value < 1) {
            return value;
        } else {
            System.out.println("The x value is entered incorrectly");
            return readAndCheckCorrectX();
        }
    }

    private static double calculateSumNOfTerms(int n, double x, int e) {
        double sum = 0;

        for (int i = 0; i < n; i++) {
            double term = Math.pow(x, i);
            if (Math.abs(term) > e) {
                sum += term;
            }
        }

        return sum;
    }

    private static double calculateFunctionValue(double x) {
        return 1 / (1 - x);
    }

    private static void printResults(int n, int e, double x,
                                     double firstSum, double secondSum, double thirdSum, double functionValue) {
        System.out.println("The sum of the first " + n +" terms of a given type = " + firstSum);
        System.out.println("The sum of the " + n + " terms that are greater than e = "
                + e + " in absolute value = " + secondSum);
        System.out.println("The sum of " + n + " terms that are greater than e/10 = "
                + e / 10 + " in absolute value = " + thirdSum);
        System.out.println("The value of the function at x = " + x + " is equal to " + functionValue);
    }
}