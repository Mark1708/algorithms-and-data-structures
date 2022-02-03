/**
 * Поиск прыжками - алгоритм поиска, требующий предварительной сортировки в порядке возрастания
 *
 * Средняя производительность O(sqrt(N))
 */
public class JumpSearch implements SearchAlgorithm {
    @Override
    public <T extends Comparable<T>> int find(T[] array, T value) {
        long start = System.nanoTime();
        int search = search(array, value);
        System.out.printf("Время выполнения: %d нс\n", System.nanoTime() - start);
        return search;
    }

    private <T extends Comparable<T>> int search(T[] array, T value) {
        int length = array.length;
        int blockSize = (int) Math.sqrt(length); // шаг

        int limit = blockSize; // индекс на который совершается "прыжок"
        while (value.compareTo(array[limit]) > 0 && limit < array.length - 1) {
            limit = Math.min(limit + blockSize, array.length - 1);
        }

        // Линейный поиск
        for (int i = limit - blockSize; i <= limit; i++) {
            if (array[i].compareTo(value) == 0) {
                return i;
            }
        }
        return -1;
    }
}
