package imthiyas.HospitalManagement.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "appointment")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppointmentModel {

    @Id

    private ObjectId id;
    private String doctorName;
    private String patientName;
    public String date;

    @Override
    public String toString() {
        return "AppointmentModel{" +
                "id=" + id +
                ", doctorName='" + doctorName + '\'' +
                ", patientName='" + patientName + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
