package com.io.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ParseApplication {

  private static final String filePath = "../text/src/main/resources/records";

  private static final Integer tableNameLength = 50;

  public static void main(String[] args) {
    SpringApplication.run(ParseApplication.class, args);
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
}
