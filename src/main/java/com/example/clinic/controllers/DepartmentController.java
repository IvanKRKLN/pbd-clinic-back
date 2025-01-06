package com.example.clinic.controllers;

import com.example.clinic.entities.Department;
import com.example.clinic.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/getAll")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping("/createDepartment")
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }


    @PutMapping("/updateDepartment/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        // Сначала проверяем, существует ли отдел с таким id
        Department existingDepartment = departmentService.getDepartmentById(id);
        if (existingDepartment != null) {
            // Если существует, обновляем данные
            existingDepartment.setName(department.getName());
            return departmentService.saveDepartment(existingDepartment); // сохраняем обновленные данные
        } else {
            // Если нет такого отдела, выбрасываем ошибку
            throw new RuntimeException("Отдел с id " + id + " не найден.");
        }
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        // Проверяем, существует ли отдел с таким id
        Department department = departmentService.getDepartmentById(id);
        if (department != null) {
            departmentService.deleteDepartment(id); // Если существует, удаляем
        } else {
            // Если нет такого отдела, выбрасываем ошибку
            throw new RuntimeException("Отдел с id " + id + " не найден.");
        }
    }
}
