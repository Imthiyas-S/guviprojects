package imthiyas.HospitalManagement.Service;

import imthiyas.HospitalManagement.Model.AppointmentModel;
import imthiyas.HospitalManagement.Repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepo appointmentRepo;
    public void addAppointment(AppointmentModel e)
    {
        appointmentRepo.save(e);
    }
public List<AppointmentModel> getappointment(){
        return appointmentRepo.findAll();
}

}
