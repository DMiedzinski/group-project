package com.github.java3wro.project.game.repository;

import com.github.java3wro.project.game.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wawat on 06.10.2017.
 */
@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
}
