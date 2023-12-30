import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       final Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя файла: ");
        String fileName = scanner.nextLine();

        System.out.println("Введите требуюмую последовательно символов: ");
        String sequence = scanner.nextLine();

        scanner.close();

        FileOperations fileOperations = new FileOperations();
        int character = fileOperations.characterCount(fileName, sequence);

        System.out.println("Количество вхождений: " + character);

    }
}

