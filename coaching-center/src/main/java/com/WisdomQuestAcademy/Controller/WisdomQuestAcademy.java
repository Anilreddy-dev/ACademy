package com.WisdomQuestAcademy.Controller;

import com.WisdomQuestAcademy.Model.Courses;
import com.WisdomQuestAcademy.Repository.BaseDaoCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wqa")
public class WisdomQuestAcademy {
    @Autowired
    private  BaseDaoCore baseDaoCore;

    @GetMapping
    public List<Courses> getAllCourses() {
        return null; //repository.findall method
    }
    @PostMapping
    public Courses createCourses(@RequestBody Courses courses) {
        return null; // save the data to the table
    }


}
