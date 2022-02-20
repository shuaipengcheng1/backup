package com.mi.login_submit.Controller;

import com.mi.login_submit.Domain.User;
import com.mi.login_submit.Service.LoginSubmitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    LoginSubmitServiceImpl loginSubmitService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map Login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletResponse response, HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Credentials", "true");

        Map map = new HashMap();
        User user = loginSubmitService.Login(username, password);
        if (user == null) {
            map.put("state", false);
            map.put("user", null);
            map.put("message", "失败");

        } else {
//           放一个cookie
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("password", password);
            map.put("state", true);
            map.put("user", user);
            map.put("message", "成功");
        }
        return map;
    }

    @RequestMapping(value = "/Submit", method = RequestMethod.POST)
    public Map Submit(@RequestParam("username") String username, @RequestParam("password") String password) {
        Map map = new HashMap();
        Boolean state = null;
//        检查是否重名
        Boolean check = loginSubmitService.Check_Name(username);
        if (check) {
//            没重名
            state = loginSubmitService.Submit(username, password);
            if (state) {
                map.put("state", true);
                map.put("message", "成功");
            } else {
                map.put("state", false);
                map.put("message", "失败");

            }
        } else {
//            重名

            map.put("state", false);
            map.put("message", "不能重名");


        }
        return map;

    }

    @RequestMapping("/check")
    public Map map(){
//
        Map map = new HashMap();
        map.put("state", true);
        map.put("message", "已登录");
        return map;
    }

}
