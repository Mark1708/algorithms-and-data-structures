/**
 * Линейный поиск - самый простой алгоритм поиска, не требующий предварительной подготовки
 *
 * Средняя производительность O(N)
 */
public class LinearSearch implements SearchAlgorithm {
    @Override
    public <T extends Comparable<T>> int find(T[] array, T value) {
        long start = System.nanoTime();
        int search = search(array, value);
        System.out.printf("Время выполнения: %d нс\n", System.nanoTime() - start);
        return search;
    }

    private <T extends Comparable<T>> int search(T[] array, T value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(value) == 0) {
                return i;
            }
        }
        return -1;
    }
}
