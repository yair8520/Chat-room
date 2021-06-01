package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServices {
    private final UserRepo userRepo;

    @Autowired
    public MessageServices(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


}
