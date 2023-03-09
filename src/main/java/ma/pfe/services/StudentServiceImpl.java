package ma.pfe.services;

import ma.pfe.dtos.StudentDto;
import ma.pfe.entities.StudentEntity;
import ma.pfe.mappers.StudentMapper;
import ma.pfe.repositories.StudentRepository;
import ma.pfe.repositories.StudentRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentServices{

    private final static Logger LOG = LoggerFactory.getLogger(StudentServiceImpl.class);
    private StudentRepository repository;
    private StudentMapper mapper;

    // Constrecteur
    public StudentServiceImpl(StudentRepository repository, StudentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    // Methode create student
    @Override
    public StudentDto create(StudentDto dto) {
        LOG.debug(("Start methode Create"));
        StudentDto resulta = mapper.convertToDto(repository.create(mapper.converttoEntity(dto)));
        LOG.debug("End methode Create");
        return  resulta;
    }

    // Methode update student
    @Override
    public StudentDto update(StudentDto dto) {
        LOG.debug(("Start methode update"));
        StudentDto resulta = mapper.convertToDto(repository.update(mapper.converttoEntity(dto)));
        LOG.debug("end methode update");
        return resulta;
    }

    //Methode delete Student
    @Override
    public boolean delete(long id) {
        LOG.debug(("Start methode delete"));
        boolean resulta = repository.delete(id);
        LOG.debug("End methode delete");
        return resulta;
    }

    //Methode readAll students
    @Override
    public List<StudentDto> readAll() {
        LOG.debug(("Start methode ReadAll"));
        List<StudentDto> resulta = mapper.convertToDtos(repository.readAll());
        LOG.debug("End methode ReadAll");
        return resulta;
    }
}
