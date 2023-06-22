package demo.olivares.config;

import io.corp.calculator.TracerImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BeansConfigurationTest {
    BeansConfiguration beansConfiguration = new BeansConfiguration();

    @Test
    void testTracerImpl() {
        TracerImpl result = beansConfiguration.tracerImpl();
        assertNotNull(result);
    }
}
