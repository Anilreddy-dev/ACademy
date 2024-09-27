package com.WisdomQuestAcademy.Dao;

import com.WisdomQuestAcademy.Model.Courses;
import com.WisdomQuestAcademy.Repository.BaseDaoCore;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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


  private final String pageQuery ="select * from courses order by id LIMIT ?,?";
   public List<Courses> getAlLpagenation(int page, int size) {
       return jdbcTemplate.query(pageQuery, new courseRowMapper(), page, size);
   }


    private final String deletequery = "UPDATE courses SET `IS_DELETED` = '1', `IS_ACTIVE` = '0' WHERE id =?";

    public int SoftdeleteCourseById(int id) {

        return jdbcTemplate.update(deletequery, id);
    }


    private final String addCourse_query = "Insert into courses(`COURSE_NAME`, `COURSE_PRICE`, `LECTURER_ID`, `IS_DELETED`, `IS_ACTIVE`) values(?,?,?,?,?)";

    public int addCourse_dao(Courses course) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(addCourse_query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, course.getCourseName());
            ps.setDouble(2, course.getCoursePrice());
            ps.setInt(3, course.getLecturerId());
            ps.setInt(4, course.getIsdeleted());
            ps.setInt(5, course.getIsactive());
            return ps;
        }, keyHolder);

        return Objects.requireNonNull(keyHolder.getKey()).intValue();
    }

    private final String updateQuery = "UPDATE  courses SET COURSE_NAME=?,COURSE_PRICE=?,LECTURER_ID=?,IS_DELETED=?,IS_ACTIVE=? where id=?";
    public int updateCourse_dao(int id , Courses course) {
        return jdbcTemplate.update(updateQuery,course.getCourseName(),course.getCoursePrice(),course.getLecturerId(),course.getIsdeleted(),course.getIsactive(),id);

    }


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
