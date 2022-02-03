import java.util.Arrays;
import java.util.List;

public interface SortAlgorithm {

    /**
     * Главный метод сортировки массивов
     *
     * @param unsorted - массив для сортировки
     * @return отсортированный массив
     */
    <T extends Comparable<T>> T[] sort(T[] unsorted);

    /**
     * Вспомогательный метод для сортировки листа
     *
     * @param unsorted - a list should be sorted
     * @return a sorted list
     */
    @SuppressWarnings("unchecked")
    default <T extends Comparable<T>> List<T> sort(List<T> unsorted) {
        return Arrays.asList(sort(unsorted.toArray((T[]) new Comparable[unsorted.size()])));
    }
}
