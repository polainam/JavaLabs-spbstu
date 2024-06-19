package lab8;

import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {
    private final String namePrefix;
    private int counter;

    public MyThreadFactory(String namePrefix) {
        this.namePrefix = namePrefix;
        this.counter = 0;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, namePrefix + counter++);
    }
}
