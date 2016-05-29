package repository;


import model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by death on 2016/5/27.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByStuName(String stuName);
}
