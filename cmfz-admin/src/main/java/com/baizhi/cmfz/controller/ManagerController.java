package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.util.NewValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by 姚亚博 on 2018/7/4.
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService ms;

    @RequestMapping("/login")
    public String login(String name, String password,String checkbox, String enCode, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("code");
        if(enCode.equalsIgnoreCase(code)){
            Manager m = (ms.queryOne(name,password));
            if(m!=null){
                if(checkbox!=null){
                    //通过Cookie填充用户名/密码
                    name = URLEncoder.encode(name, "UTF-8");
                    Cookie c1 = new Cookie("name",name);
                    Cookie c2 = new Cookie("password",password);
                    c1.setMaxAge(60*60*24);
                    c2.setMaxAge(60*60*24);
                    c1.setPath("/");
                    c2.setPath("/");
                    response.addCookie(c1);
                    response.addCookie(c2);
                }
                return "index";
            }
        }
        return "login";
    }

    @RequestMapping("/getVcode")
    public void create(HttpSession session, HttpServletResponse response) throws IOException {

        NewValidateCodeUtils codes=new NewValidateCodeUtils(130, 50, 4);

        session.setAttribute("code", codes.getCode());

        codes.write(response.getOutputStream());

    }

}
