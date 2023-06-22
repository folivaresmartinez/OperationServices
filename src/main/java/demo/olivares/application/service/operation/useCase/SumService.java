package demo.olivares.application.service.operation.useCase;

import demo.olivares.domain.exception.OperationException;
import demo.olivares.domain.service.operation.useCase.SumUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SumService implements SumUseCase {

    @Override
    public float execute(String firstValue, String secondValue) throws OperationException {
        try {
            return ((Float.parseFloat(firstValue) + (Float.parseFloat(secondValue))));
        } catch (Exception e) {
            throw new OperationException("Sum", e.getMessage());
        }
    }

}
