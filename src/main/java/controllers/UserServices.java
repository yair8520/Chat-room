package controllers;


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

    public long addUser(User user) {
        return this.userRepo.save(user).getId();
    }


    public void findAll() {
        List<User> a = userRepo.findAll();
    }

    public Optional<User> findById(long id) {
        return this.userRepo.findById(id);
    }
}
