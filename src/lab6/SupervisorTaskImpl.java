package lab6;

import static lab6.AbstractProgram.mutex;

public class SupervisorTaskImpl implements Runnable {

    public AbstractProgram controlledProgram;

    public SupervisorTaskImpl(AbstractProgram controlledProgram) {
        this.controlledProgram = controlledProgram;
    }

    private void stopTheProgram(AbstractProgram controlledProgram) {
        controlledProgram.interrupt();
        System.out.println("The supervisor stopped the program\n");
    }

    private void restartTheProgram() {
        controlledProgram.setStatus(Status.RUNNING);
        System.out.println("Supervisor restarted the program");
    }

    @Override
    public void run() {
        System.out.println("Initial status of an abstract program: " + controlledProgram.getStatus());
        Status oldStatus = controlledProgram.getStatus();
        controlledProgram.start();
        while (!controlledProgram.isInterrupted()) {
            synchronized (mutex) {
                while (controlledProgram.getStatus().equals(oldStatus)) {
                    try {
                        mutex.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                Status currentStatus = controlledProgram.getStatus();
                System.out.println("Abstract program changed status: " + currentStatus + '\n');
                if (currentStatus.equals(Status.STOPPING)) {
                    restartTheProgram();
                    currentStatus = controlledProgram.getStatus();
                    System.out.println("Abstract program changed status: " + currentStatus + '\n');
                }
                else if (currentStatus.equals(Status.FATAL_ERROR)) {
                    stopTheProgram(controlledProgram);
                }
                oldStatus = currentStatus;
            }
        }
    }
}
