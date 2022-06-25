package com.example.demo.Service;

import com.example.demo.Entities.User;
import com.example.demo.Repository.UserR;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Optional;

@Service
public class UserS {

    private UserR userR;

    public Optional<User> getUserById(long id){
        return  userR.findById(id);
    }

    public User updateUserById(long id , String name ,String surname , String email) throws Exception{
        Optional<User> user = userR.findById(id);

        if (user.isEmpty()){
            throw new Exception("User doesnt exist!");
        }

        if(name != null) {
            user.get().setName(name);
        }
        if(surname != null){
            user.get().setSurname(surname);
        }
        if(email != null){
            user.get().setEmail(email);
        }

        return userR.save(user.get());
    }

    public User createUser(User user){
        return userR.save(user);
    }
}
