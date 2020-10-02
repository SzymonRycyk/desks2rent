package pl.sda.projekt_koncowy.desks2rent.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.projekt_koncowy.desks2rent.config.FacilityConfiguration;

@RestController
@RequestMapping("/facility")
@RequiredArgsConstructor
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
