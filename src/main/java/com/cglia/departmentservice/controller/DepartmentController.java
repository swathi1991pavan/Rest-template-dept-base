package com.cglia.departmentservice.controller;



import lombok.AllArgsConstructor;
import com.cglia.departmentservice.model.Department;
import com.cglia.departmentservice.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
        Department savedDepartment = departmentService.saveDepartment(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") int departmentId){
        Department department = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(department);
    }
    
    @PutMapping("{id}")
    public ResponseEntity<Department> update(@RequestBody Department department,@PathVariable("id") int departmentId){
    	System.out.println("controller");
        Department savedDepartment = departmentService.update(department,departmentId);
        return ResponseEntity.ok(savedDepartment);
    }
    
    
    @DeleteMapping("{id}")
    public void Delete(@PathVariable("id") int departmentId){
         departmentService.delete(departmentId);
        
    }
}


