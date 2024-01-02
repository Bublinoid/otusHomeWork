import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayOperationsTest {

    @Test
    public void testOperationArray() {
        ArrayOperations operations = new ArrayOperations();

        int[] inputArray1 = {1, 2, 1, 2, 2};
        int[] resultArray1 = operations.operationArray(inputArray1);
        assertArrayEquals(new int[]{2, 2}, resultArray1);

        int[] inputArray2 = {2, 2, 2, 2};
        assertThrows(RuntimeException.class, () -> operations.operationArray(inputArray2));
    }

    @Test
    public void testIsArrayValid() {
        ArrayOperations operations = new ArrayOperations();

        int[] validArray1 = {1, 2};
        assertTrue(operations.isArrayValid(validArray1));

        int[] invalidArray1 = {1, 1};
        assertFalse(operations.isArrayValid(invalidArray1));

        int[] invalidArray2 = {1, 3};
        assertFalse(operations.isArrayValid(invalidArray2));

        int[] validArray2 = {1, 2, 2, 1};
        assertTrue(operations.isArrayValid(validArray2));

        int[] resultArray = operations.operationArray(invalidArray1);

    }
}
