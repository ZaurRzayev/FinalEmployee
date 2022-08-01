package com.javaproject.demo.DAO;
import com.javaproject.demo.demoRestAPI.Employee;
import java.util.List;

public interface IEmployeeDAO {
    List<Employee> getAll();
    void add(Employee employee);
    void update(Employee employee);
    void delete(Employee employee);
    Employee getById(int id);

}
