package com.example.MDTI.Entity;

import javax.persistence.*;

import lombok.*;

import java.util.*;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String account;
    private String password;

    private String nickName;
    private String gender;
    private int age;
    private ArrayList<String> sports = new ArrayList<>();
    private ArrayList<String> movies = new ArrayList<>();
    private ArrayList<String> foods = new ArrayList<>();
    private String mbti;

    private HashSet<Match> matches = new HashSet<>();
    //private boolean wantMatch = false; // 當用戶點擊想要開始配對後設為true
    private boolean otherGuyWantMatchMe = false;
    private boolean acceptMatch = false;
    //private boolean waiting = false;

    public Long getId() {
        return ID;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return this.account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setNickname(String nickname) {
        this.nickName = nickname;
    }

    public String getNickname() {
        return this.nickName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return this.gender;
    }

    public void addSport(String sport) {
        this.sports.add(sport);
    }

    public void removeSport(String sport) {
        this.sports.remove(sport);
    }

    public void addMovie(String movie) {
        this.movies.add(movie);
    }

    public void removeMovie(String movie) {
        this.movies.remove(movie);
    }

    public void addFood(String food) {
        this.foods.add(food);
    }

    public void removeFood(String food) {
        this.foods.remove(food);
    }

    public ArrayList<String> getSports() {
        return this.sports;
    }

    public ArrayList<String> getMivies() {
        return this.movies;
    }

    public ArrayList<String> getFoods() {
        return this.foods;
    }

    public void setMbti(String mbti) {
        this.mbti = mbti;
    }

    public String getMbti() {
        return this.mbti;
    }

    public void addMatches(Match match) {
        this.matches.add(match);
    }

    public HashSet<Match> getMatches() {
        return this.matches;
    }

    //public void setWantMatch(boolean wantMatch) {
        //this.wantMatch = wantMatch;
    //}

    //public boolean getWantMatch() {
        //return this.wantMatch;
    //}

    public void setOtherGuyWantMatchMe(boolean otherGuyWantMatchMe) {
        this.otherGuyWantMatchMe = otherGuyWantMatchMe;
    }

    public boolean getOtherGuyWantMatchMe() {
        return this.otherGuyWantMatchMe;
    }

    public void setAcceptMatch(boolean acceptMatch) {
        this.acceptMatch = acceptMatch;
    }

    public boolean getAcceptMatch() {
        return this.acceptMatch;
    }

    //public void setWaiting(boolean waiting) {
        //this.waiting = waiting;
    //}

    //public boolean getWaiting() {
        //return this.waiting;
    //}

    public User() {
    }

    public User(String account, String password, String nickName, String gender, ArrayList<String> sports,
            ArrayList<String> movies, ArrayList<String> foods, String mbti) {
        this.account = account;
        this.password = password;
        this.nickName = nickName;
        this.gender = gender;
        this.sports = sports;
        this.movies = movies;
        this.foods = foods;
        this.mbti = mbti;
    }

}
