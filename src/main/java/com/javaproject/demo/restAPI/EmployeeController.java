package com.javaproject.demo.restAPI;
import com.javaproject.demo.DAO.IEmployeeDAO;
import com.javaproject.demo.demoRestAPI.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@SpringBootConfiguration
@RestController
@RequestMapping("/api")
public class EmployeeController {
    private IEmployeeDAO iEmployeeDAO;

    @Autowired
    public EmployeeController(IEmployeeDAO iEmployeeDAO) {
        this.iEmployeeDAO = iEmployeeDAO;
    }
    @GetMapping("/employee")
    public List<Employee> get(){
        return iEmployeeDAO.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody Employee employee){
        iEmployeeDAO.add(employee);
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
