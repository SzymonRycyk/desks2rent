package pl.sda.projekt_koncowy.desks2rent.mvc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.projekt_koncowy.desks2rent.config.FacilityConfiguration;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class MainPageController {

    private  final FacilityConfiguration facilityConfiguration;

    @GetMapping("/")
    ModelAndView mainPage(){
        ModelAndView maw = new ModelAndView("main.html");
        maw.addObject("date", LocalDate.now().toString());
        maw.addObject("config", facilityConfiguration);
        maw.addObject("openHour", facilityConfiguration.getOpeningHour());
        maw.addObject("closeHour", facilityConfiguration.getClosingHour());
        return maw;
    }
}
