/*
Императивная vs Декларативная парадигма:
Опишите задачу на Python, решение которой может быть представлено как императивное решение и как декларативное решение.
Объясните, в чем различие между двумя подходами и какой из них предпочтительнее в данном случае.
 */

package part1.imperativeVsDeclarative;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ImperativeVsDeclarative {

    public static void main(String[] args) {
        // Задача 1: Подсчитать количество уникальных слов в тексте.
        String text = """
                Вот дом,
                Который построил Джек.
                А это пшеница,
                Которая в тёмном чулане хранится
                В доме,
                Который построил Джек.
                А это весёлая птица-синица,
                Которая часто ворует пшеницу,
                Которая в тёмном чулане хранится
                В доме,
                Который построил Джек.
                Вот кот,
                Который пугает и ловит синицу,
                Которая часто ворует пшеницу,
                Которая в тёмном чулане хранится
                В доме,
                Который построил Джек.
                Вот пёс без хвоста,
                Который за шиворот треплет кота,
                Который пугает и ловит синицу,
                Которая часто ворует пшеницу,
                Которая в тёмном чулане хранится
                В доме,
                Который построил Джек.""";

        long startTime = System.currentTimeMillis();
        int resultImperative = countUniqueWordsImperative(text);
        long endTime = System.currentTimeMillis();
        double totalTimeInSeconds = (endTime - startTime) / 1000.0;

        System.out.printf("Императивный подход. Количество уникальных слов в тексте: %d\n", resultImperative);
        System.out.printf("Время выполнения программы: %.5f секунд\n", totalTimeInSeconds);

        startTime = System.currentTimeMillis();
        long resultDeclarative = countUniqueWordsDeclarative(text);
        endTime = System.currentTimeMillis();
        totalTimeInSeconds = (endTime - startTime) / 1000.0;

        System.out.printf("Декларативный подход. Количество уникальных слов в тексте: %d\n", resultDeclarative);
        System.out.printf("Время выполнения программы: %.5f секунд\n\n", totalTimeInSeconds);

        // Задача 2: Проверить, есть ли хотя бы одно отрицательное число в списке.

        Random rand = new Random();
        int[] array = new int[rand.nextInt(101)];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(-10, 1000);
        }

        startTime = System.currentTimeMillis();
        boolean resNumberImperative = containsNegativeImperative(array);
        endTime = System.currentTimeMillis();
        totalTimeInSeconds = (endTime - startTime) / 1000.0;

        System.out.println("Императивный подход. Массив: " + Arrays.toString(array));
        System.out.println("Содержит отрицательные числа: " + resNumberImperative);
        System.out.printf("Время выполнения программы: %.8f секунд\n", totalTimeInSeconds);

        startTime = System.currentTimeMillis();
        boolean resNumberDeclarative = containsNegativeDeclarative(array);
        endTime = System.currentTimeMillis();
        totalTimeInSeconds = (endTime - startTime) / 1000.0;

        System.out.println("Декларативный подход. Массив: " + Arrays.toString(array));
        System.out.println("Содержит отрицательные числа: " + resNumberDeclarative);
        System.out.printf("Время выполнения программы: %.8f секунд\n", totalTimeInSeconds);

    }

        /*
    Задача 1: Подсчитать количество уникальных слов в тексте.

    В императивном подходе мы разбиваем текст на слова, затем используем цикл for для добавления каждого слова в множество uniqueWords.
    В конечном итоге возвращаем размер множества.
    В декларативном подходе мы сначала разбиваем текст на слова и создаем поток слов.
    Убираем все заглавные буквы с помощью map(String::toLowerCase),
    затем с помощью метода distinct() убираем дубликаты и считаем количество уникальных слов с помощью метода count().

    Декларативный подход более компактен и выразителен.
    Он позволяет описать операцию подсчета уникальных слов всего в одну строку.
    Время работы методов практически одинаковое, но также стоит отметить, что декларативный подход работает немного быстрее.
     */

    // Императивный подход:
    public static int countUniqueWordsImperative(String text) {
        String[] words = text.split("\\P{L}+");
            Set<String> uniqueWords = new HashSet<>();
            for (String word : words) {
                uniqueWords.add(word.toLowerCase());
            }
            return uniqueWords.size();
            }

    // Декларативный подход:
    public static long countUniqueWordsDeclarative(String text) {
        return Arrays.stream(text.split("\\P{L}+"))
                .map(String::toLowerCase) // приводим все слова к нижнему регистру
                .distinct()
                .count();
    }


    /*
    Задача 2: Проверить, есть ли хотя бы одно отрицательное число в списке.

    В данной задаче императивный подход показал себя более быстрым, простым и понятным.
    Мы просто идем по каждому элементу массива и проверяем, является ли он отрицательным.
    Как только находим хотя бы одно отрицательное число, возвращаем true. Если таких чисел нет, возвращаем false.

    Декларативный подход тоже корректно работает, но для проверки условия он использует поток чисел и метод anyMatch().
    Таким образом мы создаем дополнительный поток, который проверяет условие для каждого элемента,
    что усложняет программу и делает ее менее эффективной.
     */

    //    Императивный подход:
    public static boolean containsNegativeImperative(int[] array) {
        for (int num : array) {
            if (num < 0) {
                return true;
            }
        }
        return false;
    }


    //    Декларативный подход:
    public static boolean containsNegativeDeclarative(int[] array) {
        return Arrays.stream(array).anyMatch(num -> num < 0);
    }


}

