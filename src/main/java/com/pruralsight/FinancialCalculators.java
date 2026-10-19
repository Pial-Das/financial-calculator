
package com.pruralsight;

import java.util.Scanner;

public class FinancialCalculators {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        // showing the menu
        System.out.println("=== Financial Calculators ===");
        System.out.println("1. Mortgage Calculator");
        System.out.println("2. CD Calculator");
        System.out.println("3. Annuity Calculator");
        System.out.println("4. Exit");

        // asking user to choose
        System.out.print("Enter your choice: ");
        int choice = myScanner.nextInt();

        if (choice == 1) {

            System.out.println("Welcome to Mortgage Calculator");

            // asking user for loan amount
            System.out.print("Enter loan amount: ");
            double principal = myScanner.nextDouble();

            // asking user for interest rate
            System.out.print("Enter interest rate: ");
            double interestRate = myScanner.nextDouble();

            // asking how many years
            System.out.print("Enter loan years: ");
            int years = myScanner.nextInt();

            if (principal <= 0 || years <= 0 || interestRate < 0) {
                System.out.println("Invalid loan information");
            } else {

                // converting interest rate to decimal
                double annualRate = interestRate / 100;

                // calculating monthly interest rate
                double monthlyRate = annualRate / 12;

                // calculating total monthly payments
                int numberOfPayments = years * 12;

                double monthlyPayment;

                // checking if interest rate is zero
                if (monthlyRate == 0) {
                    monthlyPayment = principal / numberOfPayments;
                } else {

                    // calculating power for mortgage formula
                    double power = Math.pow(1 + monthlyRate, numberOfPayments);

                    // calculating monthly mortgage payment
                    monthlyPayment = principal * (monthlyRate * power) / (power - 1);
                }

                // calculating total interest paid
                double totalInterest = (monthlyPayment * numberOfPayments) - principal;

                // showing the results
                System.out.println("=== Mortgage Summary ===");
                System.out.printf("Monthly Payment: $%.2f%n", monthlyPayment);
                System.out.printf("Total Interest: $%.2f%n", totalInterest);
                System.out.println("Number of Payments: " + numberOfPayments);
            }

        } else if (choice == 2) {

            System.out.println("Welcome to CD Calculator");

            // asking user for deposit amount
            System.out.print("Enter deposit amount: ");
            double deposit = myScanner.nextDouble();

            // asking for annual interest rate
            System.out.print("Enter interest rate: ");
            double interestRate = myScanner.nextDouble();

            // asking how many years
            System.out.print("Enter number of years: ");
            int years = myScanner.nextInt();

            if (deposit <= 0 || years <= 0 || interestRate < 0) {
                System.out.println("Invalid deposit information");
            } else {

                // converting interest rate to decimal
                double annualRate = interestRate / 100;

                // calculating daily interest rate
                double dailyRate = annualRate / 365;

                // calculating total days
                int totalDays = years * 365;

                // calculating future value
                double futureValue = deposit * Math.pow(1 + dailyRate, totalDays);

                // calculating total interest earned
                double totalInterest = futureValue - deposit;

                // showing the results
                System.out.println("=== CD Calculator Summary ===");
                System.out.printf("Original Deposit: $%.2f%n", deposit);
                System.out.printf("Future Value: $%.2f%n", futureValue);
                System.out.printf("Interest Earned: $%.2f%n", totalInterest);
            }

        } else if (choice == 3) {

            System.out.println("Welcome to Annuity Calculator");

            // asking user for monthly payout
            System.out.print("Enter monthly payout: ");
            double monthlyPayout = myScanner.nextDouble();

            // asking for interest rate
            System.out.print("Enter annual interest rate: ");
            double interestRate = myScanner.nextDouble();

            // asking how many years
            System.out.print("Enter number of years: ");
            int years = myScanner.nextInt();

            if (monthlyPayout <= 0 || years <= 0 || interestRate < 0) {
                System.out.println("Invalid annuity information");
            } else {

                // converting interest rate to decimal
                double annualRate = interestRate / 100;

                // calculating monthly interest rate
                double monthlyRate = annualRate / 12;

                // calculating total monthly payments
                int numberOfPayments = years * 12;

                double presentValue;

                // checking if interest rate is zero
                if (monthlyRate == 0) {
                    presentValue = monthlyPayout * numberOfPayments;
                } else {

                    // calculating present value of annuity
                    double power = Math.pow(1 + monthlyRate, numberOfPayments);

                    presentValue = monthlyPayout * (1 - (1 / power)) / monthlyRate;
                }

                // showing the result
                System.out.println("=== Annuity Summary ===");
                System.out.printf("Monthly Payout: $%.2f%n", monthlyPayout);
                System.out.printf("Present Value: $%.2f%n", presentValue);
            }

        } else if (choice == 4) {

            System.out.println("Goodbye!");

        } else {

            System.out.println("Invalid choice");

        }

        myScanner.close();
    }
}
