package demo.olivares.application.service.operation.useCase;

import demo.olivares.domain.exception.OperationException;
import demo.olivares.domain.service.operation.useCase.SubstractUseCase;
import org.springframework.stereotype.Service;

@Service
public class SubstractService implements SubstractUseCase {

    @Override
    public float execute(String firstValue, String secondValue) throws OperationException {
        try {
            return ((Float.parseFloat(firstValue) - (Float.parseFloat(secondValue))));
        } catch (Exception e) {
            throw new OperationException("Substract", e.getMessage());
        }
    }

}
