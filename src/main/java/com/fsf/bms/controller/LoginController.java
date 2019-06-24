package com.fsf.bms.controller;

import com.fsf.bms.dao.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Administrator
 * @title: LoginController
 * @projectName fsf-bms
 * @description: TODO
 * @date 2019/6/19 001918:05
 */

@Controller
public class LoginController {

    /**
     * 访问项目根路径
     * @param model
     * @return
     */
    @GetMapping(value = "/")
    public String root(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        if(user == null){
            return "redirect:/login";
        }else{
            return  "redirect:/index";
        }
    }

    /**
     * 跳转到login页面
     * @param model
     * @return
     */
    @GetMapping(value = "/login")
    public String login(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        if(user == null){
            return "login";
        }else{
            return "redirect:index";
        }
    }

    /**
     * 用户登录
     * @param request
     * @param username
     * @param password
     * @param model
     * @param session
     * @return
     */
    @PostMapping(value = "/login")
    public String loginUser(HttpServletRequest request, String username, String password, Model model, HttpSession session){
        //对密码进行加密
        //password=new SimpleHash("md5", password, ByteSource.Util.bytes(username.toLowerCase() + "shiro"),2).toHex();
        //如果有点击  记住我
        //UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password,remeberMe);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();

        try {
            //登录操作
            subject.login(usernamePasswordToken);
            User user = (User) subject.getPrincipal();
            session.setAttribute("user", user);
            model.addAttribute("user", user);
            return "index";
        }catch (Exception e){
            //登录失败从request中获取shiro处理的异常信息 shiroLoginFailure:就是shiro异常类的全类名
            String exception = (String) request.getAttribute("shiroLoginFailure");
            model.addAttribute("msg",e.getMessage());
            //返回登录页面
            return "login";
        }
    }


}
