package edu.mineok.service;

import edu.mineok.entity.User;
import edu.mineok.repository.UserRepository;
import edu.mineok.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User checkUser(String username,String password){
        User user = userRepository.findByUsernameAndAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
