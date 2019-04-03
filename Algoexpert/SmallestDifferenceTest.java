import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SmallestDifferenceTest {

    @Test
    public void TestCase1() {
        int[] expected = {28, 26};
        int[] arrayOne = {-1, 5, 10, 20, 28, 3};
        int[] arrayTwo = {26, 134, 135, 15, 17};

        assertTrue(Arrays.equals(SmallestDifference.smallestDifference(arrayOne, arrayTwo), expected));
    }

    @Test
    public void TestCase2() {
        int[] expected = {16, 15};
        int[] arrayOne = {-1, 5, 10, 16, 28, 3};
        int[] arrayTwo = {26, 134, 135, 15, 17};

        assertTrue(Arrays.equals(SmallestDifference.smallestDifference(arrayOne, arrayTwo), expected));
    }

}