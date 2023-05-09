package com.UST.CompanyForm.controller;

import com.UST.CompanyForm.dto.EmpReq;
import com.UST.CompanyForm.entity.Employee;
import com.UST.CompanyForm.entity.Manager;
//import com.UST.CompanyForm.exception.IdNotFoundException;
import com.UST.CompanyForm.exception.IdNotFoundException;
import com.UST.CompanyForm.repository.EmployeeRepo;
import com.UST.CompanyForm.repository.ManagerRepo;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class CompanyController {
    @Autowired
    private EmployeeRepo repo1;
    @Autowired
    private ManagerRepo repo2;
    @PostMapping("/postemp")
    public ResponseEntity<Employee> emppost(@RequestBody @Valid EmpReq emp){
        Employee eep=new Employee(0L,emp.getName(),emp.getDept());
        repo1.save(eep);
        return ResponseEntity.ok().body(eep);
    }
    @PostMapping("/postman")
    public ResponseEntity<Manager> manpost(@RequestBody Manager man){
        repo2.save(man);
        return ResponseEntity.ok().body(man);
    }
    @GetMapping("/getemp")
    public ResponseEntity<List<Employee>> getemp(){
        return ResponseEntity.ok().body(repo1.findAll());
    }
    @GetMapping("/getman")
    public ResponseEntity<List<Manager>> getman(){
        return ResponseEntity.ok().body(repo2.findAll());
    }
    @GetMapping("/empby/{id}")
    public ResponseEntity<Employee> empbyid(@PathVariable Long id) throws IdNotFoundException {
        Optional<Employee> empp=repo1.findById(id);
        if(empp.isPresent()){
            return ResponseEntity.ok().body(repo1.findById(id).orElse(null));
        }
        else{
//            return ResponseEntity.noContent().build();
            throw new IdNotFoundException("NO MSG");
        }
    }
    @GetMapping("/manby/{id}")
    public ResponseEntity<Manager> manbyid(@PathVariable Long id) throws IdNotFoundException {
        Optional<Manager> mann=repo2.findById(id);
        if(mann.isPresent()){
            return ResponseEntity.ok().body(repo2.findById(id).orElse(null));
        }
        else{
//            return ResponseEntity.noContent().build();
            throw new IdNotFoundException("no msg");
        }

    }
    @PutMapping("/empput/{id}")
    public ResponseEntity<Employee> updateemp(@RequestBody @Valid EmpReq empp,@PathVariable Long id){
        Optional<Employee> emppp=repo1.findById(id);
        if(emppp.isPresent()){
            Employee empp1=null;
            Optional<Employee> epp=repo1.findById(id);
            empp1=epp.get();
            empp1.setId(id);
            empp1.setName(empp.getName());
            empp1.setDept(empp.getDept());
            return ResponseEntity.ok().body(repo1.save(empp1));
        }
        else{
            return ResponseEntity.noContent().build();

        }
    }
    @PutMapping("/putman/{id}")
    public ResponseEntity<Manager> mannupdate(@RequestBody @Valid EmpReq empReq,@PathVariable Long id){

        Manager man=null;
        Optional<Manager> mannn=repo2.findById(id);
        if(mannn.isPresent()){
            man=mannn.get();
            man.setId(id);
            man.setName(man.getName() );
            man.setDept(man.getDept());
            return ResponseEntity.ok().body(repo2.save(man));
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }
    @DeleteMapping("/deleteemm/{id}")
    public ResponseEntity<String> deleteemp(@PathVariable Long id){
        Optional<Employee> empdel=repo1.findById(id);
        if(empdel.isPresent()){
            repo1.deleteById(id);
            return ResponseEntity.ok().body("deleted..");
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }
    @DeleteMapping("/delmann/{id}")
    public ResponseEntity<String> mandel(@PathVariable Long id){
        Optional<Manager> mann=repo2.findById(id);
        if(mann.isPresent()){
            repo2.deleteById(id);
            return ResponseEntity.ok().body("deleted..");
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }
}
