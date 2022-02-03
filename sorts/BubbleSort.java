class BubbleSort implements SortAlgorithm {

    /**
     * Сортировка пузырьком - самый простой и известный алгоритм, но с низкой скоростью.
     *
     * Сложность O(N^2)
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        long start = System.nanoTime();
        T[] sorting = sorting(array);
        System.out.printf("Время выполнения: %d нс\n", System.nanoTime() - start);
        return sorting;
    }

    private <T extends Comparable<T>> T[] sorting(T[] array) {
        for (int i = 1, size = array.length; i < size; ++i) {
            boolean swapped = false;
            for (int j = 0; j < size - i; ++j) {
                if (SortUtils.greater(array[j], array[j + 1])) {
                    SortUtils.swap(array, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return array;
    }
}
