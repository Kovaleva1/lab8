package exceptions;

public class NotUniqueIdException extends Exception {
    @Override
    public String toString() {
        return "Такой id уже существует";
    }
}

