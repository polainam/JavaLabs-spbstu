package lab6;

public class Main {
    public static void main(String[] args) {
        AbstractProgram abstractProgram = new AbstractProgram();
        Thread supervisorThread = new Thread(new SupervisorTaskImpl(abstractProgram));
        supervisorThread.start();
    }
}
