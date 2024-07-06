package imthiyas.HospitalManagement.Service;

import imthiyas.HospitalManagement.Model.PatientModel;
import imthiyas.HospitalManagement.Repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepo patientRepo;
    public void addPatient(PatientModel e){
        patientRepo.save(e);
    }
    public List<PatientModel> getPatient(){
        return patientRepo.findAll();
    }
}
