public class Main {
    public static void main(String[] args) {

        new Thread(() -> {
            Server server = new Server();
            server.start();
        }).start();

        Client tom = new Client("tom");
        tom.start();
        tom.sendPersonalMessage("tom", "Hello");

        tom.disconnect();
    }
}
