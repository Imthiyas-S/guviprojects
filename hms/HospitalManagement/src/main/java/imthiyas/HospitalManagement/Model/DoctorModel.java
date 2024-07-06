package imthiyas.HospitalManagement.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "doctor")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoctorModel {
    @Id

    private ObjectId id;
    private String name;
    private String phno;
    private String special;

    @Override
    public String toString() {
        return "DoctorModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phno='" + phno + '\'' +
                ", special='" + special + '\'' +
                '}';
    }
}
