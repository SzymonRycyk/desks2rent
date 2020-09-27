package pl.sda.projekt_koncowy.desks2rent.domain.desk;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeskService {

    private final DeskRepository deskRepository;

    public void create(Desk desk) {
        deskRepository.getByDesknumber(desk.getDesknumber())
                .ifPresent(pat ->
                {throw new IllegalStateException("Desk with the same number exists!");});

        deskRepository.create(desk);
    }

    public static Desk getOne(int id) {
        return DeskRepository.getOne(id)
                .orElseThrow(() -> new IllegalArgumentException("Desk with given nuber not exists"));
    }}
