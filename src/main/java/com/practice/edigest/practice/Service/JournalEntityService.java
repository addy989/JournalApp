package com.practice.edigest.practice.Service;

import com.practice.edigest.practice.Entity.JournalEntity;
import com.practice.edigest.practice.Entity.UserEntity;
import com.practice.edigest.practice.Repository.JornalEnityRepo;
import com.practice.edigest.practice.Repository.UserEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntityService {

    @Autowired
    private JornalEnityRepo jornalEnityRepo;

    @Autowired
    private UserEntityService userEntityService;

    public void savebyusername(JournalEntity j,String username) {
        UserEntity user = userEntityService.findByUserName(username);

        if(user!=null){
           JournalEntity temp1= jornalEnityRepo.save(j);
           user.getJournals().add(temp1); //stores only refernce primary id here
           userEntityService.CreateUSer(user);
        }
        return;
    }

    public ResponseEntity<?> findAllJournalEntriesOfuser(String username) {
        UserEntity user = userEntityService.findByUserName(username);
        List<JournalEntity> temp = user.getJournals();
        //if(temp!=null){
            return new ResponseEntity<>(temp, HttpStatus.FOUND);
        //}
       // return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public JournalEntity findById(String id) {
        return jornalEnityRepo.findById(id).orElse(null);
    }

    public void delete(String username,String id) { //delete from both
        jornalEnityRepo.deleteById(id);
        UserEntity user = userEntityService.findByUserName(username);
        user.getJournals().removeIf(x->x.getId().equals(id));
        userEntityService.CreateUSer(user); //gets upadated
        return;
    }

    public void updateJournalThorughId(JournalEntity journal,String id){
        Optional<JournalEntity> temp = jornalEnityRepo.findById(id);
        if(temp.isPresent()){
            JournalEntity existingJournal = temp.get();
            if(journal.getTitle()!=null){
                existingJournal.setTitle(journal.getTitle());
            }
            if(journal.getData()!=null){
                existingJournal.setData(journal.getData());
            }
            if(journal.getContent()!=null) {
                existingJournal.setContent(journal.getContent());
            }
            jornalEnityRepo.save(existingJournal);
        }
    }

}
