import java.util.Arrays;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        int number = 7;

        System.out.println("\nЗадача 1. Рекурсивная сумма");
        int sum = recursiveSum(number);
        String sumExpression = generateSumExpression(number);
        System.out.println(sumExpression + " = " + sum);

        System.out.println("\nЗадача 2. Факториал");
        int factorial = recursiveFactorial(number);
        System.out.println(number + "! = " + factorial);


        System.out.println("\nЗадача 3. Фибоначчи через рекурсию");
        System.out.print("Последовательность Фибоначчи до " + number + ": ");
        for (int i = 0; i <= number; i++) {
            System.out.print(recursiveFibonacci(i) + " ");
        }


        System.out.println("\n\nЗадача 4. Функция-редуктор");
        int[] numbers = {2, 3, 4, 5};
        int initialValue = 1;
        int product = multiplyArray(numbers, initialValue);
        System.out.println("Произведение чисел в массиве " + Arrays.toString(numbers) + " равно "+ product);


        System.out.println("\nЗадача 5. Замыкание");
        Function<Integer, Integer> multiply = createMultiplier(numbers);
        int result1 = multiply.apply(7);
        int result2 = multiply.apply(10);
        System.out.println("Массив: " + Arrays.toString(numbers));
        System.out.println("Результат 1: " + result1);
        System.out.println("Результат 2: " + result2);

    }


    /*
        Рекурсивная сумма: Напишите рекурсивную функцию, которая вычисляет сумму всех чисел от 1 до n.
        Например, для n = 5 результат должен быть 1 + 2 + 3 + 4 + 5 = 15.
         */
    public static int recursiveSum (int number) {
        if (number == 1) {
            return 1;
        } else {
            return number + recursiveSum(number - 1);
        }
    }

    public static String generateSumExpression(int n) {
        if (n == 1) {
            return "1";
        }
        return generateSumExpression(n - 1) + " + " + n;
    }

    /*
        Факториал: Напишите рекурсивную функцию для вычисления факториала числа n.
        Факториал числа n обозначается как n! и равен произведению всех положительных целых чисел от 1 до n.
         */
    public static int recursiveFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * recursiveFactorial(n - 1);
        }
    }

    /*
       Фибоначчи через рекурсию: Напишите рекурсивную функцию для вычисления числа Фибоначчи с индексом n.
        */
    public static int recursiveFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    /*
        Функция-редуктор: Напишите функцию-редуктор (или функцию свертки),
        которая принимает начальное значение и список чисел, а затем возвращает произведение всех чисел в списке.
        Используйте эту функцию для вычисления произведения чисел в списке.
         */
    public static int multiplyArray(int[] numbers, int initialValue) {
        int result = initialValue;
        for (int number : numbers) {
            result *= number;
        }
        return result;
    }

    /*
        Замыкание: Создайте функцию, которая принимает некоторое число n и возвращает функцию,
        которая прибавляет n к своему аргументу. Продемонстрируйте использование этой функции-замыкания.
         */
    public static Function<Integer, Integer> createMultiplier(int[] array) {
        return x -> {
            int result = 1;
            for (int num : array) {
                result *= num;
            }
            return x * result;
        };
    }
}
