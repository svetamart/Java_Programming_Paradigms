package part2.strategy;

public class SelectionSort implements iSortStrategy{
    @Override
    public int[] sort(int[] numbers) {
        int[] sorted = numbers.clone();
        for (int i = 0; i < sorted.length; i++) {
            int pos = i;
            int min = sorted[i];
            for (int j = i + 1; j < sorted.length; j++) {
                if (sorted[j] < min) {
                    pos = j;
                    min = sorted[j];
                }
            }
            sorted[pos] = sorted[i];
            sorted[i] = min;
        }
        return sorted;
    }
}
