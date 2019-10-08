package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FacadeSearchCompanyEmployee {
    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    public List<Company> searchCompany(String fragmentOfTheName) {
        return companyDao.retrieveCompanyNameLike(fragmentOfTheName);
    }

    public List<Employee> searchEmployee(String fragmentOfTheName) {
        return employeeDao.retrieveEmployeeLike(fragmentOfTheName);
    }
}
