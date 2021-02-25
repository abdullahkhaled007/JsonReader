package com.cve.reader.jsondb.repository;

import com.cve.reader.jsondb.pojo.CveObject;
import org.springframework.data.repository.CrudRepository;

public interface CveRepository extends CrudRepository<CveObject,String> {

}
