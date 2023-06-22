package demo.olivares.infrastructure.controller.configuration;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class SwaggerUIControllerTest {
    SwaggerUIController swaggerUIController = new SwaggerUIController();

    @Test
    void testRedirect() {
        String result = swaggerUIController.redirect();
        assertThat(result).isNotEmpty();
    }
}

