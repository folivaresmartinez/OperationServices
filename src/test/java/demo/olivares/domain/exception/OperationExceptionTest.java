package demo.olivares.domain.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

class OperationExceptionTest {

    @InjectMocks
    OperationException operationException;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        operationException = new OperationException("operation", "field");
    }

    @Test
    void testOperation() {
        var result = operationException.getOperation();
        Assertions.assertEquals("operation", result);
    }

    @Test
    void testField() {
        var result = operationException.getField();
        Assertions.assertEquals("field", result);
    }


}
