package br.com.binoya.taskflow.exception;

public class TaskBlockedException extends RuntimeException {
    public TaskBlockedException(final String message) {
        super(message);
    }
}
