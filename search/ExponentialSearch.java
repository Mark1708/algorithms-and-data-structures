import java.util.Arrays;

/**
 * Экспоненциальный поиск - алгоритм поиска, требующий предварительной сортировки в порядке возрастания
 *
 * Средняя производительность O(log(N))
 */
public class ExponentialSearch implements SearchAlgorithm {
    @Override
    public <T extends Comparable<T>> int find(T[] array, T value) {
        long start = System.nanoTime();
        int search = search(array, value);
        System.out.printf("Время выполнения: %d нс\n", System.nanoTime() - start);
        return search;
    }

    private <T extends Comparable<T>> int search(T[] array, T value) {
        if (array[0] == value) {
            return 0;
        } else if (array[array.length - 1] == value) {
            return array.length;
        }

        int range = 1;

        while (range < array.length && array[range].compareTo(value) <= -1) {
            range = range * 2;
        }

        return Arrays.binarySearch(array, range / 2, Math.min(range, array.length), value);
    }
}
