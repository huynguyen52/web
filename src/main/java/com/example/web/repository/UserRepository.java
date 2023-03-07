package com.example.web.repository;

import com.example.web.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    public List<User> findByName(String name);
    public int countByName(String name);
    // multi condition
    public List<User> findByNameAndEmail(String name, String email);
    //Ignore case
    public List<User> findByNameIgnoreCase(String name);

    @Query("select u from User u")
    public List<User> getUsersCustomQuery();
}
