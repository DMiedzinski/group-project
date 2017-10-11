package com.github.java3wro.project.game.model;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne (fetch = FetchType.EAGER)
    private Game game;

    @OneToMany (mappedBy = "deal")
    private List<Move> moves;

    private String winner;

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
