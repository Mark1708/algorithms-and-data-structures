/**
 * Гномья сортировка - алгоритм, которой является смесью сортировки вставками и пузырьком. На практике применяется редко.
 *
 * Сложность O(N^2)
 */
public class GnomeSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        long start = System.nanoTime();
        T[] sorting = sorting(array);
        System.out.printf("Время выполнения: %d нс\n", System.nanoTime() - start);
        return sorting;
    }

    private <T extends Comparable<T>> T[] sorting(T[] array) {
        int i = 1;
        int j = 2;
        while (i < array.length) {
            // Если элемент меньше чем следующий, то сдвигаем ссылки на 1 элемент вправо
            if (SortUtils.less(array[i - 1], array[i])) {
                i = j++;
            } else {
                // Иначе меняем местами
                SortUtils.swap(array, i - 1, i);
                // сдвигаем налево до нуля
                if (--i == 0) {
                    i = j++;
                }
            }
        }

        return array;
    }
}
