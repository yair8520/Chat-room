package com.beans;


import com.repo.User;
import com.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    private final UserRepo userRepo;

    @Autowired
    public UserServices(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getUsers() {
        return this.userRepo.findAll();
    }

    public long addUser(User user,boolean alive) {
        long id=this.userRepo.save(user).getId();
        setAlive(id,alive);                                     //after login alive true
        return id;
    }

    public void setAlive(long id,boolean alive)
    {
       var s=findById(id).get();
       s.setAliveState(alive);
        userRepo.save(s);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public Optional<User> findById(long id) {
        return this.userRepo.findById(id);
    }

    public List<User> getConnectedUsers() {
        return userRepo.findByAlive(true);
    }

    public List<User> findAllByFirstNameAndLastName(String firstName, String lastName) {
        return (List<User>) userRepo.findAllByFirstNameAndLastName(firstName,lastName);
    }
    public User findByFirstNameAndLastName(String firstName, String lastName) {
        return  userRepo.findByFirstNameAndLastName(firstName,lastName);
    }
    public List<User> findByFirstName(String firstName) {
        var result=userRepo.findAllByFirstName(firstName);
        if(result==null)
            return (List<User>) new User();
        else return result;
    }

}
