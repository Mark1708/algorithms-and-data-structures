/**
 * Двоичный поиск - один из самых популярных алгоритмов, алгоритм находит позицию целевого значения в
 * отсортированном в порядке возрастания массиве
 *
 * Средняя производительность O(log(N))
 */
public class BinarySearch implements SearchAlgorithm {

    @Override
    public <T extends Comparable<T>> int find(T[] array, T value) {
        long start = System.nanoTime();
        int search = search(array, value, 0, array.length);
        System.out.printf("Время выполнения: %d нс\n", System.nanoTime() - start);
        return search;
    }

    private <T extends Comparable<T>> int search(T[] array, T value, int left, int right) {
        if (right < left) {
            return -1; // в случае если значение не найдено
        }
        // находим медиану
        int median = (left + right) >>> 1; // (left + right) / 2
        int comp = value.compareTo(array[median]);

        if (comp == 0) {
            return median;
        } else if (comp < 0) {
            return search(array, value, left, median - 1);
        } else {
            return search(array, value, median + 1, right);
        }
    }
}
