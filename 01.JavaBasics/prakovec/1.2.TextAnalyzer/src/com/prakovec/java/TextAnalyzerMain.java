package com.prakovec.java;

/**
 * Created by Admin on 29.11.2014.
 */
public class TextAnalyzerMain {

    public static void main(String[] args) {

        String originalText = " На вход программе поступает трёхзначное число (от 100 до 999), которое генерируется случайным образом либо вводиться из консоли (на своё усмотрение).\n" +
                "Необходимо определить является ли число счастливым. Счастливое число, это число у которого все цифры совпадают (например 777), либо число у которого каждая последующая цифра на 1 больше предыдущей (123 или 456), а также счастливыми являются числа 781, 302, 409 и 941 (такие числа будет называть “Магическими”).\n" +
                "Программа должна вывести на экран входное число ( только в случае если оно было сгенерировано) и результат какое число попалось: “Счастливое”, “Несчастливое” или “Магическое”. \n ";

        System.out.println("\nDisplaying the number of vowels and consonants in the text:\n");

        char[] vowels = new char[]{'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я'};
        char[] consonants = new char[]{'б', 'в', 'г', 'д', 'ж', 'з', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ь'};
        int vowelsNumber = 0;
        int consonantsNumber = 0;        //Подсчет глассных букв.
        for (int j = 0; j <= originalText.toCharArray().length - 1; j++) {
            for (int i = 0; i <= vowels.length - 1; i++) {
                if ((int) originalText.toLowerCase().toCharArray()[j] == (int) vowels[i]) {
                    vowelsNumber++;
                }
            }
        }
        // Подсчет согласных букв
        for (int j = 0; j <= originalText.toCharArray().length - 1; j++)
            for (int i = 0; i <= consonants.length - 1; i++) {
                if ((int) originalText.toLowerCase().toCharArray()[j] == (int) consonants[i]) {
                    consonantsNumber++;
                }
            }

        System.out.println("Number of vowels: " + vowelsNumber);
        System.out.println("Number of consonants: " + consonantsNumber);

        int index = 0;
        int numberSymbol = 0;
        System.out.println("\nThe output of each sentence on a new line:\n");
        while (index < originalText.toCharArray().length) {

            if (originalText.toCharArray()[index] != '.') {
                numberSymbol++;
                System.out.print(originalText.toCharArray()[index]);
            } else {
                System.out.println("."+"\n" + "The number of characters in a sentence: " + (numberSymbol + 1) + "\n");

                numberSymbol = 0;
            }

            index++;
        }

        System.out.println("\nCounting the number of spaces and paragraphs in the text: \n");
        int spaceNumber = 0;
        for (int i = 0; i <= originalText.toCharArray().length - 1; i++) {
            if (originalText.toCharArray()[i] == ' ') {
                spaceNumber++;
            }
        }
        System.out.println("Number of spaces in the text: " + spaceNumber+"\n");

        //Количество обзацев
        int paragraphNumber = 1;
        for (int i = 0; i <= originalText.toCharArray().length - 2; i++) {
            if (originalText.toCharArray()[i] == '\n' && originalText.toCharArray()[i + 1] != '\n') {
                paragraphNumber++;
            }

        }

        System.out.println("Number of paragraphs in the text: " + paragraphNumber);
        System.out.println();

        // Создание текста в котором убраны все пробельные символы в исходном тексте и вывести ее
        System.out.println("Text without spaces. Accomplished using the standard method replaceAll:");
        System.out.println();
        String newText = originalText.replaceAll(" ", "");
        System.out.print(newText);

        System.out.println();
        System.out.println("Text without spaces. Achieved yourself:");
        System.out.println();

        char[] newTextMatrix = new char[originalText.toCharArray().length];
        int j = 0;
        for (int i = 0; i <= originalText.toCharArray().length - 1; i++) {
            if (originalText.toCharArray()[i] != ' ') {
                newTextMatrix[j] = originalText.toCharArray()[i];
                j++;
            }

        }


        String newTextString = new String(newTextMatrix);
        System.out.print(newTextString);
    }

}
