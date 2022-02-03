import java.util.Random;
import java.util.stream.IntStream;

/**
 * Интерполяционный поиск - алгоритм поиска, требующий предварительной сортировки в порядке возрастания
 *
 * Средняя производительность O(log(log(N)))
 */
public class InterpolationSearch {

    public int find(int[] array, int value) {
        long start = System.nanoTime();
        int search = search(array, value);
        System.out.printf("Время выполнения: %d нс\n", System.nanoTime() - start);
        return search;
    }

    private int search(int[] array, int value) {
        // Индексы начала и конца
        int start = 0;
        int end = array.length - 1;

        // Поскольку массив отсортирован, элемент, присутствующий в массиве, должен находиться в диапазоне
        while (start <= end && value >= array[start] && value <= array[end]) {
            // Позиция искомого числа считается по формуле
            int pos = start + (((end - start) / (array[end] - array[start])) * (value - array[start]));

            if (array[pos] == value) {
                return pos;
            } else if (array[pos] < value) {
                start = pos + 1;
            } else {
                end = pos - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Random r = new Random();
        int size = 100;
        int maxElement = 100000;
        int[] integers = IntStream.generate(() -> r.nextInt(maxElement)).limit(size).sorted().toArray();

        Integer shouldBeFound = integers[r.nextInt(size - 1)];

        InterpolationSearch search = new InterpolationSearch();
        int atIndex = search.find(integers, shouldBeFound);

        System.out.printf(
                "Необходимо найти: %d. Найден %d под индексом %d. В массиве длиной %d%n",
                shouldBeFound, integers[atIndex], atIndex, size);
    }
}

