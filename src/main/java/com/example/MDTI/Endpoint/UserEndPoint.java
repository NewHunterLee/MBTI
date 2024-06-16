package com.example.MDTI.Endpoint;

import dev.hilla.Endpoint;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.example.MDTI.Entity.*;
import com.example.MDTI.Service.*;
//import com.example.MDTI.Controller.*;

import reactor.core.publisher.Mono;
import java.util.*;

@Endpoint
@AnonymousAllowed
public class UserEndPoint {
    UserService userService;
    MatchService matchService;
    //UserController userController;

    // 註冊
    public boolean register(
            String account,
            String password,
            String nickName,
            String gender,
            ArrayList<String> sports,
            ArrayList<String> movies,
            ArrayList<String> foods,
            String mbti) {

        // 返回註冊成功與否
        if (userService.register(account, password, nickName, gender, sports, movies, foods, mbti) != null) {
            return true;
        } else {
            return false; // 代表帳號或密碼別人用過了
        }
    }

    // 登入
    // 此function能在前端將 currentUser先存起來方便後續使用
    public Mono<User> login(String account, String password) {
        // 若登入成功(找的到對應的帳號密碼)，返回成功登入的那個帳號
        // 若返回null需重新登入
        return userService.login(account, password); // return type is null or User
    }


    // 當用戶點擊"開始配對"後使用此function
    // 可能返回 Match或 null (通常是 match，null則代表完全找不到適合的人)
    // 若返回 Match，則給用戶看此 match的資訊(日期、配到的人的資料)
    // 有一個 .getOtherUser(User user)可以用，在 Match.java裡，把 currentUser當參數就能找到在此 match 中的另一人
    public Match findOrCreateMatchForUser(User currentUser) {
        return matchService.findOrCreateMatchForUser(currentUser);
    }

    // 當用戶點擊"同意配對"後使用此 function
    public void acceptMatch(User user){
        user.setAcceptMatch(true);
    }
    // 當用戶點擊"拒絕配對"後使用此 function
    public void refuseMatch(User user){
        user.setAcceptMatch(false);
    }


    // 更改用戶資料
    public void updateUserAccount(User user, String account) {
        user.setAccount(account);
    }

    public void updateUserPassword(User user, String password) {
        user.setPassword(password);
    }

    public void updateUserNickname(User user, String nickcame) {
        user.setNickname(nickcame);
    }

    public void updateUserGender(User user, String gender) {
        user.setGender(gender);
    }

    public void updateUserSports(User user, String sport, boolean isAdd) {
        if (isAdd) {
            user.addSport(sport);
        } else {
            user.removeSport(sport);
        }
    }

    public void updateUserMovies(User user, String movie, boolean isAdd) {
        if (isAdd) {
            user.addMovie(movie);
        } else {
            user.removeMovie(movie);
        }
    }

    public void updateUserFoods(User user, String food, boolean isAdd) {
        if (isAdd) {
            user.addFood(food);
        } else {
            user.removeFood(food);
        }
    }

    public void updateUserMbti(User user, String mbti) {
        user.setMbti(mbti);
    }
    
    /*
    public void updateUserAccount(User user, String account) {
        userController.updateUserAccount(user, account);
    }

    public void updateUserPassword(User user, String password) {
        userController.updateUserPassword(user, password);
    }

    public void updateUserNickname(User user, String nickname) {
        userController.updateUserNickname(user, nickname);
    }

    public void updateUserGender(User user, String gender) {
        userController.updateUserGender(user, gender);
    }

    public void updateUserSports(User user, String sport, boolean isAdd) {
        userController.updateUserSports(user, sport, isAdd);
    }

    public void updateUserMovies(User user, String movie, boolean isAdd) {
        userController.updateUserMovies(user, movie, isAdd);
    }

    public void updateUserFoods(User user, String food, boolean isAdd) {
        userController.updateUserFoods(user, food, isAdd);
    }

    public void updateUserMbti(User user, String mbti) {
        userController.updateUserAccount(user, mbti);
    }
    */
}
