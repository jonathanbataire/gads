package com.example.gadsleaderboard;

public class SkillIQ {
    private String name;
    private String score;
    private String country;

    public SkillIQ(String name, String score, String country){

        this.name = name;
        this.score = score;
        this.country = country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return score;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
}
