package imthiyas.HospitalManagement.Repository;

import imthiyas.HospitalManagement.Model.DoctorModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends MongoRepository<DoctorModel, ObjectId> {
}
