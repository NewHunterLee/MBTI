package com.example.MDTI.Entity;

import javax.persistence.*;
import java.time.*;
import lombok.*;

@Entity
@Data
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private User user1;
    private User user2;

    //private boolean user1AcceptMatch;
    //private boolean user2AcceptMatch;

    //private Instant matchedTime;
    private LocalDate matchedDate;

    public void setUser1(User user1){
        this.user1 = user1;
    }
    public User getUser1(){
        return this.user1;
    }

    public void setUser2(User user2){
        this.user2 = user2;
    }
    public User getUser2(){
        return this.user2;
    }

    public User getOtherUser(User user) {
        if (user1.equals(user)) {
            return user2;
        } else {
            return user1;
        }
    }

    public Match(User user1, User user2, LocalDate matchedDate) {
        this.user1 = user1;
        this.user2 = user2;
        //this.matchedTime = matchedTime;
        this.matchedDate = matchedDate;
    }
}