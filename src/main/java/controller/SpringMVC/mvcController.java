package controller.SpringMVC;

import model.Constant;
import model.Pager;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.JdbcSqlStudentServiceImpl;
import service.StudentService;
import util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by death on 2016/5/29.
 */
@Controller
@RequestMapping("/mvc")
public class MvcController {

    @Autowired
    @Qualifier("jdbcSqlStudentService")
    private StudentService studentService;


    @RequestMapping("/page")
    @ResponseBody
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response)
    {
        // 接收request里的参数
        String stuName = request.getParameter("stuName"); //学生姓名

        // 获取学生性别
        int gender = Constant.DEFAULT_GENDER;
        String genderStr = request.getParameter("gender");
        if(genderStr!=null && !"".equals(genderStr.trim())){
            gender = Integer.parseInt(genderStr);
        }

        // 校验pageNum参数输入合法性
        String pageNumStr = request.getParameter("pageNum");
        if(pageNumStr !=null && !StringUtil.isNum(pageNumStr)){
       //     request.setAttribute("errorMsg", "参数传输错误");
       //     request.getRequestDispatcher("jdbcSqlStudent.jsp").forward(request, response);
            return new ModelAndView("jdbcSqlStudent.jsp").addObject("errorMsg","参数传递错误！").addObject(request).addObject(response);
        }

        int pageNum = Constant.DEFAULT_PAGE_NUM; //显示第几页数据
        if(pageNumStr!=null && !"".equals(pageNumStr.trim())){
            pageNum = Integer.parseInt(pageNumStr);
        }

        int pageSize = Constant.DEFAULT_PAGE_SIZE;  // 每页显示多少条记录
        String pageSizeStr = request.getParameter("pageSize");
        if(pageSizeStr!=null && !"".equals(pageSizeStr.trim())){
            pageSize = Integer.parseInt(pageSizeStr);
        }

        // 组装查询条件
        Student searchModel = new Student();
        searchModel.setStuName(stuName);
        searchModel.setGender(gender);

        //调用service 获取查询结果
        Pager<Student> result = studentService.findStudent(searchModel,
                pageNum, pageSize);
        return new ModelAndView("/jdbcSql/jdbcSqlStudent").addObject("result",result);
    }

}
