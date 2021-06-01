package controllers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

   // List<User> findByLastName(String lastname);
    User findByFirstNameAndLastName(String firstname,String lastname);
    /*List<User> findByFirstName(String first_name);

    *//*List<User> findByfirstName(String userName);

    List<User> findByEmail(String email);
    List<User> findByUserNameAndEmail(String userName, String email);
    List<User> findFirst10ByOrderByUserNameDesc();*/
}

