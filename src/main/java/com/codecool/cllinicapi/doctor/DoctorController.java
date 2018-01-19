package com.codecool.cllinicapi.doctor;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="/doctors")
public class DoctorController {
    
    private DoctorService service;
    
    public DoctorController(DoctorService service) {
        this.service = service;
    }
    
    @GetMapping(path="")
    public Iterable<Doctor> index(){
        return this.service.readAll();
    }
    
    @GetMapping(path="/{id}")
    public Doctor show(@PathVariable int id){
        return this.service.readById(id);
    }
    
    @PostMapping(path = "")
    public Iterable<Doctor> create(@RequestBody Iterable<Doctor> doctors){
        return this.service.create(doctors);
    }
    
    @PutMapping(path="/{id}")
    public Doctor update(@RequestBody Doctor doctor, @PathVariable int id){
        return this.service.update(doctor, id);
    }
    
    @DeleteMapping(path="/{id}")
    public void delete(@PathVariable int id){
        this.service.delete(id);
    }
}
