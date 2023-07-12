package com.cglia.departmentservice.service;



import com.cglia.departmentservice.model.Department;



public interface DepartmentService
{
    Department saveDepartment(Department department);

    Department getDepartmentById(int departmentId);
}