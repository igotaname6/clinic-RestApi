package com.codecool.cllinicapi.clinic;

import com.codecool.cllinicapi.doctor.Doctor;

import java.util.List;

public interface ClinicService {
    
    Iterable<Clinic> readAll();
    Clinic readById(int id);
    Clinic create(Clinic clinic);
    Clinic update(Clinic clinic, int id);
    void delete(int id);
    Clinic boundDoctors(List<Integer> doctorsIds, int clinicId);
}


