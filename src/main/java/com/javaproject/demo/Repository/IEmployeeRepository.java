package com.javaproject.demo.Repository;
import com.javaproject.demo.demoRestAPI.Employee;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IEmployeeRepository extends JpaRepository<Employee, Long>{

}
