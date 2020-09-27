package pl.sda.projekt_koncowy.desks2rent.external.desk;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import pl.sda.projekt_koncowy.desks2rent.domain.desk.Desk;
import pl.sda.projekt_koncowy.desks2rent.domain.desk.DeskRepository;

@Component
@RequiredArgsConstructor
public class DatabaseDeskRepository implements DeskRepository<DeskEntity, Integer> {

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
}
