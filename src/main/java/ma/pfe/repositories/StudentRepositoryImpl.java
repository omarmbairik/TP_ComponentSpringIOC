package ma.pfe.repositories;

import ma.pfe.entities.StudentEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository{
    private final static Logger LOG = LoggerFactory.getLogger(StudentRepositoryImpl.class);
    @Override
    public StudentEntity create(StudentEntity student) {
        LOG.debug(("Start methode create"));
        return student;
    }

    @Override
    public StudentEntity update(StudentEntity student) {
        LOG.debug(("Start methode update"));
        return student;
    }

    @Override
    public boolean delete(long id) {
        LOG.debug(("Start methode delete"));
        return true;
    }

    @Override
    public List<StudentEntity> readAll() {
        LOG.debug(("Start methode readAll"));
        return new ArrayList<StudentEntity>();
    }
}
