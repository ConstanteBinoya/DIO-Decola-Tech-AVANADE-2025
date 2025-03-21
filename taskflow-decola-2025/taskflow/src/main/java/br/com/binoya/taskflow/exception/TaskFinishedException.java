package br.com.binoya.taskflow.exception;

public class TaskFinishedException extends RuntimeException {
    public TaskFinishedException(final String message) {
        super(message);
    }
}
