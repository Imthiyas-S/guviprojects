package imthiyas.Employee_System.repository;

import imthiyas.Employee_System.entity.Employee;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface EmployeeRepo  extends MongoRepository<Employee, ObjectId> {
}
