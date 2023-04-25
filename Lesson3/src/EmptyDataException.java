class EmptyDataException extends RuntimeException{

    public EmptyDataException(String message) {
        super("Ошибка пустой строки" + message);
    }
}
