package test.SpringMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by death on 2016/5/29.
 */
@Controller
@RequestMapping("/mvc")
public class mvcController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
