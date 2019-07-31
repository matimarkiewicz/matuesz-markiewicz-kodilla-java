package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;
    private long id;

    @Test
    public void testSaveManyToMany() {

        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        companyDao.save(softwareMachine);
        long softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        long dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        long greyMatterId = greyMatter.getId();

        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);

        employeeDao.deleteById(id);
        companyDao.deleteById(id);
    }

    @Test
    public void testNamedQueries(){

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

        List<Employee> lastName = employeeDao.retrieveEmployeeWithLastname("Smith");
        List<Company> nameStartedWith = companyDao.retrieveCompanyNameLike("Sof");

        Assert.assertEquals(2, lastName.size());
        Assert.assertEquals(2, nameStartedWith.size());

        employeeDao.deleteById(id);
        companyDao.deleteById(id);
    }
}
