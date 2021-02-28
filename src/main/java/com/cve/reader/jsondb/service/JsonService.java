package com.cve.reader.jsondb.service;

import com.cve.reader.jsondb.pojo.CveObject;
import com.cve.reader.jsondb.repository.CveRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JsonService {

    private final CveRepository cveRepository;

    public JsonService(CveRepository cveRepository) {
        this.cveRepository = cveRepository;
    }

    public Iterable<CveObject> list() {
        return cveRepository.findAll();
    }

    public CveObject save(CveObject entry) {
        return cveRepository.save(entry);
    }

    public Iterable<CveObject> save(List<CveObject> allEntries) {
        return cveRepository.saveAll(allEntries);
    }
}
