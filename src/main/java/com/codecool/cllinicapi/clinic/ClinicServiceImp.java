package com.codecool.cllinicapi.clinic;

import com.codecool.cllinicapi.doctor.Doctor;
import com.codecool.cllinicapi.doctor.DoctorRepository;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.Collection;
import java.util.List;

@Service
public class ClinicServiceImp implements ClinicService{
    
    private DoctorRepository doctorRepository;
    private ClinicRepository repository;
    
    public ClinicServiceImp(ClinicRepository repository, DoctorRepository doctorRepository) {
        this.repository = repository;
        this.doctorRepository = doctorRepository;
    }
    
    public Iterable<Clinic> readAll(){
        return this.repository.findAll();
    }
    
    public Clinic readById(int id){
        return this.repository.findOne(id);
    }
    
    public Clinic create(Clinic clinic){
        this.repository.save(clinic);
        return clinic;
    }
    
    @Override
    public Clinic update(Clinic clinic, int id) {
        clinic.setId(id);
        this.repository.save(clinic);
        return this.repository.findOne(id);
    }
    
    @Override
    public void delete(int id) {
        this.repository.delete(id);
    }
    
    @Override
    public Clinic boundDoctors(List<Integer> doctorsId, int id) {
        Iterable<Doctor> doctors  =  this.doctorRepository.findAll(doctorsId);
        
        Clinic clinic = this.repository.findOne(id);
        doctors.forEach((doctor -> clinic.getEmployedDoctors().add(doctor)));
        return this.repository.save(clinic);
    }
}
