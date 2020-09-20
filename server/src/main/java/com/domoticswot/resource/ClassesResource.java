package com.domoticswot.resource;

import com.domoticswot.model.OntologyClass;
import com.domoticswot.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Classes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClassesResource {

    @Autowired
    ClassesService classesService;

    @GetMapping("/list")
    public List<OntologyClass> getClasses(){
        return classesService.listClasses();
    }
}

