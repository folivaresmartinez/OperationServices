package demo.olivares.infrastructure.controller.configuration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SwaggerUIConfigTest {
    SwaggerUIConfig swaggerUIConfig = new SwaggerUIConfig();

    @Test
    void testOpenAPIResourcesProvider() {
        var result = swaggerUIConfig.openAPIResourcesProvider();
        assertNotNull(result);
    }

    @Test
    void testAddToResources() {
        assertDoesNotThrow(() -> swaggerUIConfig.addToResources(new ArrayList<>(), "name", "location"));
    }

    @Test
    void testopenAPIResourcesProvider() {

        var result = swaggerUIConfig.openAPIResourcesProvider();
        assertNotNull(result);
    }
}

