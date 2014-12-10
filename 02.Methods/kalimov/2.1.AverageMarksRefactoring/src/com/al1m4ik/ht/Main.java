package com.al1m4ik.ht;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	    Random r = new Random();
        int numOfStud = r.nextInt(11)+15;
        int numOfClasses = r.nextInt(6)+8;
        int stud[][] = new int [numOfStud][numOfClasses];

         //Заполняем отметками
        fillArr(stud);

        //Выводим
        arrPrint(stud);

        //Средний бал класса (ср.арифм.)
        averageMark(stud,numOfClasses,numOfStud);

        //Средний бал по предметам
        averageBySubject(stud,numOfStud);

        //Средний бал учеников класса
        averageStud(stud,numOfClasses);

        //Мин и макс средний бал
        minMax(stud,numOfClasses);
    }

    public static void fillArr(int[][] stud){
        Random r = new Random();
        for (int row = 0; row < stud.length; row++ )
            for (int col = 0; col < stud[row].length; col++)
                stud[row][col] = r.nextInt(10)+1;
    }

    public static void arrPrint(int[][] stud){
        for (int row = 0; row < stud.length; row++ ) {
            for (int col = 0; col < stud[row].length; col++)
                System.out.print(stud[row][col] + " ");
            System.out.println();
        }
    }

    public static void averageMark(int[][] stud, int numOfClasses, int numOfStud){
        System.out.println("\n\t The average mark ");
        int sum = 0;
        for (int col = 0; col < stud.length; col++ )
            for (int row = 0; row < stud[row].length; row++)
                sum += stud[col][row];
        System.out.println("The average mark in class is " + (double) sum / (double) (numOfClasses * numOfStud));
    }

    public static void averageBySubject(int[][] stud, int numOfStud){
        System.out.println("\n\t The average mark for subjects");
        int sum = 0;
        for (int row = 0; row < stud.length; row++ ) {
            for (int col = 0; col < stud[row].length; col++)
                sum += stud[row][col];
            System.out.println("The average mark for " + (row+1) + "-subject is " + (double) sum / (double)numOfStud);
        }
    }

    public static void averageStud(int[][] stud, int numOfClasses){
        int sum = 0;
        System.out.println("\n\tThe average mark for students ");
        for (int col = 0; col < stud.length; col++ ) {
            for (int row = 0; row < stud[row].length; row++)
                sum += stud[col][row];
            System.out.println("The average mark for " + (col+1) + " student  is " + (double) sum / (double)numOfClasses);
        }
    }

    public static void minMax(int[][] stud,int numOfClasses){
        int sum = 0;
        double min = 11;
        double max = 0;
        System.out.println("\n\tMin & Max ");
        for (int col = 0; col < stud.length; col++ ) {
            for (int row = 0; row < stud[row].length; row++)
                sum += stud[col][row];
            double av = (double)sum / (double)numOfClasses;
            if ( av > max )
                max = av;
            if ( av < min )
                min = av;
            sum = 0;
        }
        System.out.println("Max average mark in class is " + max);
        System.out.println("Min average mark in class is " + min);
    }
}
