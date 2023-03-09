package ma.pfe.controllers;

import ma.pfe.dtos.StudentDto;
import ma.pfe.services.StudentServiceImpl;
import ma.pfe.services.StudentServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")

public class StudentController {

    private final static Logger LOG = LoggerFactory.getLogger(StudentController.class);
    private StudentServices service;

    // Constrecteur
    public StudentController(StudentServices service) {
        this.service = service;
    }

    @PostMapping("/save")
    public StudentDto save (@RequestBody StudentDto dto){
        LOG.debug(("Start methode seave: {}"),dto);
        StudentDto resulta = service.create(dto);
        LOG.debug("End methode save");
        return resulta;
    }

    @PutMapping("/update")
    public StudentDto update(@RequestBody  StudentDto dto){
        LOG.debug(("Start methode update: {}"),dto);
        StudentDto resulta = service.update(dto);
        LOG.debug("End methode update");
        return resulta;
    }

    //Methode Delete
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") long id){
        LOG.debug(("Start methode delete"));
        boolean resault = service.delete(id);
        LOG.debug("end methode delete");
        return resault;
    }

    @GetMapping
    public List<StudentDto> selectAll(){
        LOG.debug(("Start methode selectAll"));
        List<StudentDto> resault = service.readAll();
        LOG.debug("End methode selectAll");
        return resault;
    }
}
