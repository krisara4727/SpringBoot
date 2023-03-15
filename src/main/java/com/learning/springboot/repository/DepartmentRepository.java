package com.learning.springboot.repository;

import com.learning.springboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDeptName(String departmentName);
    public Department findByDeptNameIgnoreCase(String departmentName);
}
