package sep.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sep.entity.Employee;
import sep.service.EmployeeService;

import java.util.List;

@RestController
@Tag(name = "Employee Controller",description = "this is employee controller class")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/allEmployees")
    @Operation(summary = "this API get all employees",
            description = "with this API we can get all the employees from the Database"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "successfully retrieved List fo Employee "),
            @ApiResponse(responseCode = "404", description = "resource not found")
    })
    public List<Employee> getAll(){
        return service.findAlLEmployees();
    }
    @PostMapping("/saveEmployee")
    @Operation(method = "post", summary = "Save Employee",description = "It will save the Employee object by the requestBody")
    @ApiResponses({
            @ApiResponse(responseCode = "201",description = "successfully saved an Employee"),
            @ApiResponse(responseCode = "401", description = "not authorized to perform this operation")
    })
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
        Employee newEmp = service.saveEmployee(emp);
        return new ResponseEntity<>(newEmp, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    @Operation(method = "delete",summary = "delete Employee",description = "This is method to delete employee by ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "successfully deleted employee "),
            @ApiResponse(responseCode = "401", description = "not authorized to perform this operation")
    })
    public String deleteEmployee(@PathVariable  int id) throws Exception{
        return service.delete(id);
    }
    @GetMapping("/employee/{id}")
    public Employee findOneEmployee(@PathVariable int id) throws Exception{
        return  service.findOne(id);
    }

    @PutMapping("/update/{id}")
    public Employee update(@RequestBody Employee emp, @PathVariable int id){
        return  service.update(emp, id);
    }
}
