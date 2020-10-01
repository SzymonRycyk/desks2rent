package pl.sda.projekt_koncowy.desks2rent.domain.desk;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeskService {

    private final DeskRepository deskRepository;

    public void create(Desk desk) {
        deskRepository.getByDesknumber(desk.getDesknumber())
                .ifPresent(pat ->
                {
                    throw new IllegalStateException("Desk with the same number exists!");
                });

        deskRepository.create(desk);
    }

    public void update(Desk desk) {
        deskRepository.getByDesknumber(desk.getDesknumber())
                .filter(pat -> !pat.getId().equals(desk.getId()))
                .ifPresent(pat -> {
                    throw new IllegalStateException("Desk with the same number already exists");
                });
        deskRepository.update(desk);
    }

    public Desk getOne(int id) {
        return deskRepository.getOne(id)
                .orElseThrow(() -> new IllegalArgumentException("Desk with given number not exists"));
    }

    public List<Desk> getAll() {
        return deskRepository.getAll();
    }

    public void delete(int id){
        deskRepository.delete(id);
    }

    public Optional<Desk> getByDesknumber(int id){
        return deskRepository.getByDesknumber(id);
    }
}