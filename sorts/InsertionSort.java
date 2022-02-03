/**
 * Сортировка вставками - работает вдвое быстрее чем сортировка пузырьком за счет отсутствия перестановок
 * Скорость копирования вдвое быстрее перестановки
 * Как правило, используется на завершающих стадиях других алгоритмов (основа для сортировки Шелла)
 *
 * Сложность O(N^2)
 */
public class InsertionSort implements SortAlgorithm {
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        long start = System.nanoTime();
        T[] sorting = sorting(array);
        System.out.printf("Время выполнения: %d нс\n", System.nanoTime() - start);
        return sorting;
    }

    private <T extends Comparable<T>> T[] sorting(T[] array) {
        for (int i = 1; i < array.length; i++) {
            // копируем элемент
            T insertValue = array[i];
            int j;
            // если элементы слева больше чем скопированный, то смещаем их вправо
            for (j = i - 1; j >= 0 && SortUtils.less(insertValue, array[j]); j--) {
                array[j + 1] = array[j];
            }
            // скопированный элемент вставляется на освобожденное место
            if (j != i - 1) {
                array[j + 1] = insertValue;
            }
        }
        return array;
    }
}
