package com.bridgelabz.employeepayrollapp.dto;


public class EmployeePayrollDTO {
//    public int employeeId;
    public String name;
    public long salary;

    /**
     *
     * @param name
     * @param salary
     */
    public EmployeePayrollDTO(String name, long salary)
        {
//            this.employeeId = empId;
            this.name = name;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return ("name=" + name + ":salary=" + salary);
        }

}
