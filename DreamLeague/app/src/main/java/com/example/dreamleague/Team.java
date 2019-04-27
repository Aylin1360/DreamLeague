package com.example.dreamleague;

public class Team {
    private Player[] players;
    private String name;
    private float overall;

    public Team(String s, Player[] ps) {
        name = s;
        players = ps;
        calculateOverall();
    }

    private void calculateOverall() {
        float avg = 0;
        for (int i = 0; i < players.length; i++)
            avg += players[i].getOverallrating();
        overall = avg / players.length;
    }

    @Override
    public String toString() {
        return name + " " + overall;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getOverall() {
        return overall;
    }

    public void setOverall(float overall) {
        this.overall = overall;
    }

}
