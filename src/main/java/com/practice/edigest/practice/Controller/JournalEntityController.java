package com.practice.edigest.practice.Controller;

import com.practice.edigest.practice.Entity.JournalEntity;
import com.practice.edigest.practice.Service.JournalEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JournalEntityController {

    @Autowired
    private JournalEntityService journalEntityService;

    @GetMapping("/{userName}")
    public ResponseEntity<?> getAll(@PathVariable String userName) {
        System.out.println("hi im in getAll function");
        return journalEntityService.findAllJournalEntriesOfuser(userName);
    }


    @PostMapping("/{username}")
    public String createJournal(@RequestBody JournalEntity j,@PathVariable String username) {
        journalEntityService.savebyusername(j,username);
        return "done";
    }



    @GetMapping("/id/{myid}")
    public JournalEntity getJournalById(@PathVariable String myid) {
        return journalEntityService.findById(myid);
    }

    @DeleteMapping("/id/{username}/{myid}")
    public String deleteJournalById(@PathVariable String username,@PathVariable String myid) {

        journalEntityService.delete(username,myid);

        return "deleted";
    }


    @PutMapping("/{id}/{username}")
    public void updateJournalWrtId(@RequestBody JournalEntity journal,@PathVariable String id,@PathVariable String username){
        //no need to save again in user enitty as its only carrying refernce to journal entity object
            System.out.println("hi im in updatejournalwrtdi function");
            journalEntityService.updateJournalThorughId(journal,id);
            return;
    }


}
