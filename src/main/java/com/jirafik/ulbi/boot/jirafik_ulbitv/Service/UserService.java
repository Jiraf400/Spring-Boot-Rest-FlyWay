package com.jirafik.ulbi.boot.jirafik_ulbitv.Service;

import com.jirafik.ulbi.boot.jirafik_ulbitv.Entity.UserEntity;
import com.jirafik.ulbi.boot.jirafik_ulbitv.Exceptions.UserAlreadyExistException;
import com.jirafik.ulbi.boot.jirafik_ulbitv.Exceptions.UserNotFoundException;
import com.jirafik.ulbi.boot.jirafik_ulbitv.Repository.UserRepo;
import com.jirafik.ulbi.boot.jirafik_ulbitv.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("Entity already exist");
        }
        return userRepo.save(user);
    }

    public User getUser(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).orElse(null);
        if (user == null) throw new UserNotFoundException("Entity not found");
        return User.toModel(user);
    }

    public List<UserEntity> getAllUsers() {
        return (List<UserEntity>) userRepo.findAll();
    }

    public String removeUser(Long id) {
        userRepo.deleteById(id);
        return "Entity with ID = " + id + " was deleted from database";
    }

}

