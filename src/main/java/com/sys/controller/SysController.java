package com.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sys.model.Record;
import com.sys.model.User;
import com.sys.service.CartService;
import com.sys.service.CustomerService;
import com.sys.service.RecordService;
import com.sys.service.UserService;
import com.sys.vo.CartVO;
import com.sys.vo.CustomerVO;
import com.sys.vo.RecordVO;
import com.sys.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("sys")
public class SysController {

    //用户服务
    private UserService userService;
    private CustomerService customerService;
    private RecordService recordService;
    private CartService cartService;
    public SysController(){}

    @Autowired
    public SysController(UserService userService,CustomerService customerService,RecordService recordService,CartService cartService) {
        this.userService = userService;
        this.customerService = customerService;
        this.recordService = recordService;
        this.cartService = cartService;
    }

    /**
     * 返回主页
     * @return
     */
    @RequestMapping("index")
    public String index(Model model,UserVO userVO, @RequestParam(defaultValue = "1") Integer pageNum){
        PageHelper.startPage(pageNum,3);
        System.out.println("开始查询");
        List<User> users = userService.query(userVO);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        System.out.println(pageInfo.getList().size());
        model.addAttribute("pageInfo",pageInfo);
        return "index";
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping("login")
    public String login(UserVO userVO, HttpServletRequest request){
    	request.getSession().setAttribute("basePath", "demo");
        if (request.getSession().getAttribute("user")!=null)return "redirect:index";
        if (userVO != null){
            if (userVO.getUsername() == null || userVO.getPassword()==null
            || "".equals(userVO.getUsername()) || "".equals(userVO.getPassword())){
            	
            }else{
                List<User> users = userService.query(userVO);
                if (users.size() > 0){
                	User currentUser = users.get(0);
                    request.getSession().setAttribute("user",currentUser);
                    request.getSession().setAttribute("msg", "登录成功!");
                    if (currentUser.getRole() == 1) {
                    	return "redirect:/sys/index";
					}else {
						return "redirect:/customer/home";
					}
                    
                }else {
                	request.getSession().setAttribute("msg","用户名/密码错误");
                }
            }
        }
        return "login";
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping("logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:login";
    }
    /**
     * 修改密码
     * @return
     */
    @RequestMapping("modifyPwd")
    public String modifyPwd(HttpServletRequest request,UserVO userVO){
    	if(userVO!=null && userVO.getPassword()!=null && !userVO.getPassword().equals("")) {
    		request.getSession().setAttribute("msg", "修改成功!");
    		User user = (User)request.getSession().getAttribute("user");
    		userVO.setPassword(userVO.getPassword());
    		userVO.setUsername("");
    		userVO.setId(user.getId());
    		userService.modify(userVO);
    		return "redirect:/sys/index";
    	}
        return "modifyPwd";
    }

    /**
     * 注册
     * @return
     */
    @RequestMapping("register")
    public String register(HttpServletRequest request,UserVO userVO){
        if (request.getSession().getAttribute("user")!=null)return "redirect:index";
        if (userVO != null){
            System.out.println();
            if (userVO.getUsername() == null || "".equals(userVO.getUsername())
            || userVO.getPassword() == null || "".equals(userVO.getPassword())){

            }else{
            	UserVO ifExist= new UserVO();
            	ifExist.setUsername(userVO.getUsername());
            	if(userService.query(ifExist).size() > 0) {
            		request.setAttribute("msg", "用户名已存在");
            		return "login";
            	}
            	
                userService.add(userVO);
                CustomerVO customerVO = new CustomerVO();
                customerVO.setUserId(userVO.getId());
                customerVO.setEmail(userVO.getEmail());
                customerVO.setPhoneNumber(userVO.getPhoneNumber());
                customerService.add(customerVO);
                request.getSession().setAttribute("loginMsg", "注册成功!");
                return "login";
            }
        }
        return "register";
    }
    /**
     * 清空session
     * @return
     */
    
    @RequestMapping("clearSession")
    public String clearSession(HttpServletRequest request){
        request.getSession().removeAttribute("msg");
        return "清除成功!";
    }
    /**
     * 查看所有的消费记录
     * @return
     */
    @RequestMapping("checkRecord")
    public String checkRecord(Model model, @RequestParam(defaultValue = "1") Integer pageNum,HttpServletRequest request){
        PageHelper.startPage(pageNum,3);
        System.out.println("开始查询");
        User user = (User)request.getSession().getAttribute("user");
        RecordVO recordVO = new RecordVO();
        if (user.getRole() != 1) {
        	recordVO.setUserId(user.getId());
		}
        List<Record> records = recordService.query(recordVO);
        for (Record record : records) {
        	CartVO condition = new CartVO();
        	condition.setRecordId(record.getId());
			record.setCarts(cartService.query(condition));
		}
        PageInfo<Record> pageInfo = new PageInfo<>(records);
        System.out.println(pageInfo.getList().size());
        model.addAttribute("pageInfo",pageInfo);
        return "record/index";
    }
}
