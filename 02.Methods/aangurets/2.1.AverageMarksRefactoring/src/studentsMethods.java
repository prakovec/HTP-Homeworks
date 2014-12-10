import java.util.Random;

/**
 * Created by aangurets on 29.11.2014.
 */
public class studentsMethods {
    public static void main(String[] args) {
        Random rand = new Random();
        int numberOfStudents = rand.nextInt(10) + 14;
        int numberOfObjects = rand.nextInt(4) + 7;

        int[][] table = new int[numberOfStudents][numberOfObjects];

        generationNum(table);
        printNums(table);
        mediumNum(table);
    }

    /**
     * The method generates random scores from 1 to 10
     */
    public static void generationNum(int[][] table) {
        Random r = new Random();
        for (int line = 0; line < table.length; line++) {
            for (int column = 0; column < table[line].length; column++) {
                table[line][column] = r.nextInt(9) + 1;
            }
        }
    }

    /**
     * Method prints all estimates in a table
     */
    public static void printNums(int[][] table) {
        for (int lin = 0; lin < table.length; lin++) {
            for (int col = 0; col < table[lin].length; col++) {
                System.out.print(table[lin][col] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * The method calculates the average score for each student
     */
    public static void mediumNum(int[][] table) {
        double medNum = 0;
        for (int lin2 = 0; lin2 < table.length; lin2++) {
            for (int col2 = 0; col2 < table[lin2].length; col2++) {
                medNum += table[lin2][col2];
            }
            medNum /= table[lin2].length;
            System.out.printf("%8.0f", medNum);
            System.out.println();
        }
    }
}









