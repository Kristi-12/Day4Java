package com.example.demo.Repository;

import com.example.demo.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface UserR extends CrudRepository<User, Long> {
    List<User> findUserById(long id);

}
