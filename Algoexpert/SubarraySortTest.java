import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SubarraySortTest {

    @Test
    public void TestCase1() {
        int[] expectedSubarray = {2, 4};
        int[] array = {1, 2, 5, 3, 4, 6, 7};

        assertTrue(Arrays.equals(SubarraySort.subarraySort(array), expectedSubarray));
    }

    @Test
    public void TestCase2() {
        int[] expectedSubarray = {-1, -1};
        int[] array = {1, 2, 3, 4};

        assertTrue(Arrays.equals(SubarraySort.subarraySort(array), expectedSubarray));
    }

    @Test
    public void TestCase3() {
        int[] expectedSubarray = {0, 3};
        int[] array = {4, 3, 2, 1};

        assertTrue(Arrays.equals(SubarraySort.subarraySort(array), expectedSubarray));
    }

    @Test
    public void TestCase4() {
        int[] expectedSubarray = {0, 1};
        int[] array = {2, 1};

        assertTrue(Arrays.equals(SubarraySort.subarraySort(array), expectedSubarray));
    }


}