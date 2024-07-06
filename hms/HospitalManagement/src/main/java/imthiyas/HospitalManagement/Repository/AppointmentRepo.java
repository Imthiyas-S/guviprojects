package imthiyas.HospitalManagement.Repository;

import imthiyas.HospitalManagement.Model.AppointmentModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends MongoRepository<AppointmentModel, ObjectId> {
}
