package com.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sys.model.User;
import com.sys.service.UserService;
import com.sys.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@org.springframework.web.bind.annotation.RestController
@RequestMapping("rest")
public class RestController {
    /**
     * 清空session
     * @return
     */
    @RequestMapping("clearSession")
    public String clearSession(HttpServletRequest request){
        request.getSession().removeAttribute("msg");
        
        return "清除成功!";
    }
    @RequestMapping("clearLoginSession")
    public String clearLoginSession(HttpServletRequest request){
        request.getSession().removeAttribute("loginMsg");
        
        return "清除成功!";
    }
}
