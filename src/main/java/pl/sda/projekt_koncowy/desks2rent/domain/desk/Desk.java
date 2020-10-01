package pl.sda.projekt_koncowy.desks2rent.domain.desk;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Desk {
    private Integer id;
    @NotEmpty(message = "number cannot be empty")
    private Integer desknumber;
    @NotEmpty(message = "number cannot be empty")
    private String floor;
    @NotEmpty(message = "number cannot be empty")
    private String room;
    @NotNull(message = "number cannot be Null")
    private Boolean availbility;
}
