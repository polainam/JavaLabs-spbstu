package lab8;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private final BlockingQueue<String> queue;
    private final int messageId;

    public Producer(BlockingQueue<String> queue, int messageId) {
        this.queue = queue;
        this.messageId = messageId;
    }

    @Override
    public void run() {
        String message = "Message = " + messageId + " from " + Thread.currentThread().getName();
        try {
            queue.put(message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
