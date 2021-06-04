package controllers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepo extends JpaRepository<Message,Long> {

   //  List<Message> findById(long id);
     List<Message> findAllByOrderById();
     //List<Message> findAllByUser_id(long id);
     Message findByMessage(String message);

}

