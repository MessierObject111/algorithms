package com.java.se.hashcodeEquals;

import com.java8.stream.ParallelStreamTest;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Player {
    private String name;
    private int age;
    private Gender sex;
    private Map winLoseHistory;
    private Set favouriteTeams;
    private String[] slogans;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return age == player.age &&
                name.equals(player.name) &&
                sex == player.sex &&
                Objects.equals(winLoseHistory, player.winLoseHistory) &&
                Objects.equals(favouriteTeams, player.favouriteTeams) &&
                Arrays.equals(slogans, player.slogans);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, age, sex, winLoseHistory, favouriteTeams);
        result = 31 * result + Arrays.hashCode(slogans);
        return result;
    }

    public Player(String name, int age, Gender sex, Map winLoseHistory, Set favouriteTeams, String[] slogans) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.winLoseHistory = winLoseHistory;
        this.favouriteTeams = favouriteTeams;
        this.slogans = slogans;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    public Map getWinLoseHistory() {
        return winLoseHistory;
    }

    public void setWinLoseHistory(Map winLoseHistory) {
        this.winLoseHistory = winLoseHistory;
    }

    public Set getFavouriteTeams() {
        return favouriteTeams;
    }

    public void setFavouriteTeams(Set favouriteTeams) {
        this.favouriteTeams = favouriteTeams;
    }

    public String[] getSlogans() {
        return slogans;
    }

    public void setSlogans(String[] slogans) {
        this.slogans = slogans;
    }
}
