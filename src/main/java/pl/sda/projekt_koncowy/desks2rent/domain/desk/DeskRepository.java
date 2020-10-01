package pl.sda.projekt_koncowy.desks2rent.domain.desk;

import java.util.List;
import java.util.Optional;

public interface DeskRepository {

    void create(Desk desk);

    void update(Desk desk);

    void delete(int id);

    Optional<Desk> getOne(int id);

    List<Desk> getAll();

    Optional<Desk> getByDesknumber(int number);
}
