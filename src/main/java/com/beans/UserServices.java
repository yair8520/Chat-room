package com.beans;


import com.repo.User;
import com.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

/**
 * Implements the access functions to a user's database from UserRepo
 */
@Service
public class UserServices {

    /**
     * The User repo.
     */
    private final UserRepo userRepo;

    /**
     * Instantiates a new User services.
     *
     * @param userRepo the user repo
     */
    @Autowired
    public UserServices(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    public List<User> getUsers() {
        return this.userRepo.findAll();
    }

    /**
     * Add user long.
     *
     * @param user  the user
     * @param alive the alive state
     * @return the id
     */
    public long addUser(User user,boolean alive) {
        long id=this.userRepo.save(user).getId();
        setAlive(id,alive);                                     //after login alive true
        return id;
    }

    /**
     * Sets alive.
     *
     * @param id    the id
     * @param alive the alive
     */
    public void setAlive(long id,boolean alive)
    {
       var s=findById(id).get();
       s.setAliveState(alive);
        userRepo.save(s);
    }

    /**
     * Find all list.
     *
     * @return the list of users
     */
    public List<User> findAll() {
        return userRepo.findAll();
    }

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the user
     */
    public Optional<User> findById(long id) {
        return this.userRepo.findById(id);
    }

    /**
     * Gets connected users.
     *
     * @return the connected users
     */
    public List<User> getConnectedUsers() {
        return userRepo.findByAlive(true);
    }

    /**
     * Find all by first name and last name list.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @return the list of users
     */
    public List<User> findAllByFirstNameAndLastName(String firstName, String lastName) {
        return (List<User>) userRepo.findAllByFirstNameAndLastName(firstName,lastName);
    }

    /**
     * Find by first name and last name user.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @return the user
     */
    public User findByFirstNameAndLastName(String firstName, String lastName) {
        return  userRepo.findByFirstNameAndLastName(firstName,lastName);
    }

    /**
     * Find by first name list.
     *
     * @param firstName the first name
     * @return the list of users
     */
    public List<User> findByFirstName(String firstName) {
        var result=userRepo.findAllByFirstName(firstName);
        if(result==null)
            return (List<User>) new User();
        else return result;
    }

    /**
     * Check connecting user.
     */
    public void checkConnectingUser()
    {
        var users=getConnectedUsers();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        for (var i:users)
        {
            var distance=timestamp.getSeconds()-i.getSqlTimestamp().getSeconds();
            if(distance>12)
            {
                setAlive(i.getId(),false);
            }
        }
    }

    /**
     * Update time.
     *
     * @param id the id of users
     */
    public synchronized  void updateTime(long id)
    {
        var user= this.findById(id);
        var u = user.get();
        u.setSqlTimestamp(new Timestamp(System.currentTimeMillis()));
        userRepo.save(u);
    }

    /**
     * Update user time stampe.
     *
     * @param id the id of user
     */
    public void UpdateUser(long id)
    {
        updateTime(id);
        checkConnectingUser();
    }

}
