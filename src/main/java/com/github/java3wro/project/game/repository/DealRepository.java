package com.github.java3wro.project.game.repository;

import com.github.java3wro.project.game.model.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wawat on 09.10.2017.
 */
@Repository
public interface DealRepository extends JpaRepository <Deal, Long>{


}
