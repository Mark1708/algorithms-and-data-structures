import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

/**
 * Сортировка подсчетом - алгоритм сортировки, простой в реализации, но требует выделения дополнительной памяти.
 * K - максимальный элемент массива
 *
 * Сложность O(N + K)
 */
class CountingSort {

    // Сортировка массива
    public int[] sort(int[] array) {
        long start = System.nanoTime();
        int[] sorting = sorting(array);
        System.out.printf("Время выполнения: %d нс\n", System.nanoTime() - start);
        return sorting;
    }

    private int[] sorting(int[] array) {
        int maxValue = Integer.MIN_VALUE;
        // Находим максимум
        for (int num : array)
            if (num > maxValue)
                maxValue = num;

        // создаём доп массив
        int numCounts[] = new int[maxValue + 1];
        // записываем количество чисел из главного массива в массив с индексами
        for (int num : array)
            numCounts[num]++;

        // создаём отсортированный массив
        int[] sortedArray = new int[array.length];
        int currentSortedIndex = 0;

        // записываем в созданный массив значения в порядке возрастания
        for (int n = 0; n < numCounts.length; n++) {
            int count = numCounts[n];
            for (int k = 0; k < count; k++)
                sortedArray[currentSortedIndex++] = n;
        }
        return sortedArray;
    }

    // Сортировка листа
    public <T extends Comparable<T>> List<T> sort(List<T> array) {
        long start = System.nanoTime();
        List<T> sorting = sorting(array);
        System.out.printf("Время выполнения: %d нс\n", System.nanoTime() - start);
        return sorting;
    }

    private <T extends Comparable<T>> List<T> sorting(List<T> list) {
        // map для подсчета
        Map<T, Integer> frequency = new TreeMap<>();
        // финальный список
        List<T> sortedArray = new ArrayList<>(list.size());

        // подсчет повторяющихся объектов
        list.forEach(v -> frequency.put(v, frequency.getOrDefault(v, 0) + 1));

        // заполнение списка
        for (Map.Entry<T, Integer> element : frequency.entrySet()) {
            for (int j = 0; j < element.getValue(); j++) {
                sortedArray.add(element.getKey());
            }
        }

        return sortedArray;
    }

    // Сортировка листа с помощью stream
    private static <T extends Comparable<T>> List<T> streamSort(List<T> list) {
        return list.stream()
                .collect(toMap(k -> k, v -> 1, (v1, v2) -> v1 + v2, TreeMap::new))
                .entrySet()
                .stream()
                .flatMap(entry -> IntStream.rangeClosed(1, entry.getValue()).mapToObj(t -> entry.getKey()))
                .collect(toList());
    }
}
