package pl.sda.projekt_koncowy.desks2rent.external.desk;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface JpaDeskRepository extends JpaRepository<DeskEntity, Integer> {

    Optional<DeskEntity> finByDesknumber(int desknumber);
}
