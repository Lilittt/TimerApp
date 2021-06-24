package common.exceptions;

public class InvalidTimeException extends RuntimeException {
    @Override
    public String toString() {
        return "Invalid time format";
    }
}
