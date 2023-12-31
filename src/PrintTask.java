import java.util.concurrent.Semaphore;

class PrintTask implements Runnable {
    private final char charToPrint;
    private final int timesToPrint;
    private final Semaphore currentSemaphore;
    private final Semaphore nextSemaphore;

    public PrintTask(char charToPrint, int timesToPrint, Semaphore currentSemaphore, Semaphore nextSemaphore) {
        this.charToPrint = charToPrint;
        this.timesToPrint = timesToPrint;
        this.currentSemaphore = currentSemaphore;
        this.nextSemaphore = nextSemaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < timesToPrint; i++) {
            try {
                currentSemaphore.acquire();
                System.out.print(charToPrint);
                nextSemaphore.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}