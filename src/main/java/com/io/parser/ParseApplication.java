package com.io.parser;

import com.io.parser.service.ParserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ParseApplication implements CommandLineRunner {

  @Autowired
  private ParserService parserService;

  public static void main(String[] args) {
    SpringApplication.run(ParseApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    parserService.execute();
    System.exit(0);
  }
}
