public class BinarySearch {
    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 7;
        int result = binarySearch(sortedArray, target);

        if (result != -1) {
            System.out.println("Элемент " + target + " найден по индексу " + result);
        } else {
            System.out.println("Элемент " + target + " не найден в массиве.");
        }
    }

    /*
    Алгоритм бинарного поиска.
    На вход подаётся целочисленный массив и число.
    На выходе - индекс элемента или -1, в случае если искомого элемента нет в массиве.
     */
    public static int binarySearch (int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Если центральный элемент равен искомому, то он найден
            if (numbers[mid] == target) {
                return mid;
            }

            // Если центральный элемент больше искомого, ищем в левой половине
            if (numbers[mid] > target) {
                right = mid - 1;
            }

            // Если центральный элемент меньше искомого, ищем в правой половине
            else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
