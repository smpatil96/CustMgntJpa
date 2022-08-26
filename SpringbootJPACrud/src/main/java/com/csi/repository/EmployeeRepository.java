package com.csi.repository;

import com.csi.model.Employee;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
//custome methods goes here
    public List<Employee> findByEmpFirstName(String empFirstName);
    /*public Employee findByEmpEmailId(String empEmailId);
    public Employee findByContactNumber(long empContactNumber);*/
}
