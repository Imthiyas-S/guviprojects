package imthiyas.HospitalManagement.Service;

import imthiyas.HospitalManagement.Model.DoctorModel;
import imthiyas.HospitalManagement.Repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired

    private DoctorRepo doctorRepo;

    public void addDoctor(DoctorModel e){
        doctorRepo.save(e);
    }
    public List<DoctorModel> getdoctor(){
        return doctorRepo.findAll();
    }
}
