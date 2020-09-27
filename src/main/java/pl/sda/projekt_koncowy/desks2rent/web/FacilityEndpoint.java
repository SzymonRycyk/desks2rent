package pl.sda.projekt_koncowy.desks2rent.web;

import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.projekt_koncowy.desks2rent.config.FacilityConfiguration;

public class FacilityEndpoint {

    private final FacilityConfiguration facilityConfiguration;

    @GetMapping
    String getFacilityInfo(){
        String openingHours = String.format("Open from %d to %d",
                facilityConfiguration.getOpeningHour(),
                facilityConfiguration.getClosingHour());
        return openingHours;
    }
}
