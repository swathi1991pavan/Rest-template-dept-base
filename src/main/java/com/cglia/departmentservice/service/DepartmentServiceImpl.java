package com.cglia.departmentservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.cglia.departmentservice.model.Department;
import com.cglia.departmentservice.repository.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

	@Override
	public Department update(Department department,int departmentId) {
		System.out.println("hi");
		try {
			System.out.println(department.getDepartmentAddress());
            Department dept=departmentRepository.findById(departmentId).get();
            if(department.getDepartmentName()!=null){
                dept.setDepartmentName(department.getDepartmentName());
            }
            if(department.getDepartmentAddress()!=null){
            	dept.setDepartmentAddress(department.getDepartmentAddress());
            }
            if(department.getDepartmentCode()!=null){
            	dept.setDepartmentCode(department.getDepartmentCode());
                
            }

            departmentRepository.save(dept);
            System.out.println(dept.getDepartmentAddress());
            return dept;
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
	}

	

	
}