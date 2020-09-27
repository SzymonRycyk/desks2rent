package pl.sda.projekt_koncowy.desks2rent.web.desk;

import org.springframework.web.bind.annotation.*;
import pl.sda.projekt_koncowy.desks2rent.domain.desk.Desk;
import pl.sda.projekt_koncowy.desks2rent.domain.desk.DeskService;

import javax.validation.Valid;

public class DeskEndpoint {
    private final DeskService deskService;


    @PostMapping
    @ResponseStatus
    void CreateDesk(@RequestBody @Valid Desk desk){
        deskService.create(desk);
    }

    @GetMapping("/{id}")
    Desk getById(@PathVariable int id) {
        return DeskService.getOne(id);
    }
}
