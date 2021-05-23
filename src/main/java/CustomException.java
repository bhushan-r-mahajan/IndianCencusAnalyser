public class CustomException extends Exception {

    public ExceptionType type;

    public CustomException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public enum ExceptionType {
        NO_EXTENTION_FOUND, WRONG_FILE_TYPE, WRONG_FILE_CONTENT;
    }
}
