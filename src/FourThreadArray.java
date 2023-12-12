import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FourThreadArray {

    private static long startTime;

    public static void RunFourThreadArray() {

        startTime = System.currentTimeMillis();
        int arraySize = 100_000_000;
        double[] array = new double[arraySize];

        int numberThread = 4;
        ExecutorService executorService = Executors.newFixedThreadPool(numberThread);

        Thread[] threads = new Thread[numberThread];
        for (int i = 0; i < numberThread; i++) {
            int thread = i;
            executorService.submit(() -> fillTheArray(array, numberThread, thread));
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            }
            printTime();
        }



    private static void fillTheArray(double[] array, int numThreads, int threadNumber) {
        for (int i = threadNumber; i < array.length; i += numThreads) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
    }

    private static void printTime() {

        long endTime = System.currentTimeMillis();
        double seconds = (endTime - startTime) / 1_000.0;
        System.out.println("Время выполнения в четырех потоках: " + seconds + " с");
    }
}
