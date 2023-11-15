package lab4.exceptions;

public class InvalidFileFormatException extends Exception {
    private final int lineNumber;

    public InvalidFileFormatException(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public InvalidFileFormatException(int lineNumber, String message) {
        super(message);
        this.lineNumber = lineNumber;
    }

    public int getLineNumber() {
        return lineNumber;
    }
}
