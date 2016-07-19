package service;

import dao.StudentDao;
import model.Pager;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("jdbcSqlStudentService")
public class JdbcSqlStudentServiceImpl implements StudentService {

	@Autowired
	@Qualifier("jdbcSqlStudentDao")
	private StudentDao studentDao;

	@Override
	public Pager<Student> findStudent(Student searchModel, int pageNum,
									  int pageSize) {
		Pager<Student> result = studentDao.findStudent(searchModel, pageNum,
				pageSize);
		return result;
	}

}
