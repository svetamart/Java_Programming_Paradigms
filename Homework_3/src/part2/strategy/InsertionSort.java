package part2.strategy;

public class InsertionSort implements iSortStrategy{
    @Override
    public int[] sort(int[] numbers) {
        int[] sorted = numbers.clone();
        int j;
        for (int i = 1; i < sorted.length; i++) {
            int swap = sorted[i];
            for (j = i; j > 0 && swap < sorted[j - 1]; j--) {
                sorted[j] = sorted[j - 1];
            }
            sorted[j] = swap;
        }
        return sorted;
    }
}
