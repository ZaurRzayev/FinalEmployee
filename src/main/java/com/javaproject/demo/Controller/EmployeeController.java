package com.javaproject.demo.Controller;
import com.javaproject.demo.EmployeeService.IEmployeeDAO;
import com.javaproject.demo.Repository.IEmployeeRepository;
import com.javaproject.demo.demoRestAPI.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@SpringBootConfiguration
@RestController
@RequestMapping("/api")
public class EmployeeController{
    @SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
    public class ReportApplication {

        public static void main(String[] args) throws Exception {
            SpringApplication.run(Employee.class, args);
        }
    }

    Employee employee=new Employee();

    private IEmployeeDAO iEmployeeDAO;
    private IEmployeeRepository iEmployeeRepository;

    @PostMapping("/save")
    public void save(@RequestBody Employee employee){
        try{
            iEmployeeRepository.save(employee);
        }catch(org.hibernate.exception.ConstraintViolationException exception){
           System.out.println(exception+" This pin already exists!");
        }

    }

    @PostMapping("/up")
    public void up(@RequestBody Employee employee){
        try{
            iEmployeeRepository.save(employee);
        }catch(org.hibernate.exception.ConstraintViolationException exception){
            System.out.println(exception+" This pin is already exist!");
        }
    }

    @PostMapping("/deleteall")
    public void deleteall(){
        iEmployeeRepository.deleteAllInBatch();
    }

    @GetMapping("/get/{id}")
    public Optional< Employee > findById(@PathVariable int id) {
        return iEmployeeRepository.findById(id);
    }

    @GetMapping("/get")
    public List< Employee > findall() {
        return iEmployeeRepository.findAll();
    }



    @Autowired
    public EmployeeController(IEmployeeDAO iEmployeeDAO, IEmployeeRepository iEmployeeRepository) {
        this.iEmployeeDAO = iEmployeeDAO;
        this.iEmployeeRepository = iEmployeeRepository;
    }
    @GetMapping("/employee")
    public List<Employee> get(){
        return iEmployeeDAO.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody Employee employee){
        try{
            iEmployeeDAO.add(employee);
        }catch(org.hibernate.exception.ConstraintViolationException exception){
            System.out.println(exception+" This pin is already exist!");
        }

    }

    @PostMapping("/update")
    public void update(@RequestBody Employee employee){
        iEmployeeDAO.update(employee);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Employee employee){
        iEmployeeDAO.delete(employee);
    }
    @GetMapping("/employee/{id}")
    public Employee getById(@PathVariable int id){
        return  iEmployeeDAO.getById(id);
    }


}
