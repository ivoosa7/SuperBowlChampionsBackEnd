package com.araujosivo.superbowlchampions.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.araujosivo.superbowlchampions.dtos.SBRequest;
import com.araujosivo.superbowlchampions.dtos.SBResponse;
import com.araujosivo.superbowlchampions.service.SBService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@CrossOrigin
@RestController
@RequestMapping("superbowlchampions")
public class SbControler {
    
    @Autowired
    public SBService service;

    //1 EndPoint
    @GetMapping
    public ResponseEntity<List<SBResponse>> getSbChampions(){
        return ResponseEntity.ok(service.getAllSuperbowls());
    }

    //2 EndPoint
    @GetMapping("{id}")
    public ResponseEntity<SBResponse> getSbChampionsById(@PathVariable long id){
        return ResponseEntity.ok(service.getSuperBowlById(id));
    }

    //3 EndPoint
    @PostMapping()
    public ResponseEntity<SBResponse> saveNewSbChampions(@Validated @RequestBody SBRequest sb){
        SBResponse newChampions = service.saveNewSbChampions(sb);
        return ResponseEntity.created(null).body(newChampions);
    }

    //4 EndPoint
    @PutMapping("{id}")
    public ResponseEntity<Void> updateSbChampions(@PathVariable long id, @Validated @RequestBody SBRequest sb){
        service.updateSbChampions(sb, id);
        return ResponseEntity.ok().build();
    }

    //5 EndPoint
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSbChampions(@PathVariable long id){
        service.deleteSbChampions(id);
        return ResponseEntity.noContent().build();
    }
    
    

}
