package pl.sda.projekt_koncowy.desks2rent.external;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Desk {
    private Integer id;
    private Integer number;
    private String floor;
    private String room;
    private boolean availbility;
}
