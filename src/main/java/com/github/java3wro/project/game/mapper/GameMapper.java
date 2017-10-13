package com.github.java3wro.project.game.mapper;

import com.github.java3wro.project.game.dto.GameDTO;
import com.github.java3wro.project.game.model.Game;
import org.mapstruct.Mapper;

/**
 * Created by wawat on 11.10.2017.
 */
@Mapper(componentModel = "spring")
public interface GameMapper {

    GameDTO toGameDTO (Game game);

    Game fromGameDTO (GameDTO gameDTO);
}
