package lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AbstractProgram extends Thread {

    public static final Object mutex = new Object();
    private Status status = Status.UNKNOWN;
    private final Thread daemonThread = new Thread(new DemonTaskImpl());

    private class DemonTaskImpl implements Runnable {

        private final List<Status> statuses = new ArrayList<>(List.of(Status.RUNNING, Status.STOPPING, Status.FATAL_ERROR));

        @Override
        public void run() {
            Random random = new Random();
            int millis = 3000;
            Status randomStatus;
            while (true) {
                Utils.pause(millis);
                randomStatus = statuses.get(random.nextInt(statuses.size()));
                System.out.println("Demon chose the status: " + randomStatus);
                synchronized (mutex) {
                    status = randomStatus;
                    mutex.notify();
                }
            }
        }
    }

    @Override
    public void run() {

        daemonThread.setDaemon(true);
        daemonThread.start();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
