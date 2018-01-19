package com.codecool.cllinicapi.doctor;

import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImp implements DoctorService{
    
    DoctorRepository repository;
    
    public DoctorServiceImp(DoctorRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public Iterable<Doctor> readAll() {
        return this.repository.findAll();
    }
    
    @Override
    public Doctor readById(int id) {
        return this.repository.findOne(id);
    }
    
    @Override
    public Iterable<Doctor> create(Iterable<Doctor> doctors) {
        return this.repository.save(doctors);
    }
    
    @Override
    public Doctor update(Doctor doctor, int id) {
        doctor.setId(id);
        return this.repository.save(doctor);
    }
    
    @Override
    public void delete(int id) {
        this.repository.delete(id);
    }
}
