package demo.olivares.application.service.operation.useCase;

import demo.olivares.domain.exception.OperationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class SubstractServiceTest {

    private final String FIRST_VALUE_VALID = "10";
    private final String FIRST_VALUE_INVALID = "XX";
    private final String SECOND_VALUE_VALID = "5";
    private final String SECOND_VALUE_INVALID = "XX";
    private final float SUBSTRACT_EXPECTED_VALUE = 5f;

    SubstractService substractService = new SubstractService();

    @Test
    @DisplayName("Test substract operation with valid input values , expected ok")
    void testExecuteSubstractWithValidParams() {
        var result = substractService.execute(FIRST_VALUE_VALID, SECOND_VALUE_VALID);

        Assertions.assertEquals(SUBSTRACT_EXPECTED_VALUE, result);
    }

    @Test
    @DisplayName("Test substract operation with first param invalid, expected OperationException")
    void testExecuteAddWithNotValidFirstParam() {
        Executable execution = () -> substractService.execute(FIRST_VALUE_INVALID, SECOND_VALUE_VALID);

        assertThrows(OperationException.class, execution);
    }

    @Test
    @DisplayName("Test add operation with second param invalid, expected OperationException")
    void testExecuteAddWithNotValidSecondParam() {
        Executable execution = () -> substractService.execute(FIRST_VALUE_VALID, SECOND_VALUE_INVALID);

        assertThrows(OperationException.class, execution);
    }

    @Test
    @DisplayName("Test substract operation with peration with two params invalids, expected OperationException")
    void testExecuteAddWithNotValidParams() {
        Executable execution = () -> substractService.execute(FIRST_VALUE_INVALID, SECOND_VALUE_INVALID);

        assertThrows(OperationException.class, execution);
    }
}

