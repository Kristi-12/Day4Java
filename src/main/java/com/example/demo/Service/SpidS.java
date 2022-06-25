package com.example.demo.Service;

import com.example.demo.Entities.Spid;
import com.example.demo.Entities.Status;
import com.example.demo.Entities.User;
import com.example.demo.Repository.SpidR;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SpidS {
    private SpidR spidR ;

    public List<Spid> getSpidByUserId(User user){
        return spidR.findSpidById(user);
    }

    @Transactional
    public Spid createSpid (Spid spid) throws Exception{
        List <Spid> spids = spidR.findSpidById(spid.getUser());
        if (spids.size() > 0){
            throw new Exception("User exist!");
        }
        spid.setUser(spid.getId());
        return spidR.save(spid);
    }

    //find Spid
    public Spid findSpid(User user) throws Exception{
        List <Spid> spid = spidR.findSpidById(user);
        if (spid.size() <= 0){
            throw new Exception("Spid doesnt exist!");
        }
        return spid.get(0);
    }

    //Change Status
    public Spid changeSpidStatus(Spid spid){
        spid.setStatus(Status.READY_FOR_REVIEW);
        return spidR.save(spid);
    }

    //Delete Spid
    public void deleteSpid(Spid spid) throws Exception{
        if(spid.getStatus() != Status.PENDING){
            throw new Exception("Spid cant be deleted!");
        }
        spidR.delete(spid);
    }

    //Get All
    public Iterable<Spid> getAllSpids(){
        return spidR.findAll();
    }
}
