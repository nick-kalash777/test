package strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortStrategyTest {
    private SelectionSortStrategy<Integer> sorter;

    @BeforeEach
    void setUp() {
        sorter = new SelectionSortStrategy<>();
    }

    @Test
    void testSortAlreadySortedArray() {
        Integer[] array = {1, 2, 3, 4, 5};
        sorter.sort(array);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    void testSortReverseSortedArray() {
        Integer[] array = {5, 4, 3, 2, 1};
        sorter.sort(array);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    void testSortArrayWithDuplicates() {
        Integer[] array = {3, 5, 2, 3, 1, 5, 4};
        sorter.sort(array);
        assertArrayEquals(new Integer[]{1, 2, 3, 3, 4, 5, 5}, array);
    }

    @Test
    void testSortEmptyArray() {
        Integer[] array = {};
        sorter.sort(array);
        assertArrayEquals(new Integer[]{}, array);
    }

    @Test
    void testSortSingleElementArray() {
        Integer[] array = {42};
        sorter.sort(array);
        assertArrayEquals(new Integer[]{42}, array);
    }

    @Test
    void testSortArrayWithNegativeNumbers() {
        Integer[] array = {1, -1, 0, -3, 5};
        sorter.sort(array);
        assertArrayEquals(new Integer[]{-3, -1, 0, 1, 5}, array);
    }
}