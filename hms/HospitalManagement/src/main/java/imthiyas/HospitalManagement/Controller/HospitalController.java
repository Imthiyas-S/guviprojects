package imthiyas.HospitalManagement.Controller;

import imthiyas.HospitalManagement.Model.AppointmentModel;
import imthiyas.HospitalManagement.Model.DoctorModel;
import imthiyas.HospitalManagement.Model.PatientModel;
import imthiyas.HospitalManagement.Repository.AppointmentRepo;
import imthiyas.HospitalManagement.Repository.DoctorRepo;
import imthiyas.HospitalManagement.Repository.PatientRepo;
import imthiyas.HospitalManagement.Service.AppointmentService;
import imthiyas.HospitalManagement.Service.DoctorService;
import imthiyas.HospitalManagement.Service.PatientService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
public class HospitalController {

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private DoctorRepo doctorRepo;
    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private AppointmentRepo appointmentRepo;


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model m) {
        List<DoctorModel> doc = doctorService.getdoctor();
        List<PatientModel> pat = patientService.getPatient();
        List<AppointmentModel> app = appointmentService.getappointment();
        long dc = 0;
        long pc = 0;
        long ac = 0;
        dc = doc.stream().count();
        pc = pat.stream().count();
        ac = app.stream().count();
        m.addAttribute("pcount", pc);
        m.addAttribute("dcount", dc);
        m.addAttribute("acount", ac);
        return "index";
    }

    @RequestMapping(path = "/adddoctor", method = RequestMethod.GET)
    public String viewDoctor() {
        return "Add_Doctor";
    }

    @RequestMapping(path = "/addDoctor", method = RequestMethod.POST)
    public String doctorRegister(DoctorModel e, Model m) {
        doctorService.addDoctor(e);

        return "redirect:/view_doctor";
    }

    @RequestMapping(path = "/view_doctor", method = RequestMethod.GET)
    public String getDoctor(Model m) {
        List<DoctorModel> doc = doctorService.getdoctor();
        long c = 0;
        c = doc.stream().count();
        m.addAttribute("doc", doc);
        m.addAttribute("co", c);

        return "view_Doctor";
    }

    @RequestMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") ObjectId id, Model model) {
        DoctorModel user = doctorRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);
        return "update_doctor";
    }

    @RequestMapping(path = "/update_Doctor/{id}", method = RequestMethod.POST)
    public String updateDoctor(@PathVariable("id") ObjectId id, DoctorModel d, BindingResult result, Model m) {
        if (result.hasErrors()) {
            d.setId(id);
            return "update_doctor";
        }
        doctorService.addDoctor(d);

        return "redirect:/view_doctor";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") ObjectId id, Model model) {
        DoctorModel user = doctorRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        doctorRepo.delete(user);
        return "redirect:/view_doctor";
    }

    @RequestMapping(path = "/addpatient", method = RequestMethod.GET)
    public String viewPatient() {
        return "Add_Patient";
    }

    @RequestMapping(path = "/addPatient", method = RequestMethod.POST)
    public String patientRegister(PatientModel e, Model m) {
        patientService.addPatient(e);

        return "redirect:/view_patient";
    }

    @RequestMapping(path = "/view_patient", method = RequestMethod.GET)
    public String getPatient(Model m) {
        List<PatientModel> pat = patientService.getPatient();
        m.addAttribute("pat", pat);
        return "view_Patient";
    }

    @GetMapping("/edit_patient/{id}")
    public String showUpdateFormPatient(@PathVariable("id") ObjectId id, Model model) {
        PatientModel user = patientRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);
        return "update_patient";
    }
    @RequestMapping(path = "/update_Patient/{id}",method = RequestMethod.POST)
    public String updatePatient(@PathVariable("id") ObjectId id, PatientModel d, BindingResult result, Model m){
        if (result.hasErrors()){
            d.setId(id);
            return "update_patient";

        }
        patientService.addPatient(d);
       ;
        return "redirect:/view_patient";
    }
    @GetMapping("/delete_patient/{id}")
    public String deletePatient(@PathVariable ("id") ObjectId id,Model model){
        PatientModel user = patientRepo.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Invalid user id" + id));
        patientRepo.delete(user);
        return "redirect:/view_patient";
    }

    @RequestMapping(path = "/addappointment",method = RequestMethod.GET)
    public String viewAppointment(Model m){
        List<DoctorModel> doc =doctorService.getdoctor();
        List<PatientModel> pat=patientService.getPatient();
        m.addAttribute("pat", pat);
        m.addAttribute("doc",doc);
        return "Add_Appointment";
    }
    @RequestMapping(path = "/addAppointment",method = RequestMethod.POST)
    public String appointmentRegister(AppointmentModel e,Model m){
        appointmentService.addAppointment(e);

        return "redirect:/view_appointment";

    }
    @RequestMapping(path = "/view_appointment",method = RequestMethod.GET)
    public String getAppointment(Model m){
        List<AppointmentModel> pat =appointmentService.getappointment();
        m.addAttribute("pat",pat);
        return "view_appointment";
    }
    @GetMapping("/edit_appointment/{id}")
    public String showUpdateFormAppointment(@PathVariable("id") ObjectId id,Model model){
        AppointmentModel user =appointmentRepo.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Invalid user id" + id));
        model.addAttribute("user",user);
        return "update_appointment";
    }
    @RequestMapping(path = "/update_Appointment/{id}",method = RequestMethod.POST)
    public String updateAppointment(@PathVariable("id" ) ObjectId id,AppointmentModel d,BindingResult result,Model m){
        if(result.hasErrors()){
            d.setId(id);
            return "update_appointment";

        }
        appointmentService.addAppointment(d);

        return "redirect:/view_appointment";
    }
    @RequestMapping(path = "/update_appointment_value/{id}",method = RequestMethod.GET)
    public ResponseEntity<List<AppointmentModel>>updateAppointmentvalue(@PathVariable("id") ObjectId id,AppointmentModel d,BindingResult result,Model m){
        return ResponseEntity.ok().body(appointmentRepo.findAllById(Collections.singleton(id)));

    }
    @GetMapping("/delete_appointment/{id}")
    public String deleteAppointment(@PathVariable("id") ObjectId id,Model model){
        AppointmentModel user= appointmentRepo.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Invalid user id" + id));
        appointmentRepo.delete(user);
        return "redirect:/view_appointment";


    }



    @RequestMapping(path = "/getdoc",method = RequestMethod.GET)
    public ResponseEntity<List<DoctorModel>> docdata(){
        return ResponseEntity.ok().body(doctorService.getdoctor());
    }
    @RequestMapping(path = "/getpat",method = RequestMethod.GET)
    public ResponseEntity<List<PatientModel>> patdata(){
        return ResponseEntity.ok().body(patientService.getPatient());
    }
}
