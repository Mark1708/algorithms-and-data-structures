/**
 * Сортировка Шелла - алгоритм сортировки, основанный на сортировке вставками.
 * Считается оптимальной для массивов среднего размера (до 1000 элементов) и часто применяется на практике.
 *
 * Сложность варьируется от O(N * log(N)) до O(N^2), зависит от h.
 */
public class ShellSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        long start = System.nanoTime();
        T[] sorting = sorting(array);
        System.out.printf("Время выполнения: %d нс\n", System.nanoTime() - start);
        return sorting;
    }

    private <T extends Comparable<T>> T[] sorting(T[] array) {
        int length = array.length;
        int gap = 1;

        // подсчет оптимального значения gap по формуле h = 3h + 1
        while (gap < length / 3) {
            gap = 3 * gap + 1;
        }

        // сначала сортируем элементы на расстоянии gap
        for (; gap > 0; gap /= 3) {
            // делаем сортировку в диапазоне от gap до array.length
            for (int i = gap; i < length; i++) {
                int j;
                T temp = array[i]; // копируем элемент
                // пока j < gap и скопированный элемент меньше чем элемент на расстоянии gap, то двигаемся дальше
                for (j = i; j >= gap && SortUtils.less(temp, array[j - gap]); j -= gap) {
                    array[j] = array[j - gap];
                }
                // затем вставляем на свободное место скопированный элемент
                array[j] = temp;
            }
        }
        return array;
    }
}
