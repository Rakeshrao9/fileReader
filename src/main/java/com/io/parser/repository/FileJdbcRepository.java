package com.io.parser.repository;

import java.util.LinkedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FileJdbcRepository {

  @Autowired
  JdbcTemplate jdbcTemplate;

  public int update(LinkedList list) {
    return jdbcTemplate.update("update TABLE_NAME " + " set name = ?, passport_number = ? " + " where id = ?",
        new Object[] {  });
  }
}
