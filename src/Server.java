import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {

    private static final int PORT = 5431;
    private static final Map<String, PrintWriter> clients = new HashMap<>();

    public Server() {
        start();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен на порту " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(() -> clientManagement(clientSocket)).start();
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при запуске сервера", e);
        }
    }

    private void clientManagement(Socket clientSocket) {
        try (
                Scanner in = new Scanner(clientSocket.getInputStream());
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String name = in.nextLine();
            clients.put(name, out);

            System.out.println(name + " присоединился");

            while (true) {
                try {
                    String message = in.nextLine();
                    if (message.startsWith("/w")) {
                        String[] details = message.split(" ", 3);
                        String recipient = details[1];
                        String personalMessage = details[2];
                        sendPersonalMessage(name, recipient, personalMessage.trim());
                    } else {
                        streaming(name + ": " + message);
                    }
                } catch (NoSuchElementException e) {
                    clients.remove(name);
                    System.out.println(name + " отключился");
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка взаимодействия с клиентом");
        }
    }

    private void sendPersonalMessage(String sender, String recipient, String message) {
        PrintWriter recipientWriter = clients.get(recipient);

        if (recipientWriter != null) {
            recipientWriter.println("Лично для " + sender + ": " + message);
        } else {
            System.out.println("Получатель " + recipient + " не найден.");
            PrintWriter senderWriter = clients.get(sender);
            if (senderWriter != null) {
                senderWriter.println("Получатель " + recipient + " не найден. Сообщение возвращено отправителю.");
            }
        }
    }

    private void streaming(String message) {
        List<PrintWriter> clientsToRemove = new ArrayList<>();

        for (Iterator<Map.Entry<String, PrintWriter>> iterator = clients.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<String, PrintWriter> entry = iterator.next();
            PrintWriter writer = entry.getValue();

            try {
                writer.println(message);
            } catch (Exception e) {
                clientsToRemove.add(writer);
            }
        }

        for (PrintWriter writer : clientsToRemove) {
            clients.values().remove(writer);
        }
    }
}
