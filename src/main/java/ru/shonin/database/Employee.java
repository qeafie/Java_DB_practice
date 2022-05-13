package ru.shonin.database;
import org.springframework.data.annotation.Id;

public class Employee {
    @Id
    private  Integer id;
    private String name;
    private Integer departmentId;

    private String department;

    public Employee() {
    }

    public Employee(Integer id, String name, Integer departmentId, String department) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
        this.department = department;
    }

    public Employee(Integer id, String name, Integer departmentId) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", departmentId=" + departmentId +
                ", department='" + department + '\'' +
                '}';
    }
}
