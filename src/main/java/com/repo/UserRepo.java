package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface User repo.
 */
@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    /**
     * Find all by first name and last name list.
     *
     * @param firstname the firstname
     * @param lastname  the lastname
     * @return the list
     */
    List<User> findAllByFirstNameAndLastName(String firstname, String lastname);

    /**
     * Find by first name and last name user.
     *
     * @param firstname the firstname
     * @param lastname  the lastname
     * @return the user
     */
    User findByFirstNameAndLastName(String firstname, String lastname);

    /**
     * Find all by first name list.
     *
     * @param firstName the first name
     * @return the list
     */
    List<User> findAllByFirstName(String firstName);

    /**
     * Find by alive list.
     *
     * @param alive the alive
     * @return the list
     */
    List<User> findByAlive(boolean alive);

}

