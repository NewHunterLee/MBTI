package com.example.MDTI.Service;

import com.example.MDTI.Entity.*;
import com.example.MDTI.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /*
     * // 用 Id 找 User (Optional)
     * public Mono<Optional<User>> getUserById(Long id){
     * return Mono.just(userRepository.findById(id));
     * }
     */

    // mono 適合0或1個元素, flux適合多個元素
    // 註冊
    public Mono<User> register(
            String account,
            String password,
            String nickName,
            String gender,
            ArrayList<String> sports,
            ArrayList<String> movies,
            ArrayList<String> foods,
            String mbti) {

        // 註冊成功返回該帳號，失敗返回null
        if (userRepository.existsByAccount(account)) {
            return Mono.just(null); // 帳號別人用過了
        } else if (userRepository.existsByPassword(password)) {
            return Mono.just(null); // 密碼別人用過了
        } else {
            User user = new User(account, password, nickName, gender, sports, movies, foods, mbti);
            return Mono.just(userRepository.save(user)); // 存至database
        }
    }

    // 登入
    public Mono<User> login(String account, String password) {
        User user = userRepository.findByAccountAndPassword(account, password);
        if (user != null) {
            return Mono.just(user);
        } else {
            return Mono.just(null);
        }
    }

    /*
     * public Mono<User> getUserById(Long ID){ // 用 Id 找 User
     * return Mono.just(userRepository.getReferenceById(ID));
     * }
     * 
     * public Mono<User> getUserByAccount(String account){ // 用 account 找 User
     * return Mono.just(userRepository.findByAccount(account));
     * }
     * 
     * public Mono<User> getUserByPassword(String password){ // 用 password 找 User
     * return Mono.just(userRepository.findByPassword(password));
     * }
     * 
     * public boolean userIdExist(Long ID){
     * return userIdExist(ID);
     * }
     * public boolean userAccountExist(String account) { //判斷帳號是否存在(用過)
     * return userRepository.existsByAccount(account);
     * }
     * public boolean userPasswordExist(String password) { //判斷密碼是否存在(用過)
     * return userRepository.existsByPassword(password);
     * }
     */

}
