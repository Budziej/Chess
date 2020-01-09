package com.blazejprzyluski.chess.Pieces;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Move {
    @JsonIgnore
    private int x;
    @JsonIgnore
    private int y;
    private Integer from;
    private Integer to;

    public Move(){}

    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Move(Integer from, Integer to) {
        this.from = from;
        this.to = to;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return this.from + " " + this.to;
    }
}
