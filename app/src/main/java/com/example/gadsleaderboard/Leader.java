package com.example.gadsleaderboard;

public class Leader {
    private String name;
    private String hours;
    private String country;
    public Leader(String name, String hours, String country){
        this.name =name;
        this.hours = hours;
        this.country = country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getHours() {
        return hours;
    }

    public String getCountry() {
        return country;
    }
}
