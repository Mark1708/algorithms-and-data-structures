public interface SearchAlgorithm {

    /**
     * @param value это элемент, который нужно найти
     * @param array это массив в котором будет осуществляться поиск
     * @param <T> Comparable тип
     * @return первый найденный индекс с найденным числом
     */
    <T extends Comparable<T>> int find(T[] array, T value);
}
