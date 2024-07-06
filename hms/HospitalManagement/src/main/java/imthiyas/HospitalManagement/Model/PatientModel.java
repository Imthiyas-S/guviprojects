package imthiyas.HospitalManagement.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "patient")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientModel {
    @Id

    private ObjectId id;
    private String name;
    private String gender;
    private String phno;
    private String address;

    @Override
    public String toString() {
        return "PatientModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phno='" + phno + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
