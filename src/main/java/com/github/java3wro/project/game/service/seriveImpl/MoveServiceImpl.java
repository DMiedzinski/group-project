package com.github.java3wro.project.game.service.seriveImpl;

import com.github.java3wro.project.game.enums.MoveType;
import com.github.java3wro.project.game.model.Move;
import com.github.java3wro.project.game.repository.MoveRepository;
import com.github.java3wro.project.game.service.MoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoveServiceImpl implements MoveService {

    @Autowired
    private MoveRepository moveRepository;

    @Override
    public Move makeMove(Move move) {
        if (move.getId() == null) {
            move = moveRepository.save(move);
        }
        return null;
    }


}
