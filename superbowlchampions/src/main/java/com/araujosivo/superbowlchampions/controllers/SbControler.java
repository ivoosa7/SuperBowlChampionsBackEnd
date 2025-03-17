package com.araujosivo.superbowlchampions.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.araujosivo.superbowlchampions.service.SBService;

@CrossOrigin
@RestController
@RequestMapping("superbowlchampions")
public class SbControler {
    
    @Autowired
    public SBService service;

    

}
