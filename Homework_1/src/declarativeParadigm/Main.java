/*
Задача 3: Вычисление факториала числа.
Напишите программу, которая находит факториал заданного числа N с использованием рекурсии или встроенных функций.

Задача 4: Поиск уникальных элементов в списке.
Напишите программу, которая создает новый список, содержащий только уникальные элементы из исходного списка.

Задача 7: Поиск подстроки.
Напишите программу, которая находит все вхождения заданной подстроки в строке с использованием встроенных функций.

Задача 8: Вычисление суммы цифр числа.
Напишите программу, которая вычисляет сумму всех цифр заданного числа, используя математические операции и деление нацело.
 */

package declarativeParadigm;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задача 3.");
        int n = 6;
        int factorial = calculateFactorial(n);
        System.out.println("Факториал числа " + n + " равен " + factorial);

        System.out.println("\nЗадача 4.");
        int[] originalArray = {1, 2, 3, 2, 4, 3, 5, 6, 5};
        int[] uniqueArray = findUniqueElements(originalArray);
        System.out.println("Исходный массив: " + Arrays.toString(originalArray));
        System.out.println("Массив с уникальными элементами: " + Arrays.toString(uniqueArray));

        System.out.println("\nЗадача 7.");
        String mainString = "тралала";
        String substring = "ла";
        int count = findSubstring(mainString, substring);
        System.out.println("Подстрока \"" + substring + "\" встречается " + count + " раз(а) в строке \"" + mainString + "\"");

        System.out.println("\nЗадача 8.");
        int number = 803719;
        int sum = calculateDigitSum(number);
        System.out.println("Сумма цифр числа " + number + " равна " + sum);
        sum = calculateDigitSumMath(number);
        System.out.println("Сумма цифр числа " + number + " равна " + sum);

    }

    public static int calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }

    public static int[] findUniqueElements(int[] inputArray) {
        return Arrays.stream(inputArray).distinct().toArray();
    }

    public static int findSubstring(String mainString, String substring) {
        int count = 0;
        int startIndex = 0;

        while (mainString.contains(substring)) {
            count++;
            startIndex = mainString.indexOf(substring) + substring.length();
            mainString = mainString.substring(startIndex);
        }
        return count;
    }

    public static int calculateDigitSum(int number) {
        String numberString = Integer.toString(number);
        int sum = 0;
        for (int i = 0; i < numberString.length(); i++) {
            char digitChar = numberString.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            sum += digit;
        }
        return sum;
    }


    // Второй вариант метода calculateDigitSum -- с использованием математических операций
    public static int calculateDigitSumMath(int number) {
        int sum = 0;

        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            number /= 10;
        }
        return sum;
    }
}
