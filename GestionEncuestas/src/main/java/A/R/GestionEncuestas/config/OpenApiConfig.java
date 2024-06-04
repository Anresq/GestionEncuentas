package A.R.GestionEncuestas.config;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info=
    @Info(title=" DOCUMENTACION GESTION DE ENCUESTAS"
    ,version="1.0",
    description="GestionEncuestas => Es una aplicación para la gestión y optimización de encuestas"))
public class OpenApiConfig {
    
}
