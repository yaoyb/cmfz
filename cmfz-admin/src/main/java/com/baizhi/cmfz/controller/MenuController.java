package com.baizhi.cmfz.controller;

import com.alibaba.fastjson.JSON;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 姚亚博 on 2018/7/5.
 */
@Controller
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuService ms;

    @RequestMapping("showFirst")
    @ResponseBody
    public List<Menu> showFirst(HttpSession session){
        List<Menu> MenuFirst = ms.queryAllFirst();
        session.setAttribute("MenuFirst",MenuFirst);
        return MenuFirst;
    }

    @RequestMapping("showSecond")
    @ResponseBody
    public List<Menu> showSecond(String id){
        System.out.println(id);
        List<Menu> MenuSecond = ms.querySecond(id);
        return MenuSecond;
    }
}
