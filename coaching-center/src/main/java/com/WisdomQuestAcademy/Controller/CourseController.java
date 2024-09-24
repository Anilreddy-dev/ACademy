package com.WisdomQuestAcademy.Controller;

import com.WisdomQuestAcademy.Model.Courses;
import com.WisdomQuestAcademy.Service.CourseService;
import com.WisdomQuestAcademy.response.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wisdom/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity<GeneralResponse> getallController() throws Exception {
        return ResponseEntity.ok().body(courseService.getallcourseService());
    }


    //
//    @GetMapping(value = "/getall")
//    public ResponseEntity<GeneralResponse> getAllCourse(@RequestParam int page, @RequestParam int size) throws Exception {
//        return ResponseEntity.ok().body(courseService.getAllCourses(page, size));
//    }
//
//    @PostMapping
//    public ResponseEntity<GeneralResponse> addCourse(@RequestBody Courses course) throws Exception {
//        return ResponseEntity.ok().body(
//                courseService.addCourse(course)
//        );
//    }
//
    @GetMapping("/getallbyid")
    public ResponseEntity<GeneralResponse> getId(@RequestParam int id) throws Exception {
        return ResponseEntity.ok().body(
                courseService.getcoursebyid(id));

    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<GeneralResponse> deleteCourse(@PathVariable int id) throws Exception {
//        return ResponseEntity.ok().body(
//                courseService.delteCourseById(id)
//        );
//    }

}
