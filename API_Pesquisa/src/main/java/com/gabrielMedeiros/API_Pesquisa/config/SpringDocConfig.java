package com.gabrielMedeiros.API_Pesquisa.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    /*http://localhost:8080/swagger-ui.html*/

    @Bean
    public OpenAPI customOpenAPI(){
        System.out.println("Configuração do SpringDoc carregada!");
        return new OpenAPI()
                .info(new Info()
                        .title("API de Pesquisa de Operadoras")
                        .description("Esta API permite buscar operadoras de saúde por nome, CNPJ, modalidade, cidade etc.")
                        .version("V1.0")
                        .contact(new Contact()
                                .name("Gabriel Medeiros de Mendonça")
                                .email("gmedeiros144@gmail.com")
                                .url("https://github.com/gabriel-afd")
                        ));
    }
}
