package pl.sda.projekt_koncowy.desks2rent.external.desk;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.projekt_koncowy.desks2rent.domain.desk.Desk;
import pl.sda.projekt_koncowy.desks2rent.domain.desk.DeskRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DatabaseDeskRepository implements DeskRepository {

    private final JpaDeskRepository deskRepository;

    @Override
    public void create(Desk desk) {
        DeskEntity entity = DeskEntity.builder()
                .desknumber(desk.getDesknumber())
                .floor(desk.getFloor())
                .room(desk.getRoom())
                .availbility(desk.getAvailbility())
                .build();

        deskRepository.save(entity);
    }

    @Override
    public void update(Desk desk) {
        deskRepository.findById(desk.getId())
                .ifPresent(ent -> {
                    ent.updateFromDomain(desk);
                    deskRepository.save(ent);
                });
    }

    @Override
    public void delete(int id) {
        deskRepository.deleteById(id);
    }

    @Override
    public Optional<Desk> getOne(int id) {
        return deskRepository.findById(id).map(mapToDomain());
    }

    @Override
    public List<Desk> getAll(){
        return deskRepository.findAll().stream().map(mapToDomain()).collect(Collectors.toList());
    }

    @Override
    public Optional<Desk> getByDesknumber(int desknumber){
        return deskRepository.finByDesknumber(desknumber).map(ent-> mapToDomain(ent));
    }

    private Function<DeskEntity, Desk> mapToDomain(){
        return ent -> new Desk(ent.getId(), ent.getDesknumber(), ent.getFloor(), ent.getRoom(), ent.getAvailbility());
    }

    private Desk mapToDomain(DeskEntity ent){
        return new Desk(ent.getId(), ent.getDesknumber(), ent.getFloor(), ent.getRoom(), ent.getAvailbility());
    }
}
