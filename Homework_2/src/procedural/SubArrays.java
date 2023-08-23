/*
Процедурное программирование:
__
Разбиение массива на подмассивы:
__
Описание: Имеется массив чисел.
Необходимо разбить его на подмассивы так, чтобы сумма чисел в каждом подмассиве была меньше или равна заданному значению X.
Почему это процедурное программирование:
Можно создать процедуру, которая будет принимать массив и значение X,
а затем последовательно формировать подмассивы, следуя определенной логике.
Это позволяет выделить процесс создания каждого подмассива в отдельную подпрограмму, делая основной код более чистым и понятным.

Задание: Напишите функцию, которая принимает массив чисел и значение X.
Функция должна возвращать массив подмассивов так, чтобы сумма чисел в каждом подмассиве была меньше или равна X.
Входные данные:
Массив чисел длиной N.
Число X.
Выходные данные:
Массив подмассивов.
 */


package procedural;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArrays {

    public static void main(String[] args) {
        int[] array = {1, 7, 2, 8, 4, 5, 1, 6};
        int x = 10;

        int[][] subarrays = splitArray(array, x);

        System.out.println("Массив чисел: " + Arrays.toString(array));
        System.out.println("Подмассивы с суммой чисел меньшей или равной " + x + ":");
        for (int i = 0; i < subarrays.length; i++) {
            System.out.println("Подмассив " + (i + 1) + ": " + Arrays.toString(subarrays[i]));
        }
    }

    public static int[][] splitArray(int[] array, int x) {
        List<int[]> subarrays = new ArrayList<>();
        List<Integer> currentSubarray = new ArrayList<>();
        int currentSum = 0;

        for (int num : array) {
            if (num <= x) {
                if (currentSum + num <= x) {
                    currentSubarray.add(num);
                    currentSum += num;
                } else if (!currentSubarray.isEmpty()) {
                    subarrays.add(currentSubarray.stream().mapToInt(Integer::intValue).toArray());
                    currentSubarray.clear();
                    currentSubarray.add(num);
                    currentSum = num;
                }
            }
        }

        if (!currentSubarray.isEmpty()) {
            subarrays.add(currentSubarray.stream().mapToInt(Integer::intValue).toArray());
        }

        return subarrays.toArray(new int[0][]);
    }
}

