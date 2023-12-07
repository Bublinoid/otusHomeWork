public class Main {
    public static void main(String[] args) {

        new Thread(MathServer::startServer).start();

        MathClient.serverCommunication();

    }
}