package com.io.parser.repository;

import java.util.LinkedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FileJdbcRepository {

  @Autowired
  JdbcTemplate jdbcTemplate;

  public int insert(LinkedList<String> list) {
    return jdbcTemplate.update("insert into ADJD_CLMHST_CLM (partnId, partVal, invnCtlNbr) " + "values(?,  ?, ?)",
        new Object[] { list.get(0), list.get(1) , list.get(2) });
  }

  public int update(LinkedList list) {
    return jdbcTemplate.update("update ADJD_CLMHST_CLM " + " set partnId = ? " + " where partnId = ? and partVal = ? and invnCtlNbr = ?",
        new Object[] { list.get(3), list.get(0), list.get(1), list.get(2) });
  }


}
