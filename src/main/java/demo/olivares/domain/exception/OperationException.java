package demo.olivares.domain.exception;

import lombok.Getter;

@Getter

public class OperationException extends NumberFormatException {

    private final String operation;
    private final String field;

    private static final String ERROR_OPERATION = "An error has occurred in operation ";
    private static final String ERROR_FIELD = ", Error ";

    public OperationException(String operation, String field) {
        super(ERROR_OPERATION + operation + ERROR_FIELD + field);
        this.operation = operation;
        this.field = field;
    }
}
