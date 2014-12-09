package by.htp.krozov.homework.luckynumber;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static final int[] magicNumbers = {302, 409, 781, 941};

    public static void main(String[] args) {
        int number = new Random().nextInt(900) + 100;
        System.out.printf("Number %d is ", number);

        if (Arrays.binarySearch(magicNumbers, number) >= 0) {
            System.out.println("magic");
        } else {
            int digit1 = number / 100;
            int digit2 = (number / 10) % 10;
            int digit3 = number - digit1 * 100 - digit2 * 10;

            if ((digit1 == digit2 && digit2 == digit3)
                    || (digit2 == (digit1 + 1) && digit3 == (digit2 + 1))) {
                System.out.println("lucky");
            } else {
                System.out.println("simple");
            }
        }
    }
}
