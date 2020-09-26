package pl.sda.projekt_koncowy.desks2rent.domain.desk;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class desk {
    private Integer id;
    @NotEmpty(message = "number cannot be empty")
    private Integer desk_number;
    private String floor;
    private String room;
    private boolean availbility;
}
