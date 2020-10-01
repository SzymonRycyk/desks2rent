package pl.sda.projekt_koncowy.desks2rent.external.desk;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.sda.projekt_koncowy.desks2rent.domain.desk.Desk;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name="desks")
public class DeskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer desknumber;

    private String floor;

    private String room;

    private Boolean availbility;

    public void updateFromDomain(Desk desk) {
        this.desknumber = desk.getDesknumber();
        this.floor = desk.getFloor();
        this.room = desk.getRoom();
        this.availbility=desk.getAvailbility();
    }
}
