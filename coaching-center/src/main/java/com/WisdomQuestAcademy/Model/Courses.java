package com.WisdomQuestAcademy.Model;


import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@Table(name = "Courses")
public class Courses {
    private int COURSE_ID;
    private String COURSE_NAME;
    private Double COURSE_PRICE;
    private int LECTURER_ID;
    private Date CREATION_DATE;
    private Date UPDATE_DATE;
}
