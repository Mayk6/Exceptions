public class InvalidValueException extends RuntimeException{

    public InvalidValueException(String message) {
        super("Ошибка корректности данных: " + message);
    }

}
