package com.WisdomQuestAcademy.Dao;

import com.WisdomQuestAcademy.Model.Courses;
import com.WisdomQuestAcademy.Repository.BaseDaoCore;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@Repository
public class CourseDao extends BaseDaoCore {
    private final String getall = "select * from courses ";
    public List<Courses> getAllCourseDao() {
        return jdbcTemplate.query(getall,new courseRowMapper());
    }
    private final String getbyid = " select * from courses where id = ?";
    public List<Courses> getAllCoursesid(int id) {
        return jdbcTemplate.query(getbyid,new courseRowMapper(),id);

    }
//    private final String deletebyid = " UPDATE courses SET `IS_DELETED` = '1', `IS_ACTIVE` = '0' WHERE ID = ?";
//    public

//    public List<Courses> getAllCourse(int page, int size) {
//        return jdbcTemplate.query(getallCourse, new courseRowMapper(), page, size);
//    }
//
//    private final String getcoursebyId = "select * from courses where course_id=?";
//
//    public List<Courses> getCourseById(int id) {
//        return jdbcTemplate.query(getcoursebyId, new courseRowMapper(), id);
//    }
//
//    private final String deletequery = "delete from courses where course_id=?";
//    public int deleteCourseById(int id) {
//        return jdbcTemplate.update(deletequery, id);
//    }
//
//
//    private final String addCourse = "Insert into courses(CourseName,CoursePrice,LecturerId,CreationDate,Updatedate,Isdeleted,Isactivate) values(?,?,?,?,?,?,?)";
//
//    public int addCourse(Courses course) {
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//        jdbcTemplate.update(con -> {
//            PreparedStatement ps = con.prepareStatement(addCourse);
//            ps.setString(1, course.getCourseName());
//            ps.setDouble(2, course.getCoursePrice());
//            ps.setInt(3, course.getLecturerId());
//            return ps;
//        }, keyHolder);
//        ;
//        return Objects.requireNonNull(keyHolder.getKey()).intValue();
//    }


    private class courseRowMapper implements RowMapper<Courses> {
        @Override
        public Courses mapRow(ResultSet rs, int rowNum) throws SQLException {
            Courses course = new Courses();
            course.setCourseId(rs.getInt("ID"));
            course.setCourseName(rs.getString("COURSE_NAME"));
            course.setCoursePrice(rs.getDouble("COURSE_PRICE"));
            course.setLecturerId(rs.getInt("LECTURER_ID"));
            course.setCreationDate(rs.getDate("CREATION_DATE"));
            course.setUpdateDate(rs.getDate("UPDATE_DATE"));
            course.setIsdeleted(rs.getInt("IS_DELETED"));
            course.setIsactive(rs.getInt("IS_ACTIVE"));
            return course;
        }
    }



}
