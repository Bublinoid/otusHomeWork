    public class ArrayOperations {

        public int[] operationArray(int[] inputArray) {
            boolean foundOne = false;
            int count = 0;

            for (int i = inputArray.length - 1; i >= 0; i--) {
                if (inputArray[i] == 1) {
                    foundOne = true;
                    break;
                }
                count++;
            }
            if (!foundOne) {
                throw new RuntimeException("Массив не содержит единицы");
            }
            int[] resultArray = new int[count];
            System.arraycopy(inputArray, inputArray.length - count, resultArray, 0, count);
            return resultArray;
        }

        public boolean isArrayValid(int[] inputArray) {
            boolean containsOne = false;
            boolean containsTwo = false;

            for (int number : inputArray) {
                if (number != 1 && number != 2) {
                    return false;
                }

                if (number == 1) {
                    containsOne = true;
                } else {
                    containsTwo = true;
                }
            }

            return containsOne && containsTwo;
        }
    }
