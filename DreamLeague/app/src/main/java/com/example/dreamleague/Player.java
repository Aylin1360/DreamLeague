package com.example.dreamleague;

public class Player {
    private String name;
    private int jerseyn;
    private String playerposition;
    private int overallrating;

    public Player(String name, int jerseyn, String playerposition, int overallrating) {
        this.name = name;
        this.jerseyn = jerseyn;
        this.playerposition = playerposition;
        this.overallrating = overallrating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJerseyn() {
        return jerseyn;
    }

    public void setJerseyn(int jerseyn) {
        this.jerseyn = jerseyn;
    }

    public String getPlayerposition() {
        return playerposition;
    }

    public void setPlayerposition(String playerposition) {
        this.playerposition = playerposition;
    }

    public int getOverallrating() {
        return overallrating;
    }

    public void setOverallrating(int overallrating) {
        this.overallrating = overallrating;
    }

    @Override
    public String toString() {
        return
                name + "\n" +
                "JN: " + jerseyn +
                " " + playerposition + " " +
                "Rate: " + overallrating + "\n\n";
    }
}
