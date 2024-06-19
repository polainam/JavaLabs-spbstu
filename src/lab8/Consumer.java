package lab8;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private final BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            String message = queue.take();
            System.out.println(Thread.currentThread().getName() + " consumed: " + message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
