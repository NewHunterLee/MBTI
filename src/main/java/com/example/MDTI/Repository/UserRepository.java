package com.example.MDTI.Repository;

import com.example.MDTI.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    
    //Optional<User> findById(Long id);
    User getReferenceById(Long ID); //用 ID 找 User

    //@Query("SELECT u FROM User u WHERE u.account = :account AND u.password = :password")
    User findByAccountAndPassword(String account, String password); //用帳號加密碼找User
    
    //@Query(value = "select account from User user where user.findByAccount(account);")
    User findByAccount(String account); //用帳號找User
    
    //@Query(value = "select account from User user where user.findByPassword(password);")
    User findByPassword(String account); //用密碼找User

    boolean exexistsById(Long ID);
    boolean existsByAccount(String account); //判斷帳號是否存在
    boolean existsByPassword(String password); //判斷密碼是否存在

    List<User> findByMbtiStartingWith(String prefix); //找到 i人或 e人

}