package imthiyas.Employee_System.service;

import imthiyas.Employee_System.entity.Employee;
import imthiyas.Employee_System.repository.EmployeeRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepo repo;

    @Autowired
    public EmployeeService(EmployeeRepo repo){
        this.repo = repo;
    }
    public void addEmployee(Employee employee){
       if (employee.getEmpId() == null){
           employee.generateEmpId();
       }
    repo.save(employee);
    }

    public List<Employee> getAllEmployee(){
       return repo.findAll();
    }
    public Employee getEmployeeById(ObjectId id){
        Optional<Employee> employee =repo.findById(id);
        return employee.orElse(null);
    }
    public void deleteEmployee(ObjectId id){
        repo.deleteById(id);
    }
}
