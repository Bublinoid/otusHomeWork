import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);

        Runnable taskA = new PrintTask('A', 5, semaphoreA, semaphoreB);
        Runnable taskB = new PrintTask('B', 5, semaphoreB, semaphoreC);
        Runnable taskC = new PrintTask('C', 5, semaphoreC, semaphoreA);

        executorService.submit(taskA);
        executorService.submit(taskB);
        executorService.submit(taskC);

        executorService.shutdown();
    }
}