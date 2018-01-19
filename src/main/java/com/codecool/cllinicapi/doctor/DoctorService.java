package com.codecool.cllinicapi.doctor;

public interface DoctorService {
    
    Iterable<Doctor> readAll();
    Doctor readById(int id);
    Iterable<Doctor> create(Iterable<Doctor> doctors);
    Doctor update(Doctor doctor, int id);
    void delete(int id);
}
