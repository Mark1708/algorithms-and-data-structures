import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        // Генератор чисел
        Random r = ThreadLocalRandom.current();

        int size = 100;
        int maxElement = 100000;

        Integer[] integers = IntStream.generate(() -> r.nextInt(maxElement))
                .limit(size)
                .boxed()
                .toArray(Integer[]::new);

        // Элемент который необходимо найти
        int shouldBeFound = integers[r.nextInt(size - 1)];

        test(new ExponentialSearch(), integers, shouldBeFound, size, true);
    }

    private static void test(SearchAlgorithm searchAlgorithm, Integer[] integers, int shouldBeFound, int size, boolean sort) {
        System.out.println(searchAlgorithm.getClass().getName());
        if (sort)
            Arrays.sort(integers);

        int atIndex = searchAlgorithm.find(integers, shouldBeFound);

        System.out.printf(
                "Необходимо найти: %d. Найден %d под индексом %d. В массиве длиной %d%n",
                shouldBeFound, integers[atIndex], atIndex, size);
    }
}
