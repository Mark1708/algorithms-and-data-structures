/**
 * Сортировка слиянием - выполняется намного быстрее чем сортировка пузырьком, вставками и выбором.
 * Однако есть недостаток в том, что требуется выделять память
 *
 * Сложность O(N * log(N)) <- крутой показатель
 */
public class MergeSort implements SortAlgorithm {
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        long start = System.nanoTime();
        doSort(array, 0, array.length - 1);
        System.out.printf("Время выполнения: %d нс\n", System.nanoTime() - start);
        return array;
    }


    private static <T extends Comparable<T>> void doSort(T[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) >>> 1; // индекс числа посередине
            // выполняем сортировку двух половин массива
            doSort(arr, left, mid);
            doSort(arr, mid + 1, right);
            // выполняем слияние
            merge(arr, left, mid, right);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] arr, int left, int mid, int right) {
        int length = right - left + 1;

        // выделяем память, создав новый массив
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Comparable[length];
        int i = left;
        int j = mid + 1;
        int k = 0;

        // до тех пор, пока не перепишется один из массивов
        while (i <= mid && j <= right) {
            // 1, 2, 4
            // 3, 1, 4
            // 1 < 3, следовательно, сохраняем в общий массив 1 и увеличиваем счетчики i и k
            if (arr[i].compareTo(arr[j]) <= 0) {
                temp[k++] = arr[i++];
            } else { // в этом случае увеличиваем счетчики j и k
                temp[k++] = arr[j++];
            }
        }

        // После того как один массив полностью сохранён в общий,
        // второй - мы записываем последовательно в конец общего массива
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // копируем массив после слияния в изначальный
        System.arraycopy(temp, 0, arr, left, length);
    }
}
