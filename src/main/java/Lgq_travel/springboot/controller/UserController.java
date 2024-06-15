package Lgq_travel.springboot.controller;

import Lgq_travel.springboot.entity.User;
import Lgq_travel.springboot.service.UserService;
import Lgq_travel.springboot.utils.MD5Utils;
import Lgq_travel.springboot.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    public UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userLogin(HttpSession session, HttpServletRequest request, Model model, HttpServletResponse response, User user) {
        String verifyCodeValue = (String) session.getAttribute("verifyCodeValue");
        String inputVerifyCode = request.getParameter("verifyCode");
        System.out.println("username:" + user.getUsername());
        System.out.println("password:" + user.getPassword());
        //验证码是否正确，toUpperCase（）：小写转大写
        if (verifyCodeValue.equals(inputVerifyCode.toUpperCase())) {
            user.setPassword(MD5Utils.md5((String) user.getPassword()));
            User u = userService.UserLogin(user);
            if (u == null) {
                model.addAttribute("errorInfo", "用户名，密码错误或者账户未激活，请重新检查");
                return "user/login";
            } else {
                //获取自动登录状态
                String autoLogin = request.getParameter("autoLogin");
                if ("autoLogin".equals(autoLogin)) {
                    //导入Cookie
                    Cookie cookie_username = new Cookie("cookie_username", user.getUsername());
                    cookie_username.setMaxAge(10 * 60);
                    Cookie cookie_password = new Cookie("cookie_password", user.getPassword());
                    cookie_password.setMaxAge(10 * 60);
                }
                session.setAttribute("user", u);
                return "redirect:/user";
//                return  "redirect:/user/userInfo";
            }
        } else {
            model.addAttribute("errorInfo", "验证码错误，请重新输入");
            return "/user/login";
        }
    }

    /**
     * 用户注册
     *
     * @param model
     * @param request
     * @param session
     * @param user
     * @return
     */
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String userRegister(Model model, HttpServletRequest request, HttpSession session, User user) {
        String inputVerifyCode = request.getParameter("verifyCode");
        String verifyCodeValue = (String) session.getAttribute("verifyCodeValue");
        if (verifyCodeValue.equals(inputVerifyCode.toUpperCase())) {
            //激活码
//            String activeCode = UUID.randomUUID().toString();
//            user.setCode(activeCode);
//            String userid = UUID.randomUUID().toString();
//            user.setUserid(userid);
            user.setPassword(MD5Utils.md5(user.getPassword()));
//            int k = userService.checkUsername(user.getUsername());
//            if(k==0) {
            int i = userService.Register(user);
            if (i > 0) {
                //发送激活邮件
//                String emailMsg = "恭喜您注册成功，请点击下面的连接进行激活账户"
//                        + "<a href='http://localhost:8088/active?activeCode=" + activeCode + "'>"
//                        + "http://localhost:8088/active?activeCode=" + activeCode + "</a>";
//                String info = "恭喜你注册成功！转至主页";
//                try {
//                    MailUtils.sendMail(user.getEmail(), emailMsg);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
                model.addAttribute("errorInfo", "恭喜你注册成功！转至主页");
                return "user/login";//注册成功到登陆界面
            }
            model.addAttribute("errorInfo", "注册用户失败！");
            return "user/register";//插入注册数据失败
//            }
//            model.addAttribute("errorInfo","用户名已经存在！");
//            return "user/register";//用户名已经存在
        } else {
            model.addAttribute("errorInfo", "验证码错误！");
            return "user/register";//验证码输入错误返回登陆界面
        }
    }

    /*
    用户注册
    * */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String UserRegister(Model model, HttpSession session, User user, HttpServletRequest request) {
        String inputVerifyCode = request.getParameter("verifyCode");
        String verifyCodeValue = (String) session.getAttribute("verifyCodeValue");
        if (verifyCodeValue.equals(inputVerifyCode.toUpperCase())) {
            user.setPassword(MD5Utils.md5(user.getPassword()));
            int k = userService.CheckUsername(user.getUsername());
            if (k == 0) {
                int i = userService.Register(user);
                if (i == 1) {
                    model.addAttribute("errorInfo", "恭喜你注册成功！转至主页");
                    return "user/login";//转到登录页
                } else {
                    model.addAttribute("errorInfo", "注册失败，已注册过账户");
                    return "user/register";
                }

            } else {
                model.addAttribute("errorInfo", "用户名已存在！");
                return "user/register";
            }
        } else {
            model.addAttribute("errorInfo", "验证码错误！");
            return "user/register";
        }
    }

    //修改用户信息
    @RequestMapping(value = "/updateInfo")
    public @ResponseBody String UpdateInfo(User user, HttpSession session, HttpServletRequest request) {
        User user1 = (User) session.getAttribute("user");
        user.setUserid(user1.getUserid());
        userService.UpdateInfo(user);
        return "OK";
    }

    //修改用户密码
    @RequestMapping(value = "updatePwd")
    public String UpdatePass(String oldPass, String newPass, HttpSession session, HttpServletRequest request) {
        User user = (User) session.getAttribute("user");
        user.setPassword(MD5Utils.md5(oldPass));
        User u = userService.UserLogin(user);
        if (u != null && u.getPassword() != null) {
            user.setPassword(MD5Utils.md5(newPass));
            userService.UpdateInfo(user);
            return "OK";
        } else {
            return "error";

        }
    }

    /*用户注销*/
    @RequestMapping(value = "/logout")
    public String Logout(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        //删除session
        session.removeAttribute("user");

        //删除Cookies
        Cookie cookie_username =new Cookie("cookie_username","");
        cookie_username.setMaxAge(0);
        Cookie cookie_password =new Cookie("cookie_password","");
        cookie_password.setMaxAge(0);

        response.addCookie(cookie_username);
        response.addCookie(cookie_password);

        return "user/login";
    }

}
