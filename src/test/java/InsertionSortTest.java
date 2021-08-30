import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class InsertionSortTest {
    @Test
    void sort() {
        Integer[] actual = new Random().ints(1000, 1, 1000)
                .boxed().toArray(Integer[]::new);
        Integer[] expected = Arrays.stream(actual).sorted().toArray(Integer[]::new);

        InsertionSort.sort(actual, Integer::compare);

        assertArrayEquals(expected, actual, "Wrong sorting result");
    }
}
