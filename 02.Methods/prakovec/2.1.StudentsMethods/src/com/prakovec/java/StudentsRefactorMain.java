package com.prakovec.java;

import java.util.Random;
import java.util.Scanner;

public class StudentsRefactorMain {

    public static void main(String[] args) {
        int courses, students;

        students = inputStudents();

        courses = inputCourses();

        int[][] matrixMarks = new int[courses][students];
        matrixGeneration(matrixMarks);
        matrixOut(matrixMarks);

        int[][] transpositionMatrixMark = new int[matrixMarks[0].length][matrixMarks.length];
        transpositionMatrixMark = transpositionMatrix(matrixMarks);

        double[] averageRatingStudentsMatrix = new double[transpositionMatrixMark.length];
        averageRatingStudentsMatrix = calcAverageRating(transpositionMatrixMark);
        System.out.printf("%n Average students rating is: ");
        matrixOut(averageRatingStudentsMatrix);

        double[] averageRatingCoursesMatrix = new double[matrixMarks.length];
        System.out.printf("%n%n Average courses rating is: ");
        averageRatingCoursesMatrix = calcAverageRating(matrixMarks);
        matrixOut(averageRatingCoursesMatrix);

        double averageRatingClass;
        averageRatingClass = calcAverageRatingClass(matrixMarks);
        System.out.printf("%n%n Average rating class is:  %3.2f  ", averageRatingClass);

        double minRating;
        minRating = minRatingCalc(averageRatingStudentsMatrix);
        System.out.printf("%n%n Minimum average rating class is:  %3.2f  ", minRating);

        double maxRating;
        maxRating = maxRatingCalc(averageRatingStudentsMatrix);
        System.out.printf("%n%n Maximum average rating class is:  %3.2f%n%n", maxRating);
    }

    /**
     * This method generates a random array of estimates.
     *
     * @param matrix the array to be filled with estimates.
     */
    public static void matrixGeneration(int matrix[][]) {
        Random rnd = new Random();
        for (int coursesNumber = 0; coursesNumber < matrix.length; coursesNumber++) {
            for (int studentsNumber = 0; studentsNumber < matrix[coursesNumber].length; studentsNumber++) {
                matrix[coursesNumber][studentsNumber] = rnd.nextInt(10) + 1;
            }
        }
    }

    /**
     * This method displays a two-dimensional array on the screen.
     *
     * @param matrix array that is to be displayed.
     */
    public static void matrixOut(int matrix[][]) {
        for (int coursesNumber = 0; coursesNumber < matrix.length; coursesNumber++) {
            System.out.printf("Course %2d:", coursesNumber + 1);
            for (int studentsNumber = 0; studentsNumber < matrix[coursesNumber].length; studentsNumber++) {
                System.out.printf("%4d  ", matrix[coursesNumber][studentsNumber]);
            }
            System.out.println();
        }
    }

    /**
     * Method outputs the one-dimensional array on the screen.
     *
     * @param matrix array that is to be displayed.
     */
    public static void matrixOut(double matrix[]) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.printf("%3.2f  ", matrix[i]);
        }
    }

    /**
     * Method transposes the array
     *
     * @param matrix original array
     * @return the transpose of the matrix
     */
    public static int[][] transpositionMatrix(int matrix[][]) {

        int[][] transpositionMatrix = new int[matrix[0].length][matrix.length];
        for (int coursesNumber = 0; coursesNumber < matrix.length; coursesNumber++) {
            for (int studentsNumber = 0; studentsNumber < matrix[coursesNumber].length; studentsNumber++) {

                transpositionMatrix[studentsNumber][coursesNumber] = matrix[coursesNumber][studentsNumber];
            }
        }

        return transpositionMatrix;
    }

    /**
     * Method calculates the average score
     *
     * @param matrix an array of assessments
     * @return array with the average scores
     */
    public static double[] calcAverageRating(int matrix[][]) {

        double[] averageRatingMatrix = new double[matrix.length];
        for (int number = 0; number < matrix.length; number++) {
            for (int courseNumber = 0; courseNumber < matrix[number].length; courseNumber++) {
                averageRatingMatrix[number] += (double) matrix[number][courseNumber] / (double) matrix[number].length;
            }
        }
        return averageRatingMatrix;
    }

    /**
     * Method calculates the average rating class
     *
     * @param matrix ratings class array
     * @return average rating class
     */
    public static double calcAverageRatingClass(int matrix[][]) {
        double averageRatingClass = 0;
        for (int coursesNumber = 0; coursesNumber < matrix.length; coursesNumber++) {
            for (int studentsNumber = 0; studentsNumber < matrix[coursesNumber].length; studentsNumber++) {
                averageRatingClass += ((double) matrix[coursesNumber][studentsNumber] / (double) matrix[coursesNumber].length) / (double) matrix.length;
            }
        }
        return averageRatingClass;
    }

    /**
     * Search for the minimum average rating in the class
     *
     * @param matrix an array of medium ratings class
     * @return minimum average rating in the class
     */
    public static double minRatingCalc(double matrix[]) {
        double minRating = matrix[1];
        for (int studentsNumber = 0; studentsNumber < matrix.length; studentsNumber++) {
            if (minRating > matrix[studentsNumber]) {
                minRating = matrix[studentsNumber];
            }
        }
        return minRating;
    }

    /**
     * Search for the maximum average rating in the class
     *
     * @param matrix an array of medium ratings class
     * @return maximum average rating in the class
     */
    public static double maxRatingCalc(double matrix[]) {
        double maxRating = matrix[1];
        for (int studentsNumber = 0; studentsNumber < matrix.length; studentsNumber++) {
            if (maxRating < matrix[studentsNumber]) {
                maxRating = matrix[studentsNumber];
            }
        }
        return maxRating;
    }

    /**
     * Input and verifying data on students.
     *
     * @return number of students
     */
    public static int inputStudents() {
        System.out.println("Please enter the number of students in a class of 15 to 25: ");
        Scanner scan = new Scanner(System.in);
        int students;
        if (scan.hasNextInt()) {
            students = scan.nextInt();
        } else {
            students = 0;
            System.out.print("Input is FAILED!");
            System.exit(0);
        }

        if (students < 15 || students > 25) {
            System.out.print("The number of students entered incorrect!");
            System.exit(0);
        }

        return students;
    }

    /**
     * Input and verifying data on courses.
     *
     * @return number of courses.
     */
    public static int inputCourses() {
        System.out.println("Enter the number of courses from 8 to 12: ");
        Scanner scan = new Scanner(System.in);
        int courses;
        if (scan.hasNextInt()) {
            courses = scan.nextInt();

        } else {
            courses = 0;
            System.out.print("Input is FAILED!");
            System.exit(0);
        }

        if (courses < 8 || courses > 12) {
            System.out.print("The number of students entered incorrect!");
            System.exit(0);
        }

        return courses;
    }
}
