package com.prakovec.java;

import java.util.Scanner;

/**
 * Created by Admin on 30.11.2014.
 */
public class FibonacciMain {

    public static void main(String[] args) {

        System.out.println("Please, enter the number of the Fibonacci numbers:");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();

        System.out.print("Recursion calc: \n0 ");
        for (int i = 1; i <= number; i++) {

            System.out.print(fibonacciRecursive(i) + " ");
        }
        System.out.print("\nNot recursion calc: \n");
        fibonacciCalc(number);
    }

    /**
     * This method calc Fibonacci number using recursion
     *
     * @param number number of Fibonacci number to be displayed
     * @return Fibonacci number
     */
    public static long fibonacciRecursive(int number) {
        if (number == 0) {
            return 0;
        } else {

            if (number == 1) {
                return 1;
            } else {
                return fibonacciRecursive(number - 1) + fibonacciRecursive(number - 2);
            }
        }

    }

    /**
     * This method calc fibonacci not recursion
     *
     * @param number Fibonacci number
     */
    public static void fibonacciCalc(int number) {

        long number0 = 0;
        long number1 = 1;

        System.out.print(number0 + " " + number1 + " ");

        long number2;

        for (int i = 1; i < number; i++) {
            number2 = number0 + number1;
            System.out.print(number2 + " ");
            number0 = number1;
            number1 = number2;
        }

    }

}
