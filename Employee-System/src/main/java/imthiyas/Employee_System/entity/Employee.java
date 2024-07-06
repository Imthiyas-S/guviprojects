package imthiyas.Employee_System.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;


@Document(collection = "Employee_System")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {


    @Id
    private ObjectId id;
    private String name;
    private ObjectId empId;
    private String address;
    private String email;
    private String phno;
    private String salary;

    public void generateEmpId() {
        this.empId = new ObjectId();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", empId=" + empId +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phno='" + phno + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
