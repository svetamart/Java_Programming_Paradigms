import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Задача 1: Напишите программу, которая находит все простые числа в заданном диапазоне.
        int firstNumber = 4;
        int lastNumber = 83;
        int[] primeNumbers = findPrimeNumbers(firstNumber, lastNumber);
        System.out.println("Простые числа в диапазоне от " + firstNumber + " до " +
                lastNumber + ": " + Arrays.toString(primeNumbers));

        // Задача 2: Напишите программу, которая сортирует список чисел методом сортировки слиянием.
        Random rand = new Random();
        int[] array = new int[rand.nextInt(31)];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(-100, 101);
        }
        System.out.println("Исходный массив: " + Arrays.toString(array));

        int[] sortedArray = mergeSort(array);
        System.out.println("Отсортированный массив: " + Arrays.toString(sortedArray));


    }


    /*
    Задача 1: Напишите программу, которая находит все простые числа в заданном диапазоне.
    Простые числа - это числа больше 1, которые не имеют делителей, кроме 1 и самих себя.
    Задача состоит в том, чтобы написать программу, которая будет находить и выводить все простые числа в заданном диапазоне.

    Пример решения:

    Программа принимает на вход начальное и конечное числа диапазона.
    Для каждого числа в диапазоне проверяется, является ли оно простым.
    Если число простое, оно добавляется в список простых чисел.
    В конце программа выводит список найденных простых чисел.
     */
    public static int[] findPrimeNumbers (int first, int last) {
        List<Integer> prime = new ArrayList<>();
        for (int num = first; num <= last; num++) {
            if (isPrime(num)) {
                prime.add(num);
            }
        }
        int[] result = new int[prime.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = prime.get(i);
        }
        return result;
    }

    public static boolean isPrime(int number) {
        if(number < 2) return false;
        for(int i = 2; i <= number / 2; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /*
    Задача 2: Напишите программу, которая сортирует список чисел методом сортировки слиянием.

    Сортировка слиянием - это эффективный алгоритм сортировки, который разбивает список на две половины, сортирует их отдельно, а затем объединяет в отсортированный список. Задача состоит в том, чтобы написать программу, которая будет сортировать список чисел методом сортировки слиянием.

    Пример решения:

    Программа принимает на вход список чисел, который нужно отсортировать.
    Если список состоит из одного элемента или пуст, он считается уже отсортированным.
    В противном случае список разделяется на две половины.
    Рекурсивно вызывается сортировка слиянием для каждой половины.
    Затем отсортированные половины сливаются в один отсортированный список.
    Конечный отсортированный список возвращается.
     */

    public static int[] mergeSort (int[] array) {
        if (array.length <= 1) {
            return array;
        }
            int middle = array.length / 2;
            int[] left = new int[middle];
            int[] right = new int[array.length - middle];

            // Делим массив на левую и правую части
            for (int i = 0; i < middle; i++) {
                left[i] = array[i];
            }
            for (int i = middle; i < array.length; i++) {
                right[i - middle] = array[i];
            }

            // Рекурсивная сортировка левой и правой части
            left = mergeSort(left);
            right = mergeSort(right);

            // Объединяем отсортированные части
            return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftIndex = 0, rightIndex = 0, resultIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }
        while (leftIndex < left.length) {
            result[resultIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            result[resultIndex++] = right[rightIndex++];
        }
        return result;
    }
}
