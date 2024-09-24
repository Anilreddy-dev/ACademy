package com.WisdomQuestAcademy.Service;

import com.WisdomQuestAcademy.Dao.CourseDao;
import com.WisdomQuestAcademy.Model.Courses;
import com.WisdomQuestAcademy.Repository.BaseDaoCore;
import com.WisdomQuestAcademy.response.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseDao courseDao;

    public GeneralResponse getallcourseService() throws Exception  {
        GeneralResponse response ;
        try {
            List<Courses> coursesList= courseDao.getAllCourseDao();
            response = new GeneralResponse(true,"all courses",coursesList);
        }
        catch (Exception e) {
            throw new Exception("No courses found");
        }

        return response;
    }

    public GeneralResponse getcoursebyid(int id ) throws Exception  {
        GeneralResponse response ;
        try {
            List<Courses> course =courseDao.getAllCoursesid(id);
            response = new GeneralResponse(true,"course by id",course);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }

//    public GeneralResponse getAllCourses(int page, int size) throws Exception {
//        GeneralResponse response;
//        try {
//            List<Courses> courseList = courseDao.getAllCourse(page, size);
//            response = new GeneralResponse("true", "Fetched all courses",courseList);
//
//        } catch (Exception e) {
//            throw new Exception("unable to find");
//        }
//        return response;
//
//    }
//
//   public GeneralResponse getCoursesid(int id) throws Exception {
//        GeneralResponse response;
//        try {
//            List<Courses> coursesList=courseDao.getCourseById(id);
//            response = new GeneralResponse(true, "Fetched one course",coursesList);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return response;
//    }
//
//    public GeneralResponse delteCourseById(int id) throws Exception {
//        GeneralResponse response;
//        try {
//            int roweffected =courseDao.deleteCourseById(id);
//            response = new GeneralResponse("true", "Deleted one course",roweffected);
//        }
//        catch (Exception e) {
//            throw new Exception("unable to delete");
//        }
//        return response;
//    }
//
//
//
//
//
//    public GeneralResponse addCourse(Courses course) throws Exception {
//        GeneralResponse response;
//        try {
//            int i = courseDao.addCourse(course);
//            response = new GeneralResponse("true", "Added course", i);
//        } catch (Exception e) {
//            throw new Exception("unable to add course");
//        }
//
//        return response;
//
//    }
//

}
