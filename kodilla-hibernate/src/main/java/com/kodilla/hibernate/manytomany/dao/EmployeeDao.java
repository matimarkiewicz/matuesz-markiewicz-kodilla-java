package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface EmployeeDao extends CrudRepository<Employee, Long> {

    void deleteById(long id);

    @Query
    List<Employee> retrieveEmployeeWithLastname(@Param("LASTNAME") String name);

    @Query(nativeQuery = true)
    List<Employee> retrieveEmployeeLike(@Param("LASTNAME") String lastname);
}
