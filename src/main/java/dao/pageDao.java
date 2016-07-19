package dao;

import model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by death on 2016/5/31.
 */
public interface PageDao extends JpaRepository<Student, Integer> {
}
