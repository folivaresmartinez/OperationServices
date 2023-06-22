package demo.olivares.infrastructure.controller.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerUIConfig {
    public static final String OPERATION_SERVICE_OPENAPI_RESOURCE_LOCATION = "/api/operation-service.yml";

    @Primary
    @Bean
    public SwaggerResourcesProvider openAPIResourcesProvider() {

        List<SwaggerResource> resources = new ArrayList<>();

        return () -> {
            addToResources(resources, "Operation service API", OPERATION_SERVICE_OPENAPI_RESOURCE_LOCATION);
            return resources;
        };
    }

    public void addToResources(List<SwaggerResource> resources, String name, String location) {

        SwaggerResource wsResource = new SwaggerResource();
        wsResource.setName(name);
        wsResource.setLocation(location);
        resources.add(wsResource);
    }
}
