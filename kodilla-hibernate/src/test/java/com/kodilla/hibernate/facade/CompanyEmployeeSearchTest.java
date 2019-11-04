package com.kodilla.hibernate.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.CompanyEmployeeSearch;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyEmployeeSearchTest {

    @Autowired
    private CompanyEmployeeSearch companyEmployeeSearch;
    @Autowired
    private CompanyDao companyDao;

    private ArrayList<Company> resultCompanyList = new ArrayList<>();
    private ArrayList<Employee> resultEmployeeList = new ArrayList<>();

    @Test
    public void CompanyLikeTest() {

        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaSmith = new Employee("Linda", "Smith");

        Company softwareMachine = new Company("Software Machine");
        Company softDataMasters = new Company("Soft Data Masters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        softDataMasters.getEmployees().add(stephanieClarckson);
        softDataMasters.getEmployees().add(lindaSmith);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaSmith);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(softDataMasters);
        lindaSmith.getCompanies().add(softDataMasters);
        lindaSmith.getCompanies().add(greyMatter);

        companyDao.save(softwareMachine);
        companyDao.save(softDataMasters);
        companyDao.save(greyMatter);

        resultCompanyList.add(softwareMachine);
        resultCompanyList.add(softDataMasters);

        resultEmployeeList.add(johnSmith);
        resultEmployeeList.add(lindaSmith);

        List<Company> queryResult = companyEmployeeSearch.retrieveCompanyLike("Soft");

        Assert.assertEquals(resultCompanyList.size(), queryResult.size());

        try {
            companyDao.delete(softwareMachine);
            companyDao.delete(softDataMasters);
            companyDao.delete(greyMatter);
        } catch (Exception e) {
        }
    }

    @Test
    public void EmployeeLikeTest() {

        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaSmith = new Employee("Linda", "Smith");

        Company softwareMachine = new Company("Software Machine");
        Company softDataMasters = new Company("Soft Data Masters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        softDataMasters.getEmployees().add(stephanieClarckson);
        softDataMasters.getEmployees().add(lindaSmith);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaSmith);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(softDataMasters);
        lindaSmith.getCompanies().add(softDataMasters);
        lindaSmith.getCompanies().add(greyMatter);

        companyDao.save(softwareMachine);
        companyDao.save(softDataMasters);
        companyDao.save(greyMatter);

        resultCompanyList.add(softwareMachine);
        resultCompanyList.add(softDataMasters);

        resultEmployeeList.add(johnSmith);
        resultEmployeeList.add(lindaSmith);

        List<Employee> queryResult = companyEmployeeSearch.retrieveEmployeeLike("Smit");

        Assert.assertEquals(resultEmployeeList.size(), queryResult.size());

        try {
            companyDao.delete(softwareMachine);
            companyDao.delete(softDataMasters);
            companyDao.delete(greyMatter);
        } catch (Exception e) {
        }
    }
}
