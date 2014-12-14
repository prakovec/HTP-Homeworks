package com.prakovec.java;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Admin on 29.11.2014.
 */
public class LuckyNumberMain {

    public static void main(String[] args) {
        Random rnd = new Random();
        int hundredsNumber = (rnd.nextInt(9) + 1) * 100;
        int scoresNumber = (rnd.nextInt(9) + 1) * 10;
        int unitsNumber = rnd.nextInt(9) + 1;
        int number = hundredsNumber + scoresNumber + unitsNumber;
        int numericOne, numericTwo, numericThree;
        int[] magicNumber ={781,302,409,941};

        System.out.println("Get the number of: " + number);
        System.out.println();

        if (Arrays.binarySearch(magicNumber, number) >= 0) {

            System.out.println("Number is MAGIC");
        } else {
            numericOne = number / 100;
            numericTwo = (number - numericOne * 100) / 10;
            numericThree = number - numericOne * 100 - numericTwo * 10;

            if ((numericOne == numericTwo && numericOne == numericThree) || (numericOne + 1 == numericTwo && numericTwo + 1 == numericThree) ) { // Проверяем является ли число счасливым по первому признаку - все цифры равны
                System.out.println("Number is Lucky");
            }  else {
                    System.out.println("Number is not Lucky.");
                }
            }
        }
    }

