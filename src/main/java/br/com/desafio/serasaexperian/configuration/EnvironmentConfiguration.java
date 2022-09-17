package br.com.desafio.serasaexperian.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "configuration")
public class EnvironmentConfiguration {
    private String apiUser;
    private String apiSecret;

    private int jwtTimeExpiration;
    private String jwtSecret;

    private String swaggerHome;
    private String swaggerTitle;
    private String swaggerDescription;
    private String swaggerContactEmail;
    private String swaggerAppVersion;

}