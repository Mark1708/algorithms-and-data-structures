
public class Main {
    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();

        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        test(sort, integers);

        String[] strings = {"c", "a", "e", "b", "d", "e", "p", "s", "l"};
        test(sort, strings);
    }

    private static <T extends Comparable<T>> void test(SortAlgorithm sortAlgorithm, T[] array) {
        System.out.println(sortAlgorithm.getClass().getName());
        T[] sort = sortAlgorithm.sort(array);
        for (int i = 0; i < array.length - 1; i++) {
            assert array[i].compareTo(array[i + 1]) <= 0;
        }
        SortUtils.print(sort);
    }
}
