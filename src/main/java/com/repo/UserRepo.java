package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    // List<User> findByLastName(String lastname);
    User findByFirstNameAndLastName(String firstname, String lastname);
    User findByFirstName(String firstName);


    List<User> findByAlive(boolean alive);

}

