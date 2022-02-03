/**
 * Сортировка выбором - работает быстрее чем сортировка пузырьком, но на практике не применяется из-за низкой скорости
 *
 * Сложность O(N^2)
 */
public class SelectionSort implements SortAlgorithm {
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        long start = System.nanoTime();
        T[] sorting = sorting(array);
        System.out.printf("Время выполнения: %d нс\n", System.nanoTime() - start);
        return sorting;
    }

    private <T extends Comparable<T>> T[] sorting(T[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[minIndex].compareTo(array[j]) > 0) {
                    minIndex = j; // находим индекс минимального значения
                }
            }
            // если индекс минимального числа не совпадает с i, то меняем местами
            if (minIndex != i) {
                SortUtils.swap(array, i, minIndex);
            }
        }
        return array;
    }
}
