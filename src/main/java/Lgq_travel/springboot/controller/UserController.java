package Lgq_travel.springboot.controller;

import Lgq_travel.springboot.entity.QueryVo;
import Lgq_travel.springboot.entity.User;
import Lgq_travel.springboot.service.UserService;
import Lgq_travel.springboot.utils.MD5Utils;
import Lgq_travel.springboot.utils.MailUtils;
import Lgq_travel.springboot.utils.Page;
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

    /*
    用户登录
    * */
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
                        //要自动登录
                        //创建存储用户名的cookie
                        Cookie cookie_username = new Cookie("cookie_username", user.getUsername());
                        cookie_username.setMaxAge(10 * 60);
                        //创建存储密码的cookie
                        Cookie cookie_password = new Cookie("cookie_password", user.getPassword());
                        cookie_password.setMaxAge(10 * 60);
                        response.addCookie(cookie_username);
                        response.addCookie(cookie_password);
                    }
                    //将user对象存到session中
                    session.setAttribute("user", u);
                    return "redirect:/user";
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
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String UserRegister(Model model, HttpSession session, User user, HttpServletRequest request) {
        String inputVerifyCode = request.getParameter("verifyCode");
        System.out.println("在这里！！！user:"+user);
        String verifyCodeValue = (String) session.getAttribute("verifyCodeValue");
        if (verifyCodeValue.equals(inputVerifyCode.toUpperCase())) {
            user.setPassword(MD5Utils.md5(user.getPassword()));
            int k = userService.CheckUsername(user.getUsername());
            if (k == 0) {
                int i = userService.Register(user);
                if (i == 1) {
                    //转到登录页
                    model.addAttribute("errorInfo", "恭喜你注册成功！转至主页");
                    return "user/login";
                } else {
                    //插入注册数据失败
                    model.addAttribute("errorInfo", "注册失败，已注册过账户");
                    return "user/register";
                }

            } else {
                //用户名已经存在
                model.addAttribute("errorInfo", "用户名已存在！");
                return "user/register";
            }
        } else {
            //验证码输入错误返回登陆界面
            model.addAttribute("errorInfo", "验证码错误！");
            return "user/register";
        }
    }

    /*
    修改用户信息
    */
    @RequestMapping(value = "/updateInfo")
    public @ResponseBody String UpdateInfo(User user, HttpSession session, HttpServletRequest request) {
        User user1 = (User) session.getAttribute("user");
        user.setUserid(user1.getUserid());
        System.out.println("user:"+user);
        userService.UpdateInfo(user);
        return "OK";
    }

    /*
    修改用户密码
    */
    @RequestMapping(value = "updatePwd")
    public String UpdatePass(String oldpwd, String newpwd, HttpSession session, HttpServletRequest request) {
        User user = (User) session.getAttribute("user");
        System.out.println("oldpwd:"+oldpwd+",newpwd"+newpwd);
        user.setPassword(MD5Utils.md5(oldpwd));
        User u = userService.UserLogin(user);
        if (u != null && u.getPassword() != null) {
            user.setPassword(MD5Utils.md5(newpwd));
            userService.UpdateInfo(user);
            return "OK";
        } else {
            return "error";

        }
    }

    /*
    用户注销
    */
    @RequestMapping(value = "/logout")
    public String Logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        //删除session
        session.removeAttribute("user");

        //删除Cookies
        Cookie cookie_username = new Cookie("cookie_username", "");
        cookie_username.setMaxAge(0);
        Cookie cookie_password = new Cookie("cookie_password", "");
        cookie_password.setMaxAge(0);

        response.addCookie(cookie_username);
        response.addCookie(cookie_password);

        return "user/login";
    }

    /**
     * 管理员查看所有用户
     */
    @RequestMapping(value="/manageVisitor")
    public String getPageTest(QueryVo vo, Model model){
        Page<User> page = userService.selectPageByQueryVo(vo);
        model.addAttribute("page", page);
        model.addAttribute("name",vo.getName());
        return "manager/visitor";
    }

    /**
     * 管理员禁用用户
     */
    @RequestMapping(value = "/updateUserState")
    public @ResponseBody
    String updateState(String id){
        userService.updateStateById(id);
        return "OK";
    }

    /**
     * 管理员解禁用户
     */
    @RequestMapping(value = "/updateUserState1")
    public @ResponseBody
    String updateState1(String id){
        userService.updateStateBy1Id(id);
        return "OK";
    }

}
