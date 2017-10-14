package com.github.java3wro.project.game.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.java3wro.project.game.enums.MoveType;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by wawat on 05.10.2017.
 */
@Entity
public class Move {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Seat seat;

    private LocalDateTime time;
    private Long value;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Deal deal;

    @Enumerated(EnumType.STRING)
    private MoveType moveType;

    public Seat getSeat() {
        return seat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MoveType getMoveType() {
        return moveType;
    }

    public void setMoveType(MoveType moveType) {
        this.moveType = moveType;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }




}
