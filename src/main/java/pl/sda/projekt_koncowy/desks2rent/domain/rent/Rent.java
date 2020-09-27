package pl.sda.projekt_koncowy.desks2rent.domain.rent;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Rent {
    private Integer id;
    private Data data;
    private Integer hour_begin;
    private Integer hour_end;
    private Integer user_id;
    private Integer desk_id;
}
