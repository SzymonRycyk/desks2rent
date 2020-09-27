package pl.sda.projekt_koncowy.desks2rent.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "facility")
public class FacilityConfiguration {
    private Integer openingHour;
    private Integer closingHour;
}
