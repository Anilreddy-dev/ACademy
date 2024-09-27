package com.WisdomQuestAcademy.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDaoCore {
    @Autowired
    public  JdbcTemplate jdbcTemplate;
}
