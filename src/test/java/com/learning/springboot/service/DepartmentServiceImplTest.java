package com.learning.springboot.service;

import com.learning.springboot.entity.Department;
import com.learning.springboot.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceImplTest {
    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .deptName("IT")
                        .deptAddress("Ahmedabad")
                        .deptCode("IT-06")
                        .deptId(1L)
                        .build();

        Mockito.when(departmentRepository.findByDeptNameIgnoreCase("IT"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get Data based on Valida Department Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "IT";
        Department found =
                departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDeptName());
    }
}