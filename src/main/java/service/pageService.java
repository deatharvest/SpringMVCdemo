package service;

import dao.PageDao;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by death on 2016/5/31.
 */

public class PageService {

    @Autowired
    PageDao pageDao;

    public List<Student> findall(){
        return pageDao.findAll();
    }



}
