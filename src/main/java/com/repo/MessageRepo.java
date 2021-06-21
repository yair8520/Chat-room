package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Message repo.
 */
@Repository
public interface MessageRepo extends JpaRepository<Message,Long> {

    /**
     * Find first 5 by order by id desc list.
     *
     * @return the list
     */
    List<Message> findFirst5ByOrderByIdDesc();

    /**
     * Find all by user id list.
     *
     * @param id the id
     * @return the list
     */
    List<Message> findAllByUserId(long id);

    /**
     * Find all by message list.
     *
     * @param message the message
     * @return the list
     */
    List<Message> findAllByMessage(String message);



}

