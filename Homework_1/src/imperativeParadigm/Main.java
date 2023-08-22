/* Задача 1: Подсчет суммы четных чисел от 1 до N.
   Напишите программу, используя цикл, которая находит сумму всех четных чисел в диапазоне от 1 до заданного числа N.

   Задача 2: Поиск наименьшего числа в списке.
   Напишите программу, которая находит наименьшее число в заданном списке с помощью цикла.

   Задача 5: Поиск простых чисел.
   Напишите программу, которая находит все простые числа в заданном диапазоне от 1 до N.

   Задача 6: Упорядочивание списка.
   Напишите программу, которая сортирует список чисел в порядке возрастания с использованием пузырьковой сортировки или другого метода сортировки.
 */

package imperativeParadigm;

public class Main {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Задача 1.");
        System.out.printf("Cумма чисел от 1 до %d равна %d \n", n, evenNumbersSum(n));

        System.out.println("\nЗадача 2.");
        int[] numbers = {1, 4, 10, -21, 5, 48, 11, 2};
        System.out.print("Список чисел: ");
        printArray(numbers);
        System.out.println("Минимальное число: " + findMinNumber(numbers));


        System.out.println("\nЗадача 5.");
        int num = 83;
        int[] primeNumbers = findPrimeNumbers(num);
        System.out.print("Простые числа от 1 до " + num + ": ");
        printArray(primeNumbers);

        System.out.println("\nЗадача 6.");
        int[] array = {45, 23, 67, 12, 89, 34, 56, 29, 8, 51};
        System.out.print("Исходный массив: ");
        printArray(array);
        bubbleSort(array);
        System.out.print("Отсортированный массив: ");
        printArray(array);

    }

    public static int evenNumbersSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static int findMinNumber (int[] numbers) {
        int min = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    public static int[] findPrimeNumbers(int N) {
        int[] primeNumbers = new int[N];
        int primeCount = 0;

        for (int num = 2; num <= N; num++) {
            boolean isPrime = true;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeNumbers[primeCount] = num;
                primeCount++;
            }
        }
        int[] result = new int[primeCount];
        for (int i = 0; i < primeCount; i++) {
            result[i] = primeNumbers[i];
        }
        return result;
    }

    public static void bubbleSort(int[] arr) {
       for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
