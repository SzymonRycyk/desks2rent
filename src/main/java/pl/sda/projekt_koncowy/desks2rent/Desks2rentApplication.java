package pl.sda.projekt_koncowy.desks2rent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pl.sda.projekt_koncowy.desks2rent.config.FacilityConfiguration;

@SpringBootApplication
@EnableConfigurationProperties({FacilityConfiguration.class})
public class Desks2rentApplication {

    public static void main(String[] args) {
        SpringApplication.run(Desks2rentApplication.class, args);
    }

}
