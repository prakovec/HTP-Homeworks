package by.htp.krozov.homework.averagemark;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // [students][themes]
        int[][] marksTable = generateMarksTable();
        System.out.println("Students count = " + marksTable.length);
        System.out.println("Themes count = " + marksTable[0].length);
        System.out.println('\n');

        System.out.println("Mark table");
        print(marksTable);
        System.out.println('\n');

        double[] studentAverageMark = studentsAverageMarks(marksTable);
        System.out.println("Students average marks");
        print(studentAverageMark);
        System.out.println('\n');

        double[] themesAverageMark = themesAverageMarks(marksTable);
        System.out.println("Themes average marks");
        print(themesAverageMark);
        System.out.println('\n');

        Arrays.sort(studentAverageMark);
        System.out.printf("Max average ball = %3.1f , min = %3.1f",
                          studentAverageMark[studentAverageMark.length - 1], studentAverageMark[0])
                .println();
    }

    public static double[] studentsAverageMarks(int[][] marksTable) {
        final int themesCount = marksTable[0].length;
        final int studentCount = marksTable.length;

        double[] studentAverageMark = new double[studentCount];
        for (int student = 0; student < studentCount; student++) {
            int summary = 0;
            for (int theme = 0; theme < themesCount; theme++) {
                summary += marksTable[student][theme];
            }

            studentAverageMark[student] = (double) summary / themesCount;
        }
        return studentAverageMark;
    }

    public static double[] themesAverageMarks(int[][] marksTable) {
        final int themesCount = marksTable[0].length;
        final int studentCount = marksTable.length;

        double[] studentAverageMark = new double[themesCount];
        for (int theme = 0; theme < themesCount; theme++) {
            int summary = 0;
            for (int student = 0; student < studentCount; student++) {
                summary += marksTable[student][theme];
            }

            studentAverageMark[theme] = (double) summary / studentCount;
        }
        return studentAverageMark;
    }

    public static void print(int[][] marksTable) {
        for (int i = 0, lastItem = marksTable.length - 1; i < marksTable.length; i++) {
            for (int j = 0; j < marksTable[i].length; j++) {
                System.out.printf("%2d ", marksTable[i][j]);
            }

            if (lastItem != i) {
                System.out.println();
            }
        }
    }

    public static void print(double[] marksTable) {
        for (int i = 0; i < marksTable.length; i++) {
            System.out.printf("%2.1f ", marksTable[i]);
        }
    }

    public static int[][] generateMarksTable() {
        Random r = new Random();

        int studentCount = r.nextInt(11) + 15;
        int themeCount = r.nextInt(9) + 3;

        int[][] marksTable = new int[studentCount][themeCount];

        for (int i = 0; i < marksTable.length; i++) {
            for (int j = 0; j < marksTable[i].length; j++) {
                marksTable[i][j] = r.nextInt(11);
            }
        }
        return marksTable;
    }
}
