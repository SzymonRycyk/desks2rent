package pl.sda.projekt_koncowy.desks2rent.web.desk;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.projekt_koncowy.desks2rent.domain.desk.Desk;
import pl.sda.projekt_koncowy.desks2rent.domain.desk.DeskService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api/desk")
@RequiredArgsConstructor
public class DeskEndpoint {
    private final DeskService deskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void CreateDesk(@RequestBody @Valid Desk desk){
        deskService.create(desk);
    }

    @PutMapping
    void updateDesk(@RequestBody Desk desk){
        deskService.update(desk);
    }

    @GetMapping
    List<Desk> getAll(){
       return  deskService.getAll();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@RequestParam int id){
        deskService.delete(id);
    }

    @GetMapping("/{id}")
    Desk getById(@PathVariable int id) {
        return deskService.getOne(id);
    }
}
