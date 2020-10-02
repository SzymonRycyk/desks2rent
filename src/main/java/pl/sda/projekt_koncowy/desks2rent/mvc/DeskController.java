package pl.sda.projekt_koncowy.desks2rent.mvc;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.projekt_koncowy.desks2rent.domain.desk.Desk;
import pl.sda.projekt_koncowy.desks2rent.domain.desk.DeskService;

import javax.validation.Valid;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class DeskController {
    private final DeskService deskService;

    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET})
    @PreAuthorize("isAuthenticated()")
    ModelAndView allDeskPage(){
        ModelAndView mav = new ModelAndView("desks.html");
        mav.addObject("desks", deskService.getAll());
        return mav;
    }

    @GetMapping("/addOrUpdate")
    @PreAuthorize("hasRole('ADMIN')")
    ModelAndView addDeskPage(@RequestParam(name="id", required = false) Integer id){
        ModelAndView mav = new ModelAndView("addDesk.html");
        if (id!=null){
            mav.addObject("desk", deskService.getOne(id));
        }else {
            mav.addObject("desk", new Desk());
        }
        return mav;
    }

    @GetMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    String deleteDesk(@RequestParam Integer id){
        deskService.delete(id);
        return "redirect:/Desk";
    }

    String addOrUpdateDesk(@ModelAttribute @Valid Desk desk, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "addDeskPage().html";
        }
        if (desk.getId()==null){
            deskService.create(desk);
        }else{
            deskService.update(desk);
        }
        return "redirect:/desk";
    }
}
