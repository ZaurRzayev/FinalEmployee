package com.javaproject.demo.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.javaproject.demo.EmployeeService.IEmployeeDAO;
import com.javaproject.demo.Repository.IEmployeeRepository;
import com.javaproject.demo.demoRestAPI.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@SpringBootConfiguration
@RestController
@RequestMapping("/api")
public class EmployeeController{
    Employee employee=new Employee();
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    private IEmployeeDAO iEmployeeDAO;
    private IEmployeeRepository iEmployeeRepository;

    @PostMapping("/save")
    public void save(@RequestBody Employee employee){
        iEmployeeRepository.save(employee);
    }

    @PostMapping("/up")
    public void up(@RequestBody Employee employee){
        iEmployeeRepository.save(employee);
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
