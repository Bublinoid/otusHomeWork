import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MathClient {

    public static void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(5432);
            System.out.println("Сервер запущен. Ожидание подключения...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиент подключен: " + clientSocket.getInetAddress().getHostAddress());

            BufferedReader on = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            out.println("Доступны операции: +, -, *, /");

            String request = on.readLine();
            System.out.println("Клиент: " + request);

            try {
                String[] details = request.split(" ");
                double operations = Double.parseDouble(details[0]);
                char operations1 = details[1].charAt(0);
                double operations2 = Double.parseDouble(details[2]);

                double result = performTheOperation(operations, operations1, operations2);
                out.println("Результат: " + result);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException | ArithmeticException e) {
                out.println("Ошибка. Введите корректное данные");
            }
            clientSocket.close();
        }

        } catch (IIOException e) {
            e.printStackTrace();
        }
    }

    private static double performTheOperation(double operations, double operations1, char operations2) {
        switch (operations2) {
            case '+':
                return operations + operations1;
            case '-':
                return operations - operations1;
            case '*':
                return operations * operations1;
            case '/':
                if(operations1 != 0) {
                    return operations / operations1;
                } else {
                    throw new ArithmeticException("Нельзя делить на нулл.");
                }
            default:
                throw new IllegalArgumentException("Такой операции нет:" + operations2);
        }
    }
}
