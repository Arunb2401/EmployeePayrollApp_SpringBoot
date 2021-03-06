package com.bridgelabz.employeepayrollapp.services;

import java.util.ArrayList;
import java.util.*;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;


@Service
public class EmployeepayrollService implements IEmployeePayrollService{

  private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

    @Override
    public  List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollList;
        }
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
          return employeePayrollList.get(empId-1);
        }


    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO)  {
            EmployeePayrollData employeePayrollData = null;
      employeePayrollData = new EmployeePayrollData(employeePayrollList.size()+1, employeePayrollDTO);
            employeePayrollList.add(employeePayrollData);
            return employeePayrollData ;
        }

@Override
public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO)  {
       EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empId);
       employeePayrollData.setName(employeePayrollDTO.name);
       employeePayrollData.setSalary(employeePayrollDTO.salary);
       employeePayrollList.set(empId-1, employeePayrollData);
        return employeePayrollData;
    }

@Override
    public void deleteEmployeePayrollData(int empId) {
      employeePayrollList.remove(empId-1);
        }
}
