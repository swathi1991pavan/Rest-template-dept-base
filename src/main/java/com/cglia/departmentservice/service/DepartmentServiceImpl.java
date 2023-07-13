package com.cglia.departmentservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.cglia.departmentservice.model.Department;
import com.cglia.departmentservice.repository.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(int departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

	@Override
	public void delete(int departmentId) {
		
			departmentRepository.deleteById(departmentId);
			
	}

	

	
}