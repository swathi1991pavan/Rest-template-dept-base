package com.cglia.departmentservice.service;



import com.cglia.departmentservice.model.Department;



public interface DepartmentService
{
    Department saveDepartment(Department department);

    Department getDepartmentById(int departmentId);

	

	void delete(int departmentId);

	Department update(Department department,int departmentId);
}