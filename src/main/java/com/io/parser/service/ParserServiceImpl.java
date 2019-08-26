package com.io.parser.service;

import com.io.parser.repository.FileJdbcRepository;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class ParserServiceImpl implements ParserService {

  private static final String filePath = "../text/src/main/resources/records";

  private static final Integer tableNameLength = 50;

  @Autowired
  private FileJdbcRepository repository;

  public ParserServiceImpl(FileJdbcRepository repository){
    this.repository = repository;
  }

  @Override
  public void execute() {
    try (Stream<String> stream = Files.lines(Paths.get(filePath)).parallel()) {
      List<String> list = stream.collect(Collectors.toList());
      for (String line : list) {
        String tableName = line.substring(0, tableNameLength - 1).trim();
        String value = line.substring(tableNameLength);
        LinkedList<String> values = splitStringIntoSubStrings(value);
        if (values.isEmpty()) {
          log.warn("Unable to update record for table: {}, with record: {}", tableName, line);
        }
        values.add(0, tableName);
        System.out.println(values.get(1));
        updateRecords(values, tableName);
      }
    } catch (IOException e) {
      log.warn("Unable to update record", e.getMessage());
    }
  }

  private static LinkedList<String> splitStringIntoSubStrings(String parentStr) {
    return Arrays.stream(parentStr.split(","))
        .map(String::trim)
        .collect(Collectors.toCollection(LinkedList::new));
  }

  private void updateRecords(LinkedList<String> list, String tableName){

    switch(tableName)
    {
      case "ADJD_CLMHST_CLM" :
       int q = repository.insert(list);
System.out.println("inserted rows: "+q);
        int qa = repository.update(list);
        System.out.println("updated rows: "+qa);
        break;
      case "ADJD_CLMSF_BLK_A" :

        break;

      default :
        // Statements
    }

  }
}
