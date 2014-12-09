package by.htp.krozov.homework.fibonachi;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int count = new Random().nextInt(40);
        for (int n = 1; n <= count; n++) {
            System.out.printf("fib(%d) = %d\n", n, fibonachiRecursive(n));
        }
    }

    public static int fibonachiSimple(int n) {
        switch (n) {
            case 1:
                return 1;

            case 2:
                return 2;

            default:
                int fibPrev = 1; //Previous item
                int fib = 2; //Current item
                for (int i = 3; i <= n; i++) {
                    int temp = fib;
                    fib += fibPrev;
                    fibPrev = temp;
                }
                return fib;
        }
    }

    public static int fibonachiRecursive(int n) {
        switch (n) {
            case 1:
                return 1;

            case 2:
                return 2;

            default:
                return fibonachiRecursive(n - 2) + fibonachiRecursive(n - 1);
        }
    }
}
