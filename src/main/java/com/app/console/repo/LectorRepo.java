package com.app.console.repo;

import com.app.console.models.Lector;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.*;

public interface LectorRepo extends CrudRepository<Lector, Long> {

    @Query(nativeQuery = true,
            value = "select first_name, last_name from lectors\n" +
                    "join departments on departments.head = lectors.id and departments.name = :departName")
    String headOfDepart(String departName);

    @Query(nativeQuery = true,
        value = "select count(*) from lectors join departments_lectors\n" +
            "on lectors.id = departments_lectors.lector_id join departments\n" +
            "on departments_lectors.department_id = departments.id\n" +
            "where departments.name = :departmentName \n" +
            "and lectors.degree = :position")
    Integer stat(String departmentName, String position);

    @Query(nativeQuery = true,
        value = "select AVG(SALARY) from departments join departments_lectors\n" +
                "on departments.id = departments_lectors.department_id join lectors\n" +
                "on departments_lectors.lector_id = lectors.id\n" +
                "where departments.name = :depName")
    Double avgSalary(String depName);

    @Query(nativeQuery = true,
        value = "select count(*) from lectors join departments_lectors\n" +
                "on lectors.id = departments_lectors.lector_id join departments\n" +
                "on departments_lectors.department_id = departments.id\n" +
                "where departments.name = :depName")
    Integer countOfEmployee(String depName);

    @Query(nativeQuery = true,
        value = "select distinct first_name, last_name from lectors join departments_lectors\n" +
                "on lectors.id = departments_lectors.lector_id join departments\n" +
                "on departments_lectors.department_id = departments.id\n" +
                "where lectors.first_name like %:name% or lectors.last_name like %:name%")
    List<String> globSearch(@Param("name") String name);
}
