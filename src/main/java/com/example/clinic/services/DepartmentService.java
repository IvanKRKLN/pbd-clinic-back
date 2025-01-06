package com.example.clinic.services;

import com.example.clinic.entities.Department;
import com.example.clinic.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Получение всех отделений
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Сохранение нового или обновленного отделения
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Удаление отделения по ID
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    // Получение отделения по ID
    public Department getDepartmentById(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        return department.orElse(null);  // Если отделение не найдено, возвращаем null
    }
}
