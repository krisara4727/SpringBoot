package com.learning.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deptId;
    @NotBlank(message = "please add department name")
    @Length(max=5, min = 2)
    private String deptName;
    private String deptAddress;
    private String deptCode;

    @Override
    public String toString(){
        return "Department{"+
                "departmentName '"+ deptName+'\''+
                "department Id '"+ deptId+ '\''+
                "department address '"+ deptAddress+'\''+
                "department code'"+ deptCode+'\'';
    }

    public String getDepartmentName() {
        return this.deptName;
    }

    public void setDepartmentName(String departmentName) {
        this.deptName = departmentName;
    }

    public String getDepartmentCode() {
        return this.deptCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.deptCode = departmentCode;
    }

    public String getDepartmentAddress() {
        return this.deptAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.deptAddress = departmentAddress;
    }
}
