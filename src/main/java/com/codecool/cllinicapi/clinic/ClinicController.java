package com.codecool.cllinicapi.clinic;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/clinics")
public class ClinicController {
    
    private ClinicService clinicService;
    
    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }
    
    @GetMapping(path="")
    public Iterable<Clinic> index(){
        return this.clinicService.readAll();
    }
    
    @GetMapping("/{id}")
    public Clinic show(@PathVariable Integer id ){
        return this.clinicService.readById(id);
    }
    
    @PostMapping(path="")
    public Clinic create(@RequestBody Clinic clinic){
        return this.clinicService.create(clinic);
    }
    
    @PutMapping(path="/{id}")
    public Clinic update(@RequestBody Clinic clinic, @PathVariable int id){
        return this.clinicService.update(clinic, id);
    }
    
    @DeleteMapping(path="/{id}")
    public void update(@PathVariable int id){
        this.clinicService.delete(id);
    }
    
    @PutMapping(path="/{clinicId}/doctors")
    public Clinic boundDoctors(@RequestBody List<Integer> doctorsId, @PathVariable Integer clinicId){
        return this.clinicService.boundDoctors(doctorsId, clinicId);
    }
}
