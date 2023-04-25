public class DataElementException extends RuntimeException{

    public DataElementException(String message) {
        super("Ошибка полноты данных: " + message);
    }
}
