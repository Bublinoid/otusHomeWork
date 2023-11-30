public class ArrayProcess {

    public static int arrayProcess(String[][] array) throws AppArraySizeException, AppArrayDataException {

        if (array.length != 4 || array[0].length != 4 || array[1].length != 4 || array[2].length != 4 || array[3].length != 4) {
            throw new AppArraySizeException("Некорректный размер массива, ожидается массив 4х4");
        }

        int sum = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException("Ошибка данных в ячейке [" + i + "][" + j + "]. Неверные данные: " + array[i][j]);
                }
            }
        }
        return sum;
    }
}

