package com.WisdomQuestAcademy.Model;


import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Courses {
    private int courseId;
    private String courseName;
    private Double coursePrice;
    private int lecturerId;
    private Date creationDate;
    private Date updateDate;
    private int isdeleted;
    private int isactive;


}
