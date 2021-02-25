package com.cve.reader.jsondb;


import com.cve.reader.jsondb.pojo.CveObject;
import com.cve.reader.jsondb.service.JsonService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class JsondbApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsondbApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(JsonService jsonService) {
        return args -> {
            //read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<CveObject>> typeReference = new TypeReference<>() {
            };
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/CVE.json");
            try {
                List<CveObject> cve = mapper.readValue(inputStream, typeReference);
                jsonService.save(cve);
                System.out.println("Entry Saved");
            } catch (IOException e) {
                System.out.println("Unable to save entry" + e.getMessage());
            }
        };
    }

}

