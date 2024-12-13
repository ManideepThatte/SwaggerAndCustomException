package sep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sep.entity.Employee;
import sep.exception.EmployeeIdNotFoundException;
import sep.repo.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAlLEmployees(){
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee emp) {
        return  employeeRepository.save(emp);
    }

    public String delete(int id) throws Exception{
        Optional<Employee> optEmp = employeeRepository.findById(id);
        if(optEmp.isEmpty()){
            throw new EmployeeIdNotFoundException("employee with ID: "+id+" is not found");
        }else {
            employeeRepository.deleteById(id);
            return "employee with ID: "+id+" is deleted";
        }
    }
    public Employee update(Employee employee, int id){
        Employee emp = employeeRepository.findById(id).get();
        emp.setName(employee.getName());
        emp.setDept(employee.getDept());
        emp.setEmail(employee.getEmail());
        emp.setSalary(employee.getSalary());
        return employeeRepository.save(emp);
    }

    public Employee findOne(int id) throws Exception {
       /* Optional<Employee> optionalEmployee= employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            return optionalEmployee.get();
        }else{
            throw  new EmployeeIdNotFoundException("employee with ID: "+id+" is not found");
        }*/

        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeIdNotFoundException("employee with ID: " + id + " is not found"));
    }
}
