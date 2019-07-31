package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CompanyDao extends CrudRepository<Company, Long> {

    void deleteById(long id);

    @Query(nativeQuery = true)
    List<Company> retrieveCompanyNameLike(@Param("NAME") String name);
}
