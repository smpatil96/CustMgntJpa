package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import com.csi.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/savedata")
    public ResponseEntity<Employee> saveData(@RequestBody Employee employee) {
        log.info("@@@@@Trying to save Data or Employee: " + employee.getEmpFirstName());
        return ResponseEntity.ok(employeeServiceImpl.saveData(employee));
    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>> getAllData() {
        return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }

    @PutMapping("/updateData/{empId}")
    public ResponseEntity<Employee> updateData(@PathVariable int empId, @RequestBody Employee employee) {
        // exception goes here
        return ResponseEntity.ok(employeeServiceImpl.updateData(employee));
    }

    @DeleteMapping("/deletedata/{empId}")
    public ResponseEntity<String> deleteData(@PathVariable int empId) {
        employeeServiceImpl.deleteData(empId);
        return ResponseEntity.ok("data deleted successfully");
    }
    @GetMapping("/getdatabyname/{empFirstName}")
    public ResponseEntity<List<Employee>> getDataByName(@PathVariable String empFirstName)
    {
        return ResponseEntity.ok(employeeServiceImpl.getDataByName(empFirstName));
    }
   /* @GetMapping("/getdatabyemailid/{empEmailId}")
    public ResponseEntity <Employee> getDataByEmailId(@PathVariable String empEmailId)
    {
        return ResponseEntity.ok(employeeServiceImpl.getDataByEmailId(empEmailId));
    }
    @GetMapping("/getdatabycontactnumber/{empContactNumber}")
    public ResponseEntity <Employee> getDataByContactNumber(@PathVariable long empContactNumber)
    {
        return ResponseEntity.ok(employeeServiceImpl.getDataByContactNumber(empContactNumber));
    }*/

   /* @GetMapping("/getdatabyname/{empFirstName}")
    public ResponseEntity<List> getDataByName(@PathVariable String empFirstName) {
        return ResponseEntity.ok(employeeServiceImpl.getDataByName(empFirstName));
    }*/
}

