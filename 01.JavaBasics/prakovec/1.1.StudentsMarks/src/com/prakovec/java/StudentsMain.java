package com.prakovec.java;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class StudentsMain {

    public static void main(String[] args) {
        System.out.println("Enter the number of pupils per class from 15 to 25: ");
        Scanner scan = new Scanner(System.in);
        int students;
        if (scan.hasNextInt()) {
            students = scan.nextInt();
        } else {
            students = 0;
            System.out.print("Entering incorrect!");
            System.exit(0);
        }

        if (students < 15 || students > 25) {
            System.out.print("The number of pupils entered incorrect!");
            System.exit(0);
        }
        System.out.println("Enter the number of courses from 8 to 12: ");
        int courses;
        if (scan.hasNextInt()) {
            courses = scan.nextInt();

        } else {
            courses = 0;
            System.out.print("Entering incorrect!");
            System.exit(0);
        }

        if (courses < 8 || courses > 12) {
            System.out.print("The number of courses entered incorrect!");
            System.exit(0);
        }

        Random rnd = new Random();
        int[][] matrixMarks = new int[courses][students];

        // Заполнение матрицы оценок случайными значениями от 1 до 10
        for (int coursesNumber = 0; coursesNumber < matrixMarks.length; coursesNumber++) {
            for (int studentsNumber = 0; studentsNumber < matrixMarks[coursesNumber].length; studentsNumber++) {
                matrixMarks[coursesNumber][studentsNumber] = rnd.nextInt(10) + 1;
            }
        }

        //Вывод полученной матрицы оценок
        System.out.println("Assessment of students: ");
        System.out.println();
        for (int coursesNumber = 0; coursesNumber < matrixMarks.length; coursesNumber++) {
            System.out.printf("Course number %2d: ",(coursesNumber + 1));
            for (int studentsNumber = 0; studentsNumber < matrixMarks[coursesNumber].length; studentsNumber++) {
                System.out.printf("%4d", matrixMarks[coursesNumber][studentsNumber]);
            }
            System.out.println();
        }

        // Расчет средних оценок учеников класса.

        int[][] transpositionMatrixMark = new int[students][courses]; // объявление транспонированной матрицы оценок
        //транспонирование матрицы оценок
        for (int coursesNumber = 0; coursesNumber < matrixMarks.length; coursesNumber++) {
            for (int studentsNumber = 0; studentsNumber < matrixMarks[coursesNumber].length; studentsNumber++) {

                transpositionMatrixMark[studentsNumber][coursesNumber] = matrixMarks[coursesNumber][studentsNumber];
            }
        }
        //расчет средних оценок учеников по транспонированной матрице
        double[] averageRatingStudentsMatrix = new double[students];
        for (int coursesNumber = 0; coursesNumber < matrixMarks.length; coursesNumber++) {
            for (int studentsNumber = 0; studentsNumber < matrixMarks[coursesNumber].length; studentsNumber++) {
                averageRatingStudentsMatrix[studentsNumber] += (double) transpositionMatrixMark[studentsNumber][coursesNumber] / (double) courses;
            }

        }

        //Вывод средних оценок учеников класса.
        System.out.println("\n"+"Average scores of students of class: "+"\n");
        for (int studentsNumber = 0; studentsNumber < averageRatingStudentsMatrix.length; studentsNumber++) {
            System.out.printf("Student number %3d: ", studentsNumber + 1);
            System.out.printf("%3.2f \n",averageRatingStudentsMatrix[studentsNumber]);
        }

        //Расчет средних оценок по предметом изучаемым в классе.
        double[] averageRatingCoursesMatrix = new double[courses];
        for (int coursesNumber = 0; coursesNumber < matrixMarks.length; coursesNumber++) {
            for (int studentsNumber = 0; studentsNumber < matrixMarks[coursesNumber].length; studentsNumber++) {
                averageRatingCoursesMatrix[coursesNumber] += (double) matrixMarks[coursesNumber][studentsNumber] / (double) students;
            }
        }

        //Вывод средних оценок по предметам.
        System.out.println();
        System.out.println("Average scores on the courses:");
        System.out.println();
        for (int coursesNumber = 0; coursesNumber < averageRatingCoursesMatrix.length; coursesNumber++) {

            System.out.printf("Course number %3d: ", coursesNumber + 1);
            System.out.printf("%3.2f \n", averageRatingCoursesMatrix[coursesNumber]);
        }

        //Расчет средней оценки класса
        double averageRatingClass = 0;
        for (int coursesNumber = 0; coursesNumber < matrixMarks.length-1; coursesNumber++) {
            for (int studentsNumber = 0; studentsNumber < matrixMarks[coursesNumber].length; studentsNumber++) {
                averageRatingClass += ((double) matrixMarks[coursesNumber][studentsNumber] / (double) students) / (double) courses;
            }
        }

        //Вывод средней оценки класса
        System.out.printf("\n Average rating class: %6.2f", averageRatingClass);

        //Поиск наибольшей и найменьшей средней оценки через сортировку матрицы средних оценок.

        Arrays.sort(averageRatingStudentsMatrix); // Решил не изобретать велосипед и воспользоваться методом sort()

        //Вывод наибольшей и наименьшей средней оценки I
        System.out.printf("\n\nHighest Average pupil method I: %6.2f", averageRatingStudentsMatrix[averageRatingStudentsMatrix.length - 1]);
        System.out.printf("\nThe lowest average score of pupils method I: %6.2f", averageRatingStudentsMatrix[0]);

        double minRating = averageRatingStudentsMatrix[1];

        for (int studentsNumber = 0; studentsNumber < averageRatingStudentsMatrix.length; studentsNumber++) {
            if (minRating > averageRatingStudentsMatrix[studentsNumber]) {
                minRating = averageRatingStudentsMatrix[studentsNumber];
            }
        }
        double maxRating = averageRatingStudentsMatrix[1];

        for (int studentsNumber = 0; studentsNumber < averageRatingStudentsMatrix.length; studentsNumber++) {
            if (maxRating < averageRatingStudentsMatrix[studentsNumber]) {
                maxRating = averageRatingStudentsMatrix[studentsNumber];
            }
        }


        //Вывод наибольшей и наименьшей средней оценки II
        System.out.printf("\n\nHighest Average pupil method II: %6.2f", maxRating);
        System.out.printf("\nThe lowest average score of pupils  method II: %6.2f", minRating);

    }
}
