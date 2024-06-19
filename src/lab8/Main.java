package lab8;
import java.util.concurrent.*;
public class Main {
    public static void main(String[] args) {
        int numThreads = 0;
        try {
            if (args.length < 1) {
                throw new IllegalArgumentException("Required argument: number of threads");
            }
            numThreads = Integer.parseInt(args[0]);
            if (numThreads <= 0) {
                throw new IllegalArgumentException("Number of threads must be a positive integer");
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format for number of threads: " + args[0]);
            System.err.println("Number of threads must be a positive integer");
            System.exit(1);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        ThreadFactory producerThreadFactory = new MyThreadFactory("producer - ");
        ThreadFactory consumerThreadFactory = new MyThreadFactory("consumer - ");
        ExecutorService writeService = Executors.newFixedThreadPool(numThreads, producerThreadFactory);
        ExecutorService readService = Executors.newFixedThreadPool(numThreads, consumerThreadFactory);

        for (int i = 0; i < 10; i++) {
            writeService.execute(new Producer(queue, i));
            readService.execute(new Consumer(queue));
        }

        writeService.shutdown();
        readService.shutdown();
    }
}
