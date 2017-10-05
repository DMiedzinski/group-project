package com.github.java3wro.project.game.model;


import com.github.java3wro.project.game.enums.Status;
import org.apache.catalina.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<Move> moves;
    private Status status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
