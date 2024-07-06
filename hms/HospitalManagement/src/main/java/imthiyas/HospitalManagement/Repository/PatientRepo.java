package imthiyas.HospitalManagement.Repository;

import imthiyas.HospitalManagement.Model.PatientModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends MongoRepository<PatientModel, ObjectId> {
}
