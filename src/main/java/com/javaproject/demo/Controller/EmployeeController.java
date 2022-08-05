package com.javaproject.demo.Controller;
import com.javaproject.demo.APIErrors.BusinessException;
import com.javaproject.demo.EmployeeService.IEmployeeDAO;
import com.javaproject.demo.Repository.IEmployeeRepository;
import com.javaproject.demo.RestApiException.ControllerException;
import com.javaproject.demo.demoRestAPI.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
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
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
        try {
            Employee employeeSaved = iEmployeeRepository.save(employee);
            return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
        }catch (Exception e) {
            ControllerException ce = new ControllerException("349","Something went wrong in controller");
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/up")
    public ResponseEntity<Void> saveNewEmployee(@RequestBody Employee employee) {
        if (Objects.isNull(employee.getId()) || Objects.isNull(employee.getPin())) {
            throw new IllegalArgumentException("Invalid request");
        }

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){

        List<Employee> listOfAllEmps = iEmployeeRepository.findAll();
        return new ResponseEntity<List<Employee>>(listOfAllEmps, HttpStatus.OK);
    }



    @GetMapping("/all/{id}")
    public ResponseEntity<?> getEmpById(@PathVariable("id") int id){
        try {
            Employee empRetrieved = iEmployeeRepository.findById(id).get();
            return new ResponseEntity<Employee>(empRetrieved, HttpStatus.OK);
        }catch (BusinessException e) {
            ControllerException ce = new ControllerException("619","Something went wrong in controller");
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            ControllerException ce = new ControllerException("612","Something went wrong in controller");
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        }
    }




    @DeleteMapping("/delete/{empid}")
    public ResponseEntity<Void> deleteEmpById(@PathVariable("empid") int empidL){

        iEmployeeRepository.deleteById(empidL);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        try{
            Employee employeeSaved = iEmployeeRepository.save(employee);
            return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
        }catch (Exception E){
            ControllerException ce = new ControllerException("111","Something went wrong in controller");
            return new ResponseEntity<Employee>((MultiValueMap<String, String>) ce, HttpStatus.BAD_REQUEST);
        }
    }






    @Autowired
    public EmployeeController(IEmployeeDAO iEmployeeDAO, IEmployeeRepository iEmployeeRepository) {
        this.iEmployeeDAO = iEmployeeDAO;
        this.iEmployeeRepository = iEmployeeRepository;
    }
}



