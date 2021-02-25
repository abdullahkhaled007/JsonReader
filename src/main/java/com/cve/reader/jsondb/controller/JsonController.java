package com.cve.reader.jsondb.controller;

import com.cve.reader.jsondb.pojo.CveObject;
import com.cve.reader.jsondb.service.JsonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/CVE")
public class JsonController {


    private JsonService jsonService;

    public JsonController(JsonService jsonService) {
        this.jsonService = jsonService;
    }

    @GetMapping("/list")
    public Iterable<CveObject> list() {
        return jsonService.list();
    }
}
