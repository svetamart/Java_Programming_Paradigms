/*
Стратегия:
Реализуйте паттерн Стратегия на языке Python для сортировки списка чисел.
Создайте класс SortStrategy, имеющий метод sort(numbers),
и несколько конкретных стратегий для различных методов сортировки (например, пузырьковая сортировка, сортировка выбором).
 */

package part2.strategy;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[rand.nextInt(26)];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(-100, 101);
        }

        BubbleSort bubbleSort = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();
        InsertionSort insertionSort = new InsertionSort();

        int[] bubble = bubbleSort.sort(numbers);
        int[] selection = selectionSort.sort(numbers);
        int[] insertion = insertionSort.sort(numbers);

        System.out.println("Исходный массив: " + Arrays.toString(numbers));
        System.out.println("Сортировка пузырьком: " + Arrays.toString(bubble));
        System.out.println("Сортировка выбором: " + Arrays.toString(selection));
        System.out.println("Сортировка вставками: " + Arrays.toString(insertion));
    }
}
