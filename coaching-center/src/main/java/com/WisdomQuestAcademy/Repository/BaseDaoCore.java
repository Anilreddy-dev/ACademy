package com.WisdomQuestAcademy.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDaoCore {
    @Autowired
    private final JdbcTemplate jdbcTemplate;


    public BaseDaoCore(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
