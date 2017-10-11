package com.github.java3wro.project.game.mapper;


import com.github.java3wro.project.game.dto.SeatDTO;
import com.github.java3wro.project.game.model.Seat;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by wawat on 10.10.2017.
 */
@Mapper (componentModel = "spring")
public interface SeatMapper {

SeatDTO toSeatDTO (Seat seat);
List<SeatDTO> toSeatDTO (List<Seat> seats);

}
