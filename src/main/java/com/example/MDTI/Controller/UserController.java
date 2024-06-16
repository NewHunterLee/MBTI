package com.example.MDTI.Controller;

import com.example.MDTI.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired

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
     * public ResponseEntity<User> updateUserProfile(
     * Long ID,
     * String account,
     * String password,
     * String nickName,
     * String gender,
     * ArrayList<String> hobby,
     * String mbti) {
     * 
     * User user = userRepository.getReferenceById(ID);
     * user.setAccount(account);
     * user.setPassword(password);
     * user.setNickname(nickName);
     * user.setGender(gender);
     * user.setHobby(hobby);
     * user.setMbti(mbti);
     * return ResponseEntity.ok(user);
     * }
     */
}
