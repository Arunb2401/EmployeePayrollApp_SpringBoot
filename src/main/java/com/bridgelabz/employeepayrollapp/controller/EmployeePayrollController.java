package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.services.IEmployeePayrollService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController<ResponseEntity> {
//@Autowired
private IEmployeePayrollService employeePayrollService;

@RequestMapping(value = {"", "/", "/get"})
public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
 List<EmployeePayrollData> empDataList = null;
  empDataList = employeePayrollService.getEmployeePayrollData();
  ResponseDTO respDTO = new ResponseDTO("GET CALL SUCCESS", empDataList);
  return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
}

/**
 *
 * @param empId
 * @return
 */
@GetMapping("/get/{empId}")
public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
  EmployeePayrollData employeePayrollData = employeePayrollService.getEmployeePayrollDataById(empId);
  ResponseDTO respDTO = new ResponseDTO("Get Call For ID is Successful !!!", employeeData);
  return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
}

/**
 *
 * @param employeePayrollDTO
 * @return
 */

@PostMapping("/create")
public ResponseEntity<ResponseDTO> addEmployeePayrollData(
        @RequestBody EmployeePayrollDTO employeePayrollDTO) {
  EmployeePayrollData employeePayrollData = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
  ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data  Successfully !!!", employeeData);
  return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
}
/**
 *
 * @param employeePayrollDTO
 * @return
 */

@PutMapping("/update/{empId}")
public ResponseEntity<ResponseDTO> updateEmployeePayrollData(
        @PathVariable("empId") int empId,
        @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData  employeePayrollData = employeePayrollService.updateEmployeePayrollData(empId, employeePayrollDTO);
    ResponseDTO respDTO = new ResponseDTO("Updated Employee Payroll Data  Successfully !!!", employeePayrollData);
  return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
}

/**
 *
 * @param empId
 * @return
 */

@DeleteMapping("/delete/{empId}")
public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(
        @PathVariable("empId") int empId){
  employeePayrollService.deleteEmployeePayrollData(empId);
  ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted Id:" + empId);
  return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
}
}
