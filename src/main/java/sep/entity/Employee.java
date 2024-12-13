package sep.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@Table(name = "")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "emp_name")
    private String name;
    @Column(name = "emp_salary")
    private float salary;
    @Column(name = "emp_email")
    private String email;
    @Column(name = "emp_dept")
    private String dept;
}
