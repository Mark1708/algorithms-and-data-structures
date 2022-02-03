import java.util.Arrays;
import java.util.List;

public interface SortAlgorithm {

    /**
     * Главный метод сортировки массивов
     *
     * @param array - массив для сортировки
     * @return отсортированный массив
     */
    <T extends Comparable<T>> T[] sort(T[] array);

    /**
     * Вспомогательный метод для сортировки листа
     *
     * @param array - a list should be sorted
     * @return a sorted list
     */
    @SuppressWarnings("unchecked")
    default <T extends Comparable<T>> List<T> sort(List<T> array) {
        return Arrays.asList(sort(array.toArray((T[]) new Comparable[array.size()])));
    }
}
