package demo.olivares.domain.service.operation.useCase;

import demo.olivares.domain.exception.OperationException;

public interface SubstractUseCase {
    float execute(String firstValue, String secondValue) throws OperationException;
}