package com.example.demo.Repository;

import com.example.demo.Entities.Spid;
import com.example.demo.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpidR extends CrudRepository <Spid , Long> {
    List<Spid> findSpidById (User user);
}
